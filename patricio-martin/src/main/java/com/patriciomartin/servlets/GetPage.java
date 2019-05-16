package com.patriciomartin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetPage")
public class GetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		if(page == null || page.isEmpty()){
			page= "error.jsp";
		}
		
//		request.setAttribute("page", page.replace(".jsp", ""));
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
