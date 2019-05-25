package com.patriciomartin.servlets;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patriciomartin.models.Globals;
import com.patriciomartin.models.HtmlSnippets;
import com.patriciomartin.models.Mappings;
import com.patriciomartin.models.Urls;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Field[] fields = Mappings.class.getDeclaredFields();
		try {
//			printFields(fields);
			
			
			
			
			Field fx = Mappings.class.getDeclaredField("URL_ABOUT_EN");
//			boolean accessible = fx.isAccessible();
//			fx.setAccessible(true);
			Object[] mapx = (Object[]) fx.get(null);
			String new_url = (String) mapx[0]; // /about/
			System.out.println(new_url);
//			fx.setAccessible(accessible);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
//		HashMap<String, String> urls = Urls.getUrlJspMappings("en");
//		for(Entry<?, ?> e: urls.entrySet()){
//			String k = (String) e.getKey();
//			String v = (String) e.getValue();
//		System.out.println("K: "+k+" | v: "+v);	
//		}
		
	}
	public void printFields(Field[] fields) throws Exception {
//	    Class<?> objClass = obj.getClass();
//		Field[] fields = Mappings.class.getDeclaredFields();
//	    Field[] fields = objClass.getFields();
		
	    for(Field field : fields) {
	        String name = field.getName();
	        Object value = field.get(null);

	        System.out.println(name + ": " + value.toString());
	    }
	}


}
