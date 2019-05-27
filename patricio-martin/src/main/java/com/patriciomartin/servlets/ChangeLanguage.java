package com.patriciomartin.servlets;

import java.io.IOException;
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
		HttpSession session = request.getSession(true);
		String selection = request.getParameter("lang");
		if(selection == null) {selection = "en";}
		session.setAttribute("language", selection);
		 response.sendRedirect(request.getHeader("referer"));
	}
	
	
	
	
	
	
	

}
