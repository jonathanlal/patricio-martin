package com.patriciomartin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.HtmlSnippets;
import com.patriciomartin.models.SendEmail;

@WebServlet("/Subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Subscribe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("lang");
		if(language == null) {language = "en";}
		System.out.println("SUBSCRIBE SERVLET HIT");
		
		String email = request.getParameter("email");
		
		
		SendEmail sm = new SendEmail();
		sm.sendNewsLetterSignUpMail(email);
		
		
		
		
		
		String url = "";
		if(language.equals("en"))
			url = "/en/thank-you/";
		else
			url = "/es/gracias/";
		System.out.println("REDIRECTING TO: "+url);
		response.sendRedirect(url);
		return;
	
	
	}

}
