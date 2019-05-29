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

/**
 * -TWO PARTS-
 * 
 * GET URLS BY XML (url-mappings.xml)
 * OR GET URLS BY Mappings.java (class variables) 
 * 
 * Depending on the IS_URLMAPS_XML flag in Globals we choose what implementation to do
 * 
 * Note that setting it by class variables is faster... but ugglier :(
 *
 */
public class UrlMap {
	
	
	
	public static HashMap<String,String> getProjectURLMapping(){
		
		if(Globals.IS_URLMAPS_XML) {
			List<Url> url_map = UrlMap.getUrlMappingsXML();//JAXB XML
			return getUrlJspMappingsXML(url_map);
		}else {
			Field[] url_map = Mappings.class.getDeclaredFields();//REFLECTION API
			return getUrlJspMappings(null, url_map);  //gets all url mappings via REFLECTION -> '/about/ , 'about.jsp'
		}
	}
	
	
	
	
	
	
	
	
//	REFLECTION IMPLEMENTATION
	/**
	 * Set requested_lang as null if you want the whole map or specify language or map of specific language
	 * returns: <'/about/', 'about.jsp'>
	 */
	public static HashMap<String,String> getUrlJspMappings(String requested_lang, Field[] fields){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Field f: fields) {
			try {	Object[] map = (Object[]) f.get(null);//It the field is a static field (public static ...) pass null as parameter to the get and set methods, instead of the objectInstance parameter passed above.
					String url = (String) map[0]; // /about/
					String jsp = (String) map[1];// about.jsp
					if(requested_lang != null && Globals.IS_i18n) {
						String lang = (String) map[2]; // en
						if(lang.equals(requested_lang)) {URLS.put(url, jsp);}
					}else {URLS.put(url, jsp);}
				} catch (IllegalArgumentException | IllegalAccessException e) {e.printStackTrace();} 
		}
		return URLS;
	}
	public static HashMap<String, String> getWildcardMappings(Field[] fields){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Field f: fields) {
			try {	Object[] map = (Object[]) f.get(null);
					String url = (String) map[0]; // /acerca-de/
					String name = (String) map[1]; // '*'
						if(name.equals("*"))
							URLS.put(url, "*"); //2nd parameter doesn't matter.. we only need the hashmap to check if the value exists
				} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {e.printStackTrace();} 
		}
		return URLS;
	} 
	/**
	*'/acerca-de/','es'
	*...assumes Globals.IS_i18n = true
	*/
	public static HashMap<String, String> getUrlLanguageMappings(Field[] fields) {
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Field f: fields) {
				try {
					Object[] map = (Object[]) f.get(null);//It the field is a static field (public static ...) pass null as parameter to the get and set methods, instead of the objectInstance parameter passed above.
					String url = (String) map[0]; // /about/
					String jsp = (String) map[2];// en
					URLS.put(url, jsp);
				} catch (IllegalArgumentException | IllegalAccessException e) {e.printStackTrace();} 
		}
		return URLS;
	}
	/**
	* changes the url language back to whatever is set as session lang variable
	*/
	public static String getURLanguageEquivalent(String lang, String requri, Field[] fields){
			String new_url = null;
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
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {e.printStackTrace();} 
			}
			return new_url;
	}


//XML(JAXB) IMPLEMENTATION

	public static HashMap<String, String> getWildcardMappingsXML(List<Url> url_maps){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: url_maps) {
			if(um.name.equals("*")) {
				URLS.put(um.url, um.name);}}
		return URLS;
	} 
	public static HashMap<String, String> getUrlNameMappingsXML(List<Url> url_maps){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: url_maps) {
			URLS.put(um.name, um.url);}
		return URLS;
	} 
	public static HashMap<String, String> getUrlLanguageMappingsXML(List<Url> url_map){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: url_map) {
			URLS.put(um.url, um.lang);}
		return URLS;
	} 
	/**
	 * @param url_map 
	 * @return hashmap of <'/about/', 'about.jsp>
	 */
	public static HashMap<String, String> getUrlJspMappingsXML(List<Url> url_map){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: url_map) {
			URLS.put(um.url, um.call);}
		return URLS;
	} 
	public static String getURLanguageEquivalentXML(String session_lang, String requri, List<Url> url_maps){
		String new_url = null;
		for(Url um: url_maps) {
			if(requri.equals(um.url)) {
			String c_name = um.name;
			String c_call = um.call;
				for(Url um2: url_maps) {
					if(um2.name.equals(c_name) && um2.call.equals(c_call) && um2.lang.equals(session_lang)){
						new_url = um2.url;
						break;}}if(new_url != null) {break;}}}
							return new_url;
	}
	public static List<Url> getUrlMappingsXML(){
		 File xmlFile = Globals.getUrlMappingFile(); ///USE JAXB TO MAKE OBJECT FROM XML
		 List<Url> urls =  null;
		 try { urls = (List<Url>) unmarshall(xmlFile);
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
