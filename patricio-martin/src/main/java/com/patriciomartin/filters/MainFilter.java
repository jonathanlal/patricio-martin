package com.patriciomartin.filters;

import java.io.IOException;
import java.util.HashMap;
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

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.UrlMap;
import com.patriciomartin.objects.Urls;


@WebFilter({ "/*" })
public class MainFilter implements Filter {

    private static final long MEGABYTE = 1024L * 1024L;
    public MainFilter() {
    }
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("hello");
	}
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		  Runtime runtime = Runtime.getRuntime();
		doReflection(request, response, chain, runtime);

	}
	public void doXML(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
		  long start = System.currentTimeMillis();
		  

		  String requri = ((HttpServletRequest) request).getRequestURI();
	 	boolean continueChain = false;
	 	HashMap<String, String> urls = UrlMap.getUrlJspMappingsXML(); //gets all url mappings via Reflection -> '/about/ , 'about.jsp'
	 	
	 	//WE NEED TO CHANG ETHIS MET
	 	if(Globals.IS_i18n)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	
	 	String page = urls.get(requri); //will return the value which would be the jsp 'about.jsp' with key '/about/'(requri is the same as the key)
	 	
	 	
	 	calculateCosts(runtime, start);

	 	
		if(page == null) {
//			if(requri.startsWith("/wd-admin/") || isAServlet(request)) {
//	    		continueChain = true;
//				}else {
//					page = "error.jsp";
//				}
//		}
//    	
//		if(!continueChain){	
//		    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response);
//		    return;
//    	}else{
//    		chain.doFilter(request, response);
//    	}
//    	
		  
		
	}
	public void calculateCosts(Runtime runtime, long start) {
	 	 // Run the garbage collector
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
        System.out.println(System.currentTimeMillis() - start);
		
	}
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

	public void doReflection(ServletRequest request, ServletResponse response, FilterChain chain, Runtime runtime) throws IOException, ServletException {
		  long start = System.currentTimeMillis();
		
		  String requri = ((HttpServletRequest) request).getRequestURI();
	 	boolean continueChain = false;
	 	HashMap<String, String> urls = UrlMap.getUrlJspMappings(null); //gets all url mappings via Reflection -> '/about/ , 'about.jsp'
	 	
	 	if(Globals.IS_i18n)
	 	checkIfNeedToReWriteURLCauseLanguage(request, response, requri); //THIS WILL REWRITE THE URL IF SESSION VARIABLE IS ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH BY GETTING THE ENGLISH URL
	 	
	 	String page = urls.get(requri); //will return the value which would be the jsp 'about.jsp' with key '/about/'(requri is the same as the key)
	 	
	 	
	 	calculateCosts(runtime, start);

	 	
		if(page == null) {
			if(requri.startsWith("/wd-admin/") || isAServlet(request)) {
	    		continueChain = true;
				}else {
					page = "error.jsp";
				}
		}
    	
		if(!continueChain){	
		    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response);
		    return;
    	}else{
    		chain.doFilter(request, response);
    	}
    	
	}
	public void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String requri, String test_type) throws IOException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String current_lang = (String) session.getAttribute("language");
		
		if(current_lang == null) { current_lang = Globals.DEFAULT_LANG;}
		
		 HashMap<String, String> urls = new HashMap<>();
		if(test_type.equals("reflection")) {
		urls = UrlMap.getUrlLanguageMappings(); // <'/about/', 'en'>
		}else {
		urls = UrlMap.getUrlLanguageMappingsXML();
		}
		}
		
		 	//if page_lange is null here then the requested url isn't in the map. Which means page_lang is null.
			String page_lang = urls.get(requri);
			
			
			//requested url exists and the language of that url does not match the session language 
			if(page_lang != null && !current_lang.equals(page_lang)) {
				//REWRITE LOGIC
				String alternate_url = null;
				if(test_type.equals("reflection")) {
				 alternate_url = UrlMap.getURLanguageEquivalent(current_lang, requri);
				}else {
				 alternate_url = UrlMap.getURLanguageEquivalentXML(current_lang, requri);
				}
				
				((HttpServletResponse) response).sendRedirect("../../../.."+alternate_url); //just incase whatever application has more than a couple directory deeps
				
			}
	}

	public boolean isAServlet(ServletRequest request){
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
	



	
}
