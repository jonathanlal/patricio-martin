package com.patriciomartin.filters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
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
	 String default_lang = Globals.DEFAULT_LANG; //it's init as the default lang but will change towhatever is set in the url
	 String base_lang = null;
	 boolean hasBase = false;
	 String redirectURL = null;
	 boolean isI18n = Globals.IS_i18n;
	 boolean isI18nAndRewriteEnabled = Globals.REWRITE_i18n_URLS && isI18n; 
    public MainFilter() {}
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("-------------------------------------");
//		System.out.println("***************FILTER****************");
//		System.out.println("filter hit with: "+requri);
		 boolean continueChain = false;
		 redirectURL = null;
		 page = null;
		String requri = ((HttpServletRequest) request).getRequestURI();
		if(isI18n)
	 		requri = removeBaseLang(request, response, requri); // /es/ --> /en/ (returns URI without language base if it exists)
			if(Globals.IS_URLMAPS_XML) { 
				continueChain = doXML(request, response, chain, requri, continueChain);
			}else {
				continueChain = doReflection(request, response, chain, requri,continueChain);
			}
			//System.out.println("continueChain: "+continueChain);
			decideFate(request, response, chain, continueChain);
	}
	private boolean doXML(ServletRequest request, ServletResponse response, FilterChain chain, String requri, boolean continueChain) throws IOException, ServletException {
		List<Url> url_map = UrlMap.getUrlMappingsXML();
		HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(url_map); //gets all url mappings via XML -> '/about/ , 'about.jsp'	
		if(isI18nAndRewriteEnabled) //if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
		checkIfNeedToReWriteURLCauseLanguageXML(request, response, requri,url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		return wildCardOrServlet(request, response, chain, requri, urls, isWildCardXML(requri, url_map), continueChain);
	}
	private boolean doReflection(ServletRequest request, ServletResponse response, FilterChain chain, String requri, boolean continueChain) throws IOException, ServletException {
		Field[] url_map = Mappings.class.getDeclaredFields(); //reflection
		HashMap<String, String> urls = UrlMap.getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'	
		if(isI18nAndRewriteEnabled)//if website is multilingual and you want to rewrite the url because they requested the wrong language url (kinda a waste to do, shouldn't really do it to support an edge case)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri, url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
		return wildCardOrServlet(request, response, chain, requri, urls, isWildCard(requri, url_map), continueChain);
	}
	private void decideFate(ServletRequest request, ServletResponse response, FilterChain chain, boolean continueChain) throws ServletException, IOException {
		//System.out.println("continueChain: "+continueChain);
//		System.out.println("***************FILTER****************");
//		System.out.println("-------------------------------------");

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
	
		boolean check = false;
		
//				get the string between first occurance of /xxxxx/
//		Pattern pattern = Pattern.compile("\\/(.*?)\\/");
//		Matcher matcher = pattern.matcher(requri);
//		if (matcher.find()) {
//			requri = "/"+matcher.group(1)+"/";
//		}
		
		
		
		page = urls.get(requri); //it will return null here for wildcard mappings because they have not call attribute. 
		System.out.println("wildCardOrServlet requri: "+requri);
		//System.out.println("wildCardOrServlet page: "+page);
		if(page == null || page.equals("*")) {  //if page is null at this point it means the url is not in map (with exception of wildcards)
			check = true;
			checkIfWildCardOrServlet(request, response, chain, isWildcard, continueChain);
		}
		
		
		return check;
	 	 
	}
	private void checkIfWildCardOrServlet(ServletRequest request, ServletResponse response, FilterChain chain, boolean isWildcard, boolean continueChain) {
		//System.out.println("isWildcard:"+isWildcard);
		if(isWildcard) {
			continueChain = true;
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
//		return continueChain;
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
		
	/**
	 * takes the full requri and returns the language that is set, returns null if nothing is set
	 * or if a language that isn't supported is set
	 * 
	 * @param requri
	 * @return lang 'es','en', null
	 */
	private String getLangBaseFromUrl(String requri) {
		String uri_lang = null;
		for(String lang: Globals.LANGUAGES) {
			if(Pattern.compile("\\/"+lang+"\\/").matcher(requri).find()) {
				uri_lang = lang;
				break;
			}
		}
		return uri_lang;
	}
	/** returns requri without the baseLang. if no language base is set, 
	 * get the language of the requri /about/ then set redirect to that page. Otherwise set default language. */
	private String removeBaseLang(ServletRequest request,ServletResponse response, String requri) throws IOException {
		String url_base_lang = getLangBaseFromUrl(requri); //es,en,null
		if(url_base_lang == null) {
			Field[] fields = Mappings.class.getDeclaredFields(); 
			HashMap<String, String> urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			String page_lang_mapping = urls.get(requri);
			if(page_lang_mapping != null) {
				base_lang = page_lang_mapping;
				redirectURL = "/"+page_lang_mapping+requri;
			}else {
			base_lang = default_lang;
			//we only need to redirect here when we are doing like servlet actions and we want to rewrite the url after
			redirectURL = "/"+default_lang+requri;
			}
		}else {
			base_lang = url_base_lang;
			HttpSession session = ((HttpServletRequest) request).getSession();
			session.setAttribute("language", url_base_lang);
		}
		return requri.replace("/"+base_lang+"/", "/"); //replace it back to normal so that doesn't fuck up the hashmap check thing
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
	/** Rewrite if the page_lang /about/ is not the same as the base_lang /es/ */
	private void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String requri, Field[] fields) throws IOException {
		HashMap<String, String> urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			String page_lang_mapping = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang_mapping != null && !page_lang_mapping.equals(base_lang)) {//requested url exists and the language of that url does not match the base language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalent(base_lang, requri, fields);
				 StringBuffer url = ((HttpServletRequest) request).getRequestURL();
				 String uri = ((HttpServletRequest) request).getRequestURI();
				 String base = url.substring(0, url.length() - uri.length()) + "/";
				 redirectURL = base+base_lang+alternate_url;
			}
	}
	private void checkIfNeedToReWriteURLCauseLanguageXML(ServletRequest request, ServletResponse response, String requri, List<Url> url_map) throws IOException {
//		String language_base = getCurrentLang(request, null); // does not have any slashes 'en'
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappingsXML(url_map); // same as above but using getting with xml
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !base_lang.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = UrlMap.getURLanguageEquivalentXML(base_lang, requri, url_map);//REWRITE LOGIC BLOCK
				 redirectURL = base_lang+alternate_url;
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
