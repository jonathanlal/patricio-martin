package com.patriciomartin.servlets;

import static j2html.TagCreator.b;
import static j2html.TagCreator.i;
import static j2html.TagCreator.join;
import static j2html.TagCreator.p;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.HtmlSnippets;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		String test = p(join("This paragraph has", b("bold"), "and", i("italic"), "text.")).render();
//		System.out.println(test);
//		Bundle bundle = Platform.getBundle("text");
//		Locale lang = new Locale("es");
//		ResourceBundle b = ResourceBundle.getBundle("text", lang);
		
//		String dog = "Bulldog";
//		String[] v = {"dog", "cat", "mouse"};
		
//		v[0] = "Poodle";
		
//		System.out.println(dog); //should be "poodle" 
		
//		try {
//			HashMap<String, String> test = HtmlSnippets.emailContact("joanthan", "hello everyone", "en");
//			String subject = test.get("subject");
//			 System.out.println("subject " + subject);
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String subject = test.get("subject");
	
//		HttpSession session = request.getSession(true);
		//session.setAttribute("language", "en");
//		session.removeAttribute("language");
//		System.out.println(Globals.isMultiLingual());
//		    ResourceBundle bundle = ResourceBundle.getBundle(propsFile);
//	    System.out.println("subject " + subject);

	}



}
