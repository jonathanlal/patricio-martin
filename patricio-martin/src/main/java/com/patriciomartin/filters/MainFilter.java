package com.patriciomartin.filters;

import java.io.IOException;
import java.lang.reflect.Field;
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
    public MainFilter() {}
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String requri = ((HttpServletRequest) request).getRequestURI();
		page = null; //reset
		continueChain = false; //reset
		if(Globals.IS_i18n)
	 		requri = checkBaseURLLanguage(request, response, requri); // /es/ --> /en/
			if(Globals.IS_URLMAPS_XML) { 
				doXML(request, response, chain, requri);
			}else {
				doReflection(request, response, chain, requri);
			}
			decideFate(request, response, chain);
//		continueChain = true;
//		decideFate(request, response, chain);
	}
	private void doXML(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
		List<Url> url_map = UrlMap.getUrlMappingsXML();
		HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(url_map); //gets all url mappings via XML -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS) //if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
		checkIfNeedToReWriteURLCauseLanguageXML(request, response, requri,url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		wildCardOrServlet(request, response, chain, requri, urls, isWildCardXML(requri, url_map));
	}
	private void doReflection(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
		Field[] url_map = Mappings.class.getDeclaredFields(); //reflection
		HashMap<String, String> urls = UrlMap.getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS)//if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri, url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		wildCardOrServlet(request, response, chain, requri, urls, isWildCard(requri, url_map));
	}
	private void decideFate(ServletRequest request, ServletResponse response, FilterChain chain) {
		try { if(!continueChain){	
		    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response); return;
    	}else{chain.doFilter(request, response);}}catch(Exception e){e.printStackTrace();}
	}
	private void wildCardOrServlet(ServletRequest request, ServletResponse response, FilterChain chain, String requri, HashMap<String, String> urls, boolean isWildcard) {
	 	 page = urls.get(requri); //it will return null here for wildcard mappings because they have not call attribute. 
	 	 if(page == null || page.equals("*"))  //if page is null at this point it means the url is not in map (with exception of wildcards)
	 	 checkIfWildCardOrServlet(request, response, chain, isWildcard);
	}
	private void checkIfWildCardOrServlet(ServletRequest request, ServletResponse response, FilterChain chain, boolean isWildcard) {
		
		if(isWildcard) {
			try {
				processWildCard(request, response, chain);
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}
		}else if(isAServlet(request)) {
			continueChain = true;
		}else {
			page = "error.jsp";
		}
	}
	private void processWildCard(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
//		WDAdmin wd = new WDAdmin();
//		wd.hello("hello");
//		wd.AdminAreaFilter(request, response, chain);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private String getSessionLanguage(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
		if(current_lang == null) {current_lang = Globals.DEFAULT_LANG;}
		return current_lang;
	}
	private String checkBaseURLLanguage(ServletRequest request,ServletResponse response, String requri) throws IOException {
		String current_lang = getSessionLanguage(request);
		String[] languages = Globals.LANGUAGES;
		String base_in_url = null;
		boolean hasBase = false;
		for(String lang: languages) {hasBase = Pattern.compile("\\/"+lang+"\\/").matcher(requri).find();
			if(hasBase) {
			base_in_url = lang;
			break;
			}
		}
		if(hasBase) {	
			if(!base_in_url.equals(current_lang)) {
			requri = requri.replace("/"+base_in_url+"/", "/"+current_lang+"/"); //if current session language not equal to the language in the base url then change it 
			((HttpServletResponse) response).sendRedirect(requri);}
		}else{       
			((HttpServletResponse) response).sendRedirect(current_lang+requri);		//add language_base to url because it doesn't have a base
		}
		return requri.replace("/"+current_lang+"/", "/"); //replace it back to normal so that doesn't fuck up the hashmap check thing
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
				 StringBuffer url = ((HttpServletRequest) request).getRequestURL();
				 String uri = ((HttpServletRequest) request).getRequestURI();
				 String base = url.substring(0, url.length() - uri.length()) + "/";
				((HttpServletResponse) response).sendRedirect(base+language_base+alternate_url); //just incase whatever application has more than a couple directory deeps
			}
	}
	private void checkIfNeedToReWriteURLCauseLanguageXML(ServletRequest request, ServletResponse response, String requri, List<Url> url_map) throws IOException {
		String language_base = getSessionLanguage(request); // does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappingsXML(url_map); // same as above but using getting with xml
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !language_base.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = UrlMap.getURLanguageEquivalentXML(language_base, requri, url_map);//REWRITE LOGIC BLOCK
				((HttpServletResponse) response).sendRedirect(language_base+alternate_url); //just incase whatever application has more than a couple directory deeps
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
//	private boolean isResourceFile(String requri) {//checks if it's like .png .css .woff .jpg
//	if(Arrays.stream(Globals.STATIC_CONTENT_EXT).allMatch(requri::contains)) {return true;
//	}else {return false;}
//}
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
