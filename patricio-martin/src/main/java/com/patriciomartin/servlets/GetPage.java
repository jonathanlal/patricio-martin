package com.patriciomartin.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.PhotoSwipe;
import com.patriciomartin.models.Globals;
import com.patriciomartin.models.HtmlSnippets;
import com.patriciomartin.models.Imgrid;


@WebServlet("/GetPage")
public class GetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(" ");
//		System.out.println("..................................................");
//		System.out.println("################ GET PAGE SERVLET ################");
//		System.out.println("GET PAGE FIRED!");
		
		String page = request.getParameter("page");
		
//		System.out.println("page: "+page);
		String metaShare = null;
		if(page == null || page.isEmpty()||page.startsWith("error.jsp")){
			request.setAttribute("error", "${page} was null or empty or startsWith error!");
			page= "error.jsp";
//			metaShare = getMetaShareTags(page, request);
//		}else if(page.startsWith("error.jsp")) { //check that this doesn't fire after first check is true.. (shoudn't in else if ?) 
//			request.setAttribute("error", "Requested url is not a wildcard or a servlet either!");
		}else if(page.startsWith("project.jsp")) { //changed from contains
			String project = page.replace("project.jsp?p=", "");
			
			String photos = PhotoSwipe.createPhotoswipeArray(project);
			request.setAttribute("photos", photos);
			
			ArrayList<String> dd = Imgrid.createImgGrid(project);
			request.setAttribute("dd_photos", dd);
	
			request.setAttribute("project", project);
		}else if(page.equals("services.jsp")) {
			HashMap<String, String> s = new HashMap<>();
			
			HttpSession session = ((HttpServletRequest) request).getSession();
			String current_lang = (String) session.getAttribute("language");
			if(current_lang == null) {current_lang = Globals.DEFAULT_LANG;}
			 Locale l = new Locale(current_lang); // "es", "en" ...
			 ResourceBundle b = ResourceBundle.getBundle("text", l);
			

			  for (String key : b.keySet()) {
			     if(key.contains("services.icon")) {
			    	 s.put(b.getString(key.replace(".icon.",".text.")), b.getString(key));
			     }
			    }
			  request.setAttribute("services", s);
			
		}
		metaShare = getMetaShareTags(page, request);
	
		request.setAttribute("metaShare", metaShare);
		request.setAttribute("steps", request.getContextPath());
		
		
//		System.out.println("################ GET PAGE SERVLET ################");
//		System.out.println("..................................................");
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	private String getMetaShareTags(String page, HttpServletRequest request) {
//		System.out.println(" ");
//		System.out.println("---------METAS--------");
		String metaShare = null;
		String base = "Patricio Martin - ";
		
		if(Globals.IS_i18n) {
//			 System.out.println("PAGE: "+page);
			HttpSession session = ((HttpServletRequest) request).getSession();
			String current_lang = (String) session.getAttribute("language");
			
			if(current_lang == null) {current_lang = Globals.DEFAULT_LANG;}
//			 System.out.println("current_lang: "+current_lang);
			 Locale l = new Locale(current_lang); // "es", "en" ...
			 ResourceBundle b = ResourceBundle.getBundle("text", l);
			 
			 
			 String title = b.getString("meta.index.title");
			 String desc = b.getString("meta.index.description");	 
			 String url = null;
			 if(page.endsWith(".jsp") && !page.equals("error.jsp")) {
	
				 page = page.replace(".jsp", "");
					 title = b.getString("meta."+page+".title");
					 desc = b.getString("meta."+page+".description");
					 url = "/"+current_lang+"/"+b.getString("url."+page);
					 
		

			 }else if(page.startsWith("project.jsp")){
				
				 String project = page.replace("project.jsp?p=", "");
				 title = b.getString("meta.projects."+project+".title");
				 desc = b.getString("meta.projects."+project+".description");
				 url = "/"+current_lang+"/"+b.getString("url.projects."+project);
				 

			 }
//			 System.out.println("****");
//			 System.out.println("	title: "+title);
//			 System.out.println("	desc: "+desc);
//			 System.out.println("	url: "+url);
//			 System.out.println("****");
			 
			 metaShare = HtmlSnippets.customMetaTags(base+title, desc, null, url);
		}

		 

	
//		System.out.println("---------METAS--------");
//		System.out.println(" ");
		
		return metaShare;
	}
	

}
