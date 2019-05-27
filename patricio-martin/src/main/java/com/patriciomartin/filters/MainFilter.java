package com.patriciomartin.filters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

import com.patriciomartin.database.PageStatsDao;
import com.patriciomartin.models.Globals;
import com.patriciomartin.models.Mappings;
import com.patriciomartin.models.UrlMap;
import com.patriciomartin.objects.Url;
import com.patriciomartin.objects.Urls;

//wildcard filter means we can also handle 404s
@WebFilter({ "/*" })
public class MainFilter implements Filter {

    private static final long MEGABYTE = 1024L * 1024L;
	boolean continueChain = false;
	String page = null;
//    List<Url> url_maps = new ArrayList<>();
    
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_RESET = "\u001B[0m";
	
	
	//TESTING
	 long start; //testing
	 Runtime runtime;//testing
	 String test_type;
	
    
    public MainFilter() {
    }
	public void init(FilterConfig fConfig) throws ServletException {
	}
	/**
	 * Atm the list of urls is either stored as class variable arrays in Mappings.java or as xml in /WEB-INF/url-mappings.xml
	 * We can get the list from Mappings.java with Reflection API or we can get the list from the xml with JAXB
	 * Once we get one or ther other we need to store this as a session variable because it's an expensive operation and we don't want to keep doing it 
	 * on every request
	 * 
	 * This function should fire everytime in the init
	 * 
	 * @return List<Url> url_maps
	 */
//	public List<Url> getUrlMapping(ServletRequest request) {
//	 	HttpSession session = (((HttpServletRequest) request).getSession());
//	 	if(session.getAttribute("url_maps") != null) {
//	 		return (List<Url>) session.getAttribute("url_maps");
//	 	}else {
//	 		return 
//	 	}
		//check if session variable exists
			//url_maps = session variable
		//else get mapping from Mappings.java or url-mappings.xml
			//and url_maps = that. 
//	}
	public void destroy() {
	}
	public void startTest(ServletRequest request) {
		   start = System.currentTimeMillis(); //testing
		   runtime = Runtime.getRuntime();//testing
		   test_type = ((HttpServletRequest) request).getParameter("type");//testing
		   if(test_type == null) {test_type = "xml";} //testing
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//startTest(request); //testing
		page = null; //reset as false just in case
		continueChain = false; //reset as false just in case
	    String requri = ((HttpServletRequest) request).getRequestURI();
	    boolean isResource = isResourceFile(requri); //check if request is a resource
	    System.out.println("isResource: "+isResource);
	    if(!isResource) {
			if(Globals.IS_URLMAPS_XML) { //our url mapping implementation (are we storing it as url-mappings.xml or Mappings.java ?
	    	//if(test_type.equals("xml")) { //testing
				doXML(request, response, chain, requri);
			}else {
				doReflection(request, response, chain, requri);
			}
	    }
	    //calculateCosts(runtime, start, requri, test_type); //testing
		decideFate(request, response, chain);
	}
	private void doXML(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
		List<Url> url_map = UrlMap.getUrlMappingsXML();
		HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(url_map); //gets all url mappings via XML -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n)
	 	checkIfNeedToReWriteURLCauseLanguageXML(request, response, requri, "xml", url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	 page = urls.get(requri); //it will return null here for wildcard mappings because they have not call attribute. 
	 	System.out.println("page: "+page);
	 	 if(page == null)  //if page is null at this point it means the url is not in map (with exception of wildcards)
	 	 checkIfWildCardOrServlet(requri, request, isWildCardXML(requri, UrlMap.getUrlMappingsXML()));
	}
	private void doReflection(ServletRequest request, ServletResponse response, FilterChain chain, String requri) throws IOException, ServletException {
		Field[] url_map = Mappings.class.getDeclaredFields();//REFLECTION API
		HashMap<String, String> urls = UrlMap.getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'	
		if(Globals.IS_i18n && Globals.REWRITE_i18n_URLS)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri, "reflection", url_map); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	 page = urls.get(requri); //it might not be null for wildcard mappings here if they match exactcly... which means the value is '*' 
	 	 if(page == null || page.equals("*"))  //if page is null at this point it means the url is not in map (with exception of wildcards because they ommit the name value in case of reflection method or use * in remaining elements for class variable mappings
	 	 checkIfWildCardOrServlet(requri, request, isWildCard(requri, url_map));
	}
	private void checkIfWildCardOrServlet(String requri, ServletRequest request, boolean isWildcard) {
		if(isWildcard|| isAServlet(request)) {
    		continueChain = true;
			}else {
				String error = "Requested url \"<strong>"+requri+"</strong>\" is not a wildcard or a servlet either!";
				page = "error.jsp?error="+error;
			}
	}
	private void decideFate(ServletRequest request, ServletResponse response, FilterChain chain) {
		try { if(!continueChain){	
		    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response); return;
    	}else{chain.doFilter(request, response);}}catch(Exception e){e.printStackTrace();}
	}
	private boolean isResourceFile(String requri) {//checks if it's like .png .css .woff .jpg
		if(containsItemFromArray(requri)) {return true;
		}else {return false;}
	}
	private static boolean containsItemFromArray(String inputString) {
	    return Arrays.stream(Globals.STATIC_CONTENT_EXT).allMatch(inputString::contains);
	}
	private boolean isWildCardXML(String url, List<Url> url_maps) {
		if(UrlMap.getWildcardMappingsXML(url_maps).get(url) != null) {return true;
		}else {return false;}
	}
	private boolean isWildCard(String url, Field[] fields) {
		if(UrlMap.getWildcardMappings(fields).get(url) != null) {return true;
		}else {return false;}
	}
	private void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String requri, String test_type, Field[] fields) throws IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
		if(current_lang == null) { current_lang = Globals.DEFAULT_LANG;}
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !current_lang.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalent(current_lang, requri, fields);
				((HttpServletResponse) response).sendRedirect("../../../.."+alternate_url); //just incase whatever application has more than a couple directory deeps
			}
	}
	private void checkIfNeedToReWriteURLCauseLanguageXML(ServletRequest request, ServletResponse response, String requri, String test_type, List<Url> url_map) throws IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
		if(current_lang == null) { current_lang = Globals.DEFAULT_LANG;}
		HashMap<String, String> urls = new HashMap<>();
			urls = UrlMap.getUrlLanguageMappingsXML(url_map); // same as above but using getting with xml
			String page_lang = urls.get(requri);//if page_lange is null here then the requested url isn't in the map or key is null(wildcards)
			if(page_lang != null && !current_lang.equals(page_lang)) {//requested url exists and the language of that url does not match the session language 
				String alternate_url = null;//REWRITE LOGIC BLOCK
				 alternate_url = UrlMap.getURLanguageEquivalentXML(current_lang, requri, url_map);
				((HttpServletResponse) response).sendRedirect("../../../.."+alternate_url); //just incase whatever application has more than a couple directory deeps
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
	
//	long start = System.currentTimeMillis(); //add this to begginng of thing you wantto gtest
//	  Runtime runtime = Runtime.getRuntime();
//	doTest(request, response, chain, runtime);
	public void calculateCosts(Runtime runtime, long start, String requri, String type) {
		runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		PageStatsDao.recordRequest(requri+"?type="+type, "Used memory is bytes: " + memory + ". And megabytes: "+bytesToMegabytes(memory), System.currentTimeMillis() - start+"", type);
		System.out.println("Used memory is bytes: " + memory + ". And megabytes: "+bytesToMegabytes(memory));
		System.out.println(System.currentTimeMillis() - start+"ms");
	}
	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	
}
