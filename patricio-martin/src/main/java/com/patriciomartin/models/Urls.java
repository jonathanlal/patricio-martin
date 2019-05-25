package com.patriciomartin.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.patriciomartin.objects.Url;

public class Urls {
	
//	public static HashMap<String,String> URLS = getUrlJspMappings(null);

	
	/**
	 * SET REQUESTED_LANG AS NULL IF YOU@RE NOT INTERESTED IN GETTING THE URLS BY LANGUAGE 
	 * SETTING NULL GETS ALL THE URLS IN MAPPINGS
	 * 
	 * the two values taht get passed are:
	 * 
	 * '/about/', 'about.jsp'
	 * 
	 * respectively.
	 * 
	 */
	public static HashMap<String,String> getUrlJspMappings(String requested_lang){
		
		
		HashMap<String,String> URLS = new HashMap<String,String>();
		
		//REFLECTION API
		Field[] fields = Mappings.class.getDeclaredFields();
		
		for(Field f: fields) {
				try {
				
					Object[] map = (Object[]) f.get(null);
					
					//It the field is a static field (public static ...) pass null as parameter to the get and set methods, instead of the objectInstance parameter passed above.
					String url = (String) map[0]; // /about/
					String jsp = (String) map[1];// about.jsp
		
					
					
					if(requested_lang != null && Globals.IS_i18n) {
						String lang = (String) map[2]; // en
//						String name = f.getName(); // URL_ABOUT_ES
//						String lang_ending = name.substring(Math.max(name.length() - 2, 0)).toLowerCase(); //es
//						System.out.println(substring);
						if(lang.equals(requested_lang)) {
							URLS.put(url, jsp);
						}
					}else {
						URLS.put(url, jsp);
					}
				
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} 
		
		}
		
		return URLS;
	}

	/**
	*This creates a hash map of the urls and the language of that url.. for example:
	*
	*'/acerca-de/','es'
	*
	*...assumes Globals.IS_i18n = true
	*/
	public static HashMap<String, String> getUrlLanguageMappings() {
		
		HashMap<String,String> URLS = new HashMap<String,String>();
		
		//REFLECTION API
		Field[] fields = Mappings.class.getDeclaredFields();
		
		for(Field f: fields) {
				try {
				
					Object[] map = (Object[]) f.get(null);
					
					//It the field is a static field (public static ...) pass null as parameter to the get and set methods, instead of the objectInstance parameter passed above.
					String url = (String) map[0]; // /about/
					String jsp = (String) map[2];// en
		

					URLS.put(url, jsp);
				
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				} 
		
		}
		
		return URLS;
	}

/**
* 
* 
*/
public static String getURLanguageEquivalent(String lang, String requri){
		
		String new_url = null;
//		HashMap<String,String> URLS = new HashMap<String,String>();
		
		//REFLECTION API
		Field[] fields = Mappings.class.getDeclaredFields();
		
		for(Field f: fields) {
				try {
				
					Object[] map = (Object[]) f.get(null);
					String url = (String) map[0]; // /acerca-de/
					
					if(requri.equals(url)) {
						
						String s = f.getName(); // URL_ABOUT_ES
						String class_variable_name = s.substring(0, s.length() - 3); // URL_ABOUT     -('_ES')
						class_variable_name = class_variable_name + "_"+lang.toUpperCase(); //URL_ABOUT_XX
						
						Field fx = Mappings.class.getDeclaredField(class_variable_name);
						Object[] mapx = (Object[]) fx.get(null);
						new_url = (String) mapx[0]; // /about/
					}
					
					
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				} 
		
		}
	
		return new_url;
	}


}
