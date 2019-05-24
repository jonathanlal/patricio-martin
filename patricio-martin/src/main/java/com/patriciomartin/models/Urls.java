package com.patriciomartin.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.patriciomartin.objects.Url;

public class Urls {
	
	public static List<Url> URL_MAP;
	public static Url url;

	public static String URL_ABOUT = "/about/";
	public static String URL_ABOUT_ES = "/acerca-de/";
	
	static {
		
		URL_MAP = new ArrayList<Url>();
		
		HashMap<String>
		//with url we would have to check the whole list to see ifi there is url.something
		//so we need to create like a link between the url object and the hashmap
		//the hashmap will be then <String "/about/", Integer list_index>
		url = new Url("about.jsp", URL_ABOUT("es", "no"));
		URL_MAP.add(url);
		
		url.setUrl_en("/");url.setUrl_es("/");url.setJsp("index.jsp");URL_MAP.add(url);
		URL_MAP.add("/", "index.jsp");
		URL_MAP.put(URL_ABOUT, "about.jsp");
		URL_MAP.put("/acerca-de/", "about.jsp");
		URL_MAP.put("/services/", "services.jsp");
		URL_MAP.put("/servicios/", "services.jsp");
		URL_MAP.put("/contact/", "contact.jsp");
		URL_MAP.put("/contacto/", "contact.jsp");
		URL_MAP.put("/projects/", "projects.jsp");
		URL_MAP.put("/projectos/", "projects.jsp");
		URL_MAP.put("/projects/la-cala/", "projects.jsp?p=la-cala");
		URL_MAP.put("/projectos/la-cala/", "projects.jsp?p=la-cala");
		URL_MAP.put("/projects/san-eliseo/", "projects.jsp?p=san-eliseo");
		URL_MAP.put("/projectos/san-eliseo/", "projects.jsp?p=san-eliseo");
		URL_MAP.put("/projects/domus/", "projects.jsp?p=domus");
		URL_MAP.put("/projectos/domus/", "projects.jsp?p=domus");
		URL_MAP.put("/projects/rancho/", "projects.jsp?p=rancho");
		URL_MAP.put("/projectos/domus/", "projects.jsp?p=rancho");
		URL_MAP.put("/terms/", "terms.jsp");
		URL_MAP.put("/test.jsp", "test.jsp");
//		URL_MAP.put("/xxxxxxxxxxx/", "xxxxxxxxxxx");
	}

	private static String URL_ABOUT(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
