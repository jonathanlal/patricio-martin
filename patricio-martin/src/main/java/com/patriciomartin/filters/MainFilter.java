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
import javax.servlet.RequestDispatcher;
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
	
	 String page = null;
//	 boolean doRedirect = false;
	 String redirectURL = null;
    public MainFilter() {}
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("-------------------------------------");
//		System.out.println("***************FILTER****************");
		 boolean continueChain = false;
		 redirectURL = null;
		 page = null;
		String requri = ((HttpServletRequest) request).getRequestURI();
		//System.out.println("filter hit with: "+requri);
//		continueChain = false; //reset
		if(Globals.IS_i18n)
	 		requri = checkBaseURLLanguage(request, response, requri); // /es/ --> /en/ (returns URI without language base
			if(Globals.IS_URLMAPS_XML) { 
				continueChain = doXML(request, response, chain, requri, continueChain);
			}else {
				continueChain = doReflection(request, response, chain, requri,continueChain);
			}
			decideFate(request, response, chain, continueChain);
//		continueChain = true;
//		decideFate(request, response, chain);
	}
	private boolean doXML(ServletRequest request, ServletResponse response, FilterChain chain, String requri, boolean continueChain) throws IOException, ServletException {
		List<Url> url_map = UrlMap.getUrlMappingsXML();
		HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(url_map); //gets all url mappings via XML -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS) //if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
		checkIfNeedToReWriteURLCauseLanguageXML(request, response, requri,url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		return wildCardOrServlet(request, response, chain, requri, urls, isWildCardXML(requri, url_map), continueChain);
	}
	private boolean doReflection(ServletRequest request, ServletResponse response, FilterChain chain, String requri, boolean continueChain) throws IOException, ServletException {
		Field[] url_map = Mappings.class.getDeclaredFields(); //reflection
		HashMap<String, String> urls = UrlMap.getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS)//if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri, url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		return wildCardOrServlet(request, response, chain, requri, urls, isWildCard(requri, url_map), continueChain);
	}
	private void decideFate(ServletRequest request, ServletResponse response, FilterChain chain, boolean continueChain) throws ServletException, IOException {
		//System.out.println("continueChain: "+continueChain);
//		System.out.println("***************FILTER****************");
//		System.out.println("-------------------------------------");

//		 if(!response.isCommitted()) {
		if(continueChain){	
			chain.doFilter(request, response);
    		return;
    	}else if(redirectURL != null){
    		doRedirect(response, redirectURL);
    	}else{
    		
    		RequestDispatcher rd = request.getRequestDispatcher("/GetPage?page="+page);
		    rd.forward(request, response);
		    return;
    	}
	}
	private boolean wildCardOrServlet(ServletRequest request, ServletResponse response, FilterChain chain, String requri, HashMap<String, String> urls, boolean isWildcard, boolean continueChain) {
		page = urls.get(requri); //it will return null here for wildcard mappings because they have not call attribute. 
		System.out.println("wildCardOrServlet requri: "+requri);
		System.out.println("wildCardOrServlet page: "+page);
		if(page == null || page.equals("*"))  //if page is null at this point it means the url is not in map (with exception of wildcards)
	 	 return checkIfWildCardOrServlet(request, response, chain, isWildcard, continueChain);
	 	 else 
	 	 return false;
	 	 
	}
	private boolean checkIfWildCardOrServlet(ServletRequest request, ServletResponse response, FilterChain chain, boolean isWildcard, boolean continueChain) {
		
		if(isWildcard) {
			try {
				processWildCard(request, response, chain);
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}
		}
		if(isAServlet(request)) {
			continueChain = true;
		}else {
			page = "error.jsp";
		}
		return continueChain;
	}
	private void processWildCard(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("processing wildcard!");
		try {
//		WDAdmin wd = new WDAdmin();
//		wd.hello("hello");
//		wd.AdminAreaFilter(request, response, chain);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**This takes the request and checks to see what language has been set, if no language has been set and no language in url then default 
	 * 
	 * @param request
	 * @param lang_in_url
	 * @return
	 */
	private String getCurrentLang(ServletRequest request, String lang_in_url) {
		
		//here we need to get the language of the URL also... if the langauge in the url is "es" 
//		if(lang_in_url == null) {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
			if(current_lang == null) {current_lang = Globals.DEFAULT_LANG;}
		return current_lang;
//		}else {
//			return lang_in_url;
//		}
	}
	private String checkBaseURLLanguage(ServletRequest request,ServletResponse response, String requri) throws IOException {
	
		String[] languages = Globals.LANGUAGES;
		String base_in_url = null;
		boolean hasBase = false;
		for(String lang: languages) {hasBase = Pattern.compile("\\/"+lang+"\\/").matcher(requri).find();
			if(hasBase) {
			base_in_url = lang;
			break;
			}
		}
		
		String current_lang = getCurrentLang(request, base_in_url); //coool
		if(current_lang == null && hasBase) {
			current_lang = base_in_url;
			}
//		System.out.println("requri: "+requri);
//		System.out.println("hasBase : "+hasBase);
	
		if(hasBase) {	
			//if session language is empty and base in url is different

			if(!base_in_url.equals(current_lang)) {
//				System.out.println("CURRENT LANG: "+current_lang);
//				System.out.println("base_in_url: "+base_in_url);
				HttpSession session = ((HttpServletRequest) request).getSession();
				session.setAttribute("language", base_in_url);
				//we need to make a check here
				//this redirect is here because if the base language changes, then it will rewrite the url so it's in whatever language it needs to be
				//
				//System.out.println("CHANGE REDIRECTURL: HAS BASE");
				//redirectURL = requri;
			}
			
		}
		else {
//			System.out.println("CHANGE REDIRECTURL: DOES NOT HAVE BASE");
			//we only need to redirect here when we are doing like servlet actions and we want to rewrite the url after
			redirectURL = "/"+current_lang+requri;
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
	private void doRedirect(ServletResponse response, String requri) {
//		System.out.println("DOING REDIRECT TO: "+requri);
		 try {
			((HttpServletResponse) response).sendRedirect(requri);
			 return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String requri, Field[] fields) throws IOException {
		String language_base = getCurrentLang(request, null);// does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			
//			 System.out.println("requri: "+requri);
			 
			 
				String[] languages = Globals.LANGUAGES;
				String base_in_url = null;
				boolean hasBase = false;
				for(String lang: languages) {
					hasBase = Pattern.compile("\\/"+lang+"\\/").matcher(requri).find();
					if(hasBase) {
					base_in_url = lang;
					break;
					}
				}
				if(hasBase) {
					requri = requri.replace("/"+base_in_url+"/", "/");
				}
			 
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			
//			 System.out.println("page_lang: "+page_lang);
//			 System.out.println("language_base: "+language_base);
			
			if(page_lang != null && !language_base.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalent(language_base, requri, fields);
				 StringBuffer url = ((HttpServletRequest) request).getRequestURL();
				 String uri = ((HttpServletRequest) request).getRequestURI();
				 String base = url.substring(0, url.length() - uri.length()) + "/";
//				 doRedirect(response, base+language_base+alternate_url);
				 
//				 System.out.println("CHANGE REDIRECTURL: checkIfNeedToReWriteURLCauseLanguage");
//				 System.out.println("redirectURL: "+base+language_base+alternate_url);
				 redirectURL = base+language_base+alternate_url;
			}
	}
	private void checkIfNeedToReWriteURLCauseLanguageXML(ServletRequest request, ServletResponse response, String requri, List<Url> url_map) throws IOException {
		String language_base = getCurrentLang(request, null); // does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappingsXML(url_map); // same as above but using getting with xml
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !language_base.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = UrlMap.getURLanguageEquivalentXML(language_base, requri, url_map);//REWRITE LOGIC BLOCK
				 redirectURL = language_base+alternate_url;
//				doRedirect(response, language_base+alternate_url);
//				 return;
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
