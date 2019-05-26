package com.patriciomartin.models;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.patriciomartin.objects.Url;
import com.patriciomartin.objects.Urls;

public class UrlMap {
	
	
	
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
* changes the url language back to whatever is set as session lang variable
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






















































public HashMap<String, String> getUrlNameMappingsXML(List<Url> url_maps){
	HashMap<String,String> URLS = new HashMap<String,String>();
	for(Url um: url_maps) {
		URLS.put(um.name, um.url);
	}
	return URLS;
} 
public HashMap<String, String> getUrlLanguageMappingsXML(){
	HashMap<String,String> URLS = new HashMap<String,String>();
	for(Url um: getUrlMappings()) {
		URLS.put(um.url, um.lang);
	}
	return URLS;
} 
/**
 * 
 * @return hashmap of <'/about/', 'about.jsp>
 */
public HashMap<String, String> getUrlJspMappingsXML(){
	HashMap<String,String> URLS = new HashMap<String,String>();
	for(Url um: getUrlMappings()) {
		URLS.put(um.url, um.call);
	}
	return URLS;
} 
public String getURLanguageEquivalentXML(String session_lang, String requri){
String new_url = null;
List<Url> url_maps = getUrlMappings();
for(Url um: url_maps) {
	if(requri.equals(um.url)) {
	String c_name = um.name;
	String c_call = um.call;
		for(Url um2: url_maps) {
			if(um2.name.equals(c_name) &&  um2.call.equals(c_call) && um2.lang.equals(session_lang)){
				new_url = um2.url;
				break;
			}
		}
	if(new_url != null) {break;}
	}
}
return new_url;
}
public static List<Url> getUrlMappings(){
	 File xmlFile = new File(Globals.URL_MAPPINGS_LOCATION);	 ///USE JAXB TO MAKE OBJECT FROM XML
	 List<Url> urls =  null;
	 try {
	 urls = (List<Url>) unmarshall(xmlFile);
	} catch (JAXBException e) {e.printStackTrace();}
return urls;
}
public static List<Url> unmarshall(File xmlFile) throws JAXBException{
    Urls urls = new Urls();
    JAXBContext jaxbCtxt = JAXBContext.newInstance(Urls.class);
    Unmarshaller jaxbUnmarshaller = jaxbCtxt.createUnmarshaller();
    urls= (Urls)jaxbUnmarshaller.unmarshal(xmlFile);    
return urls.getUrls();
}











}
