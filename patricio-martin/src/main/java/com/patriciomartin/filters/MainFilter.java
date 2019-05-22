package com.patriciomartin.filters;

import java.io.IOException;
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


@WebFilter({ "/*" })
public class MainFilter implements Filter {

    public MainFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
			String req = ((HttpServletRequest) request).getRequestURI();
	        
		 	String page = "";
		 	boolean continueChain = false;
		 	
		 	//long startTime = System.nanoTime();
		 	//THIS WILL REWRITE THE URL IF SOMEONE IS READING ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH
		 	checkIfNeedToReWriteURLCauseLanguage(request, response, req);
		    //long endTime = System.nanoTime();
		    //long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
		    //System.out.println(durationInNano);
		    //System.out.println("time in mili: "+durationInNano / 1000000.0);
			
			
			
//		 	System.out.println("req: "+req);
	    	if(req.equals("/"))
    			page = "index.jsp";
	    	
	    	else if(req.equals("/about/") || req.equals("/acerca-de/"))
	    			page = "about.jsp";
	    	
	    	else if(req.equals("/services/") || req.equals("/servicios/"))
	    			page = "services.jsp";
	    	
	    	else if(req.equals("/contact/") || req.equals("/contacto/"))
    				page = "contact.jsp";
	    	
	    	else if(req.equals("/projects/") || req.equals("/projectos/"))
	    			page = "projects.jsp";
	    	
	    	else if(req.equals("/projects/la-cala/") || req.equals("/projectos/la-cala/"))
		    		page = "project.jsp&p=la-cala";
		    	
	    	else if(req.equals("/projects/san-eliseo/") || req.equals("/projectos/san-eliseo/"))
	    			page = "project.jsp&p=san-eliseo";
	    	
	    	else if(req.equals("/projects/domus/") || req.equals("/projectos/domus/"))
	    			page = "project.jsp&p=domus";
	    	
	    	else if(req.equals("/projects/rancho/") || req.equals("/projectos/rancho/"))
	    			page = "project.jsp&p=rancho";
	
	    	else if(req.equals("/terms/"))
	    			page = "terms.jsp";	
	    	
	    	else if(req.equals(("/test.jsp")))
	    		page = "test.jsp";
	    	
	    	
	    	else if(req.startsWith("/wd-admin/") || isAServlet(request))
	    		continueChain = true;
	    	
	    	else {
	    		page = "error.jsp";
	    	}
	    	
//	    	System.out.println("PAGE: "+page);
	    		if(!continueChain){	
				    request.getRequestDispatcher("/GetPage?page="+page).forward(request, response);
				    return;
		    	}else{
		    		chain.doFilter(request, response);
		    	}
	    	
	}
	public void checkIfNeedToReWriteURLCauseLanguage(ServletRequest request, ServletResponse response, String req) throws IOException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String lang = (String) session.getAttribute("language");

		if(lang == null || lang.equals("en")) {
			
			if(req.equals("/acerca-de/"))
				((HttpServletResponse) response).sendRedirect("../about/");
			else if(req.equals("/servicios/"))
				((HttpServletResponse) response).sendRedirect("../services/");
			else if(req.equals("/contacto/"))
				((HttpServletResponse) response).sendRedirect("../contact/");
			else if(req.equals("/projectos/"))
				((HttpServletResponse) response).sendRedirect("../projects/");
			else if(req.equals("/projectos/domus/"))
				((HttpServletResponse) response).sendRedirect("../projects/domus/");
			else if(req.equals("/projectos/la-cala/"))
				((HttpServletResponse) response).sendRedirect("../projects/la-cala/");
			else if(req.equals("/projectos/san-eliseo/"))
				((HttpServletResponse) response).sendRedirect("../projects/san-eliseo/");
			else if(req.equals("/projectos/rancho/"))
				((HttpServletResponse) response).sendRedirect("../projects/rancho/");
			
		}else if(lang.equals("es")) {
			
			if(req.equals("/about/"))
				((HttpServletResponse) response).sendRedirect("../acerca-de/");
			else if(req.equals("/services/"))
				((HttpServletResponse) response).sendRedirect("../servicios/");
			else if(req.equals("/contact/"))
				((HttpServletResponse) response).sendRedirect("../contacto/");
			else if(req.equals("/projects/"))
				((HttpServletResponse) response).sendRedirect("../projectos/");
			else if(req.equals("/projects/domus/"))
				((HttpServletResponse) response).sendRedirect("../projectos/domus/");
			else if(req.equals("/projects/la-cala/"))
				((HttpServletResponse) response).sendRedirect("../projectos/la-cala/");
			else if(req.equals("/projects/san-eliseo/"))
				((HttpServletResponse) response).sendRedirect("../projectos/san-eliseo/");
			else if(req.equals("/projects/rancho/"))
				((HttpServletResponse) response).sendRedirect("../projectos/rancho/");
			
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
