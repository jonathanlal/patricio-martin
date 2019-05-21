package com.patriciomartin.filters;

import java.io.IOException;
import java.util.HashSet;
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


@WebFilter({ "/*" })
public class MainFilter implements Filter {

    public MainFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
			String requri = ((HttpServletRequest) request).getRequestURI();
	        
		 	String page = "";
		 	boolean continueChain = false;
		 	
//		 	if(requri.endsWith("/") && requri.length()>1) {
//		 		page = requri.substring(1, requri.length()-1).concat(".jsp");
//		 	}
		 	System.out.println("requri: "+requri);
	    	if(requri.equals("/"))
    			page = "index.jsp";
	    	
	    	else if(requri.equals("/about/") || requri.equals("/about") || requri.equals("/acerca-de/") || requri.equals("/acerca-de"))
	    			page = "about.jsp";
	    	
	    	else if(requri.equals("/services/") || requri.equals("/services") || requri.equals("/servicios/") || requri.equals("/servicios"))
	    			page = "services.jsp";
	    	
	    	else if(requri.equals("/contact/") || requri.equals("/contact") || requri.equals("/contacto/") || requri.equals("/contacto"))
    				page = "contact.jsp";
	    	
	    	else if(requri.equals("/projects/") || requri.equals("/projects") || requri.equals("/projectos/") || requri.equals("/projectos"))
	    			page = "projects.jsp";
	    	
	    	else if(requri.equals("/projects/la-cala/") || requri.equals("/projects/la-cala") || requri.equals("/projectos/la-cala/") || requri.equals("/projectos/la-cala"))
		    		page = "project.jsp&p=la-cala";
		    	
	    	else if(requri.equals("/projects/san-eliseo/") || requri.equals("/projects/san-eliseo") || requri.equals("/projectos/san-eliseo/") || requri.equals("/projectos/san-eliseo"))
	    			page = "project.jsp&p=san-eliseo";
	    	
	    	else if(requri.equals("/projects/domus/") || requri.equals("/projects/domus") || requri.equals("/projectos/domus/") || requri.equals("/projectos/domus"))
	    			page = "project.jsp&p=domus";
	    	
	    	else if(requri.equals("/projects/rancho/") || requri.equals("/projects/rancho") || requri.equals("/projectos/rancho/") || requri.equals("/projectos/rancho"))
	    			page = "project.jsp&p=rancho";
	
	    	else if(requri.equals("/terms/") || requri.equals("/terms"))
	    			page = "terms.jsp";	
	    	
	    	else if(requri.equals(("/test.jsp")))
	    		page = "test.jsp";
	    	
	    	
	    	else if(requri.startsWith("/wd-admin/") || isAServlet(request))
	    		continueChain = true;
	    	
	    	else {
	    		page = "error.jsp";
	    	}
	    	
	    	System.out.println("PAGE: "+page);
	    		if(!continueChain){	
				    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response);
				    return;
		    	}else{
		    		chain.doFilter(request, response);
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
	


	public void init(FilterConfig fConfig) throws ServletException {
	}
}
