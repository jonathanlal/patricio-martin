package com.patriciomartin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patriciomartin.models.SendEmail;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String msg = request.getParameter("msg");
		String phone = request.getParameter("phone"); 
		
		if(name != null && !name.isEmpty()){
		name = name.substring(0, 1).toUpperCase() + name.substring(1); //UPPERCASE FIRST LETTER
		}else{
			name = "Someone";
		}
		SendEmail sm = new SendEmail();
		
		sm.sendContactMail(name, email, msg, lang);
//		sm.sendAdminContactLead(name,email,hearfrom,msg); //ADMIN 
//		sm.sendContactMailConfirmation(name, email,msg); // USER CONFIRMATION EMAIL


	
	}

}
