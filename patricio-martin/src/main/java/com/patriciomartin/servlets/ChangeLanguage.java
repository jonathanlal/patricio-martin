package com.patriciomartin.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeLanguage")
public class ChangeLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeLanguage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");	System.out.println("");
		System.out.println("############### CHANGE LANGUAGE ################");
		System.out.println("------------------------------------------------");
		HttpSession session = request.getSession(true);
		String selection = request.getParameter("lang");
		if(selection == null) {selection = "en";}
		session.setAttribute("language", selection);
//		System.out.println("REFERER: "+);
		String referer = request.getHeader("referer");
//		 response.sendRedirect(request.getHeader("referer"));
		//get lang_base from url
		
		URI uri = null;
		try {
			uri = new URI(referer);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = uri.getPath(); // /en/about/
		
		System.out.println("referer: "+referer);
		System.out.println("path: "+path);
		String lang_base = path.substring(0, 4);	//now we just get the first 4 characters from path
		System.out.println("lang_base: "+lang_base);
		System.out.println("lang_selection: "+"/"+selection+"/");
		
		
		//delete everyting up to the langauge base
//		System.out.println("referer.length():: "+referer.length());
//		System.out.println("referer.indexOf(selection): "+referer.indexOf("/"+selection+"/"));
//		System.out.println("substring referer url: "+referer.substring(referer.indexOf("/"+selection+"/"), referer.length()+1));
//		System.out.println("replace path: "+); //language swap

		String new_url = request.getContextPath()+path.replace(lang_base, "/"+selection+"/");//language swap
		System.out.println("new_url "+new_url);

		String resuri = request.getContextPath()+new_url;
		System.out.println("GETTING: "+resuri);
		
	
		System.out.println("------------------------------------------------");
		System.out.println("############### CHANGE LANGUAGE ################");
		System.out.println("");	System.out.println("");
		
		response.sendRedirect(resuri);
		return;
	}
	
	
	
	
	
	
	

}
