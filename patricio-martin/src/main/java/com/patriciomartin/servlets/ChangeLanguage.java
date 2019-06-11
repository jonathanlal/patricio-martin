package com.patriciomartin.servlets;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.Mappings;
import com.patriciomartin.models.UrlMap;

@WebServlet("/ChangeLanguage")
public class ChangeLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeLanguage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");	System.out.println("");
//		boolean abort = false;
		System.out.println("############### CHANGE LANGUAGE ################");
		System.out.println("------------------------------------------------");
		HttpSession session = request.getSession(true);
		String selection = request.getParameter("lang");
		if(selection == null) {selection = "en";}
		session.setAttribute("language", selection);
//		System.out.println("REFERER: "+);
		String referer = request.getHeader("referer");
//		 response.sendRedirect(request.getHeader("referer"));
		//get lang_base from url
		
		URI uri = null;
		try {
			uri = new URI(referer);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requri = uri.getPath(); // /en/about/
		
		System.out.println("referer: "+referer);
		System.out.println("requri: "+requri);
//		System.out.println("path 2: "+request.getRequestURI());
		
		
		String lang_base = getLangBaseFromUrl(requri); // es,en,null
//		String requri = request.getRequestURI();
		System.out.println("lang_base: "+lang_base);
		
		if(lang_base != null) {
		
			Field[] fields = Mappings.class.getDeclaredFields();
			HashMap<String, String> urls = UrlMap.getUrlLanguageMappings(fields); // <'/about/', 'en'>
			String test = requri.replace("/"+lang_base+"/", "/");
			System.out.println("test: "+test);
			String page_lang_mapping = urls.get(test);//
			System.out.println("page_lang_mapping: "+page_lang_mapping);
			//change url to whatever the requested langauge is
			
			
			//if the selected language isn't the same as the language of the end bit
//			if(!page_lang_mapping.equals(selection)) {
				//if you're changinging language your'e not gonna change to the same language...
			
			
			String alternate_url = UrlMap.getURLanguageEquivalent(selection, test, fields);
			
			String new_url = request.getContextPath()+selection+alternate_url;
			System.out.println("new_url "+new_url);

//			String resuri = request.getContextPath()+new_url;
//			System.out.println("GETTING: "+resuri);
	
			response.sendRedirect(new_url);
			return;
			
		}else {
			//uhhh will this ever happen?
			System.out.println("THIS SHOULD NEVER HAPPEN WTF!?!?!");
			response.sendRedirect("/");
			return;
		}
		
//		System.out.println("lang_base: "+lang_base);
//		System.out.println("lang_selection: "+"/"+selection+"/");
		
		
		
		
//		String alternate_url = null;//REWRITE LOGIC BLOCK
		
		
		
		//delete everyting up to the langauge base
//		System.out.println("referer.length():: "+referer.length());
//		System.out.println("referer.indexOf(selection): "+referer.indexOf("/"+selection+"/"));
//		System.out.println("substring referer url: "+referer.substring(referer.indexOf("/"+selection+"/"), referer.length()+1));
//		System.out.println("replace path: "+); //language swap

//		String new_url = request.getContextPath()+path.replace(lang_base, "/"+selection+"/");//language swap
//		System.out.println("new_url "+new_url);

//		String resuri = request.getContextPath()+new_url;
//		System.out.println("GETTING: "+resuri);
		
	
//		System.out.println("------------------------------------------------");
//		System.out.println("############### CHANGE LANGUAGE ################");
//		System.out.println("");	System.out.println("");
		
//		if(!abort) {
	
//		}else {
//			response.sendRedirect("/");
//			return;	
//		}
	}
	
	
	private String getLangBaseFromUrl(String requri) {
		String uri_lang = null;
		//check uri and make sure that it has a language base and that it is a language we support
		for(String lang: Globals.LANGUAGES) {
			if(Pattern.compile("\\/"+lang+"\\/").matcher(requri).find()) {
				uri_lang = lang;
				break;
			}
		}
		return uri_lang;
	}
	
	
	
	

}
