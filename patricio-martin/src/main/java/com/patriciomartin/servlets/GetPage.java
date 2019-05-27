package com.patriciomartin.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.patriciomartin.models.PhotoSwipe;


@WebServlet("/GetPage")
public class GetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null || page.isEmpty()){
			request.setAttribute("error", "'page' variable was null or empty!");
			page= "error.jsp";
		}else if(page.startsWith("error.jsp")) { //check that this doesn't fire after first check is true.. (shoudn't in else if ?) 
			request.setAttribute("error", "Requested url is not a wildcard or a servlet either!");
		}else if(page.startsWith("project.jsp")) { //changed from contains
			String project = page.replace("project.jsp?p=", "");
			String photos = PhotoSwipe.createPhotoswipeArray(project);
			request.setAttribute("photos", photos);
			request.setAttribute("project", project);
		}
		
		request.setAttribute("steps", request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	

}
