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

import com.patriciomartin.models.Urls;


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
		 	boolean urlExists = false;
		 	
		 	//THIS WILL REWRITE THE URL IF SOMEONE IS READING ENGLISH PAGE AND THEY REQUEST THE SPANISH URL FOR ANOTHER PAGE - IT WILL CHANGE IT BACK TO ENGLISH
		 	checkIfNeedToReWriteURLCauseLanguage(request, response, req);

		 	
		 	
//		 	else if(req.equals("/about/") || req.equals("/acerca-de/"))
//    			page = "about.jsp";
		 	
		 	HashMap<String, String> urls = (HashMap<String, String>) Urls.URL_MAP;
			for(Entry<?, ?> e: urls.entrySet()){
				String url = (String) e.getKey();
				String jsp = (String) e.getValue();
			
				if(req.equals(url)) {
					page = jsp;
					urlExists = true;
					break;
				}
			
			}
			if(!urlExists) {
				if(req.startsWith("/wd-admin/") || isAServlet(request)) {
		    		continueChain = true;
					}else {
						page = "error.jsp";
					}
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
