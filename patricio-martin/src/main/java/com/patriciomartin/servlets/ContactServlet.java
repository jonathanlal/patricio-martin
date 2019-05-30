package com.patriciomartin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.SendEmail;
import com.patriciomartin.objects.Envelope;


@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SendEmail sm = new SendEmail();
		Envelope visitor_env = new Envelope();
		
		if(Globals.IS_i18n) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			String lang = (String) session.getAttribute("language");
			visitor_env.setLang(lang);
		}
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String msg = request.getParameter("msg");
			String phone = request.getParameter("phone"); 
			
			if(name != null && !name.isEmpty()){
			name = name.substring(0, 1).toUpperCase() + name.substring(1); //UPPERCASE FIRST LETTER
			}else{name = "Someone"; }//this should never happen
			
			
			visitor_env.setMsg(msg);
			visitor_env.setVisitor_name(name);
			visitor_env.setVisitor_email(email);
			visitor_env.setPhone(phone);
			visitor_env.setAdmin_flag(false); 
			
			
			sm.sendContactMail(visitor_env);
	}

}
