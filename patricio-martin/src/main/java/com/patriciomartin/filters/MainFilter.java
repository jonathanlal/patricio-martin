package com.patriciomartin.filters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.Mappings;
import com.patriciomartin.models.UrlMap;
import com.patriciomartin.objects.Url;


@WebFilter({ "/*" })//wildcard filter on all requests means we can also handle 404s for app engine which doesnt support it...
public class MainFilter implements Filter {
	 boolean continueChain = false;
	 String page = null;
	 //long start; //testing
	 //Runtime runtime; //testing
	 //String test_type; //testing
	 //private static final long MEGABYTE = 1024L * 1024L; //testing
    public MainFilter() {}
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//startTest(request); //testing

	    String requri = ((HttpServletRequest) request).getRequestURI();
		page = null; //reset
		continueChain = false; //reset

//	    boolean isResource = isResourceFile(requri); //check if request is a resource (we don't really need to do this shit?...)
//	    if(!isResource) {
			if(Globals.IS_URLMAPS_XML) { //our url mapping implementation (are we storing it as url-mappings.xml or Mappings.java ?
	    	//if(test_type.equals("xml")) { //testing
				doXML(request, response, chain, requri);
			}else {
				doReflection(request, response, chain, requri);
			}
//	    }
	    //calculateCosts(runtime, start, requri, test_type); //testing
		decideFate(request, response, chain);
	}
	private void decideFate(ServletRequest request, ServletResponse response, FilterChain chain) {
		try { if(!continueChain){	
		    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response); return;
    	}else{chain.doFilter(request, response);}}catch(Exception e){e.printStackTrace();}
	}
	private boolean isResourceFile(String requri) {//checks if it's like .png .css .woff .jpg
		if(Arrays.stream(Globals.STATIC_CONTENT_EXT).allMatch(requri::contains)) {return true;
		}else {return false;}
	}
	private void doXML(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
		List<Url> url_map = UrlMap.getUrlMappingsXML();
		HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(url_map); //gets all url mappings via XML -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS) //if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
			checkIfNeedToReWriteURLCauseLanguageXML(request, response, requri,url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	 page = urls.get(requri); //it will return null here for wildcard mappings because they have not call attribute. 
	 	 if(page == null)  //if page is null at this point it means the url is not in map (with exception of wildcards)
	 	 checkIfWildCardOrServlet(requri, request, isWildCardXML(requri, UrlMap.getUrlMappingsXML()));
	}
	private void doReflection(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
	 	if(Globals.IS_i18n)
	 		requri = checkIfNeedToReWriteLanguageBase(request, response, requri); //need to modify request string and remove /en/ to not confuse when we check if url exists
	 	
		Field[] url_map = Mappings.class.getDeclaredFields();//REFLECTION API
		HashMap<String, String> urls = UrlMap.getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS)//if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri, url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	 page = urls.get(requri); //it might not be null for wildcard mappings here if they match exactcly... which means the value is '*' 
	 	System.out.println("page : "+page);
	 	 if(page == null || page.equals("*"))  //if page is null at this point it means the url is not in map (with exception of wildcards because they ommit the name value in case of reflection method or use * in remaining elements for class variable mappings
	 	 checkIfWildCardOrServlet(requri, request, isWildCard(requri, url_map));
	}
	private String getSessionLanguage(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
		if(current_lang == null) {current_lang = Globals.DEFAULT_LANG;}
		return current_lang;
	}
	private String checkIfNeedToReWriteLanguageBase(ServletRequest request,ServletResponse response, String requri) throws IOException {

		String current_lang = getSessionLanguage(request);
		
		//here the url doesn't have a language base so we should rewrite...
		
		String[] languages = Globals.LANGUAGES;
		//for each 
		String base_in_url = null;
		boolean hasBase = false;
		for(String lang: languages) {hasBase = Pattern.compile("\\/"+lang+"\\/").matcher(requri).find();
			if(hasBase) {base_in_url = lang;break;}
		}
		if(hasBase) {
			if(!base_in_url.equals(current_lang)) {
				requri = requri.replace("/"+base_in_url+"/", "/"+current_lang+"/"); //change wrong base 
				((HttpServletResponse) response).sendRedirect("../../../.."+getCorrectRequriDirectoryMapping(requri));	
			}
			
		}else {
			//add language_base to url
			((HttpServletResponse) response).sendRedirect("../../../../"+getCorrectRequriDirectoryMapping(current_lang+requri));	
		}
		return requri.replace("/"+current_lang+"/", "/");
	}
	private void checkIfWildCardOrServlet(String requri, ServletRequest request, boolean isWildcard) {
		if(isWildcard|| isAServlet(request)) {
    		continueChain = true;
			}else {page = "error.jsp";}
	}

	private boolean isWildCardXML(String url, List<Url> url_maps) {
		if(UrlMap.getWildcardMappingsXML(url_maps).get(url) != null) {return true;
		}else {return false;}
	}
	private boolean isWildCard(String url, Field[] fields) {
		if(UrlMap.getWildcardMappings(fields).get(url) != null) {return true;
		}else {return false;}
	}
	private void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String requri, Field[] fields) throws IOException {
		String language_base = getSessionLanguage(request);// does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !language_base.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalent(language_base, requri, fields);
				((HttpServletResponse) response).sendRedirect("../../../../"+getCorrectRequriDirectoryMapping(language_base+alternate_url)); //just incase whatever application has more than a couple directory deeps
			}
	}
	private void checkIfNeedToReWriteURLCauseLanguageXML(ServletRequest request, ServletResponse response, String requri, List<Url> url_map) throws IOException {
		String language_base = getSessionLanguage(request); // does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappingsXML(url_map); // same as above but using getting with xml
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !language_base.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalentXML(language_base, requri, url_map);
				((HttpServletResponse) response).sendRedirect("../../../../"+getCorrectRequriDirectoryMapping(language_base+alternate_url)); //just incase whatever application has more than a couple directory deeps
			}
	}
	private boolean isAServlet(ServletRequest request){
		boolean check = false;
	    ServletContext servletContext = ((HttpServletRequest) request).getSession().getServletContext();
		Map<String,? extends ServletRegistration> servlets = servletContext.getServletRegistrations();
		for (Entry<String, ? extends ServletRegistration> entry : servlets.entrySet())
			{
			if(entry.getValue().getMappings().toString().equals("["+((HttpServletRequest) request).getRequestURI()+"]"))
				check = true;
			}
		return check;
	}
	public String getCorrectRequriDirectoryMapping(String requri) {
		//takes the url and counts the number of forward slashes and returns requri with the correct mapping
		System.out.println("COUNTING:");
		System.out.println(requri.chars().filter(num -> num == '/').count());
		return requri;
	}
//	public void calculateCosts(Runtime runtime, long start, String requri, String type) {
//		runtime.gc();
//		long memory = runtime.totalMemory() - runtime.freeMemory();
//		PageStatsDao.recordRequest(requri+"?type="+type, "Used memory is bytes: " + memory + ". And megabytes: "+bytesToMegabytes(memory), System.currentTimeMillis() - start+"", type);
//		System.out.println("Used memory is bytes: " + memory + ". And megabytes: "+bytesToMegabytes(memory));
//		System.out.println(System.currentTimeMillis() - start+"ms");
//	}
//	public static long bytesToMegabytes(long bytes) {
//		return bytes / MEGABYTE;
//	}
//	public void startTest(ServletRequest request) {
//		   start = System.currentTimeMillis(); //testing
//		   runtime = Runtime.getRuntime();//testing
//		   test_type = ((HttpServletRequest) request).getParameter("type");//testing
//		   if(test_type == null) {test_type = "xml";} //testing
//	}
	
}
