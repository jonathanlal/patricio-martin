package com.patriciomartin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.SendEmail;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			HttpSession session = ((HttpServletRequest) request).getSession();
			String lang = (String) session.getAttribute("language");
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String msg = request.getParameter("msg");
			String phone = request.getParameter("phone"); 
			
			if(name != null && !name.isEmpty()){
			name = name.substring(0, 1).toUpperCase() + name.substring(1); //UPPERCASE FIRST LETTER
			}else{name = "Someone"; //this should never happen}
		
		}
			SendEmail sm = new SendEmail();
			sm.sendContactMail(name, email, msg, phone, lang);
	}

}
