package com.patriciomartin.servlets;


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
import com.patriciomartin.models.Urls;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(Urls.URL_MAP.size());
		
//		String test = p(join("This paragraph has", b("bold"), "and", i("italic"), "text.")).render();

	}



}
