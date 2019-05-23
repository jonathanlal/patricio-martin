package com.patriciomartin.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Bundle bundle = Platform.getBundle("text");

		
	
//		HttpSession session = request.getSession(true);
		//session.setAttribute("language", "en");
//		session.removeAttribute("language");
		isMultiLingual();    
		    ResourceBundle bundle = ResourceBundle.getBundle(propsFile);
		    System.out.println(bundle.getString("contact.hero.title"));
	}



}
