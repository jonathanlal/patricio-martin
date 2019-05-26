package com.patriciomartin.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Globals {
	
	public static boolean IS_i18n = true; //  internationalization is abbreviated as i18n, because there are 18 letters between "i" and "n."
	public static boolean EMAIL_SENDER_TYPE_GOOGLE = true; //Use java mail api and send via google or some other implementation (via mailgun for example)
	public static String DEFAULT_LANG = "en"; //default language of the website
	public static String[] LANGUAGES = {"en","es"}; //languages of the website
//	public static String URL_MAPPINGS_LOCATION_REL = "/WEB-INF/url-mappings.xml";

	public static String URL_MAPPINGS_LOCATION = "C:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp17/patricio-martin/WEB-INF/url-mappings.xml";
	
	//METAS
	public static String META_fbid = "";
	public static String META_googleplus = "";
	public static String META_IMAGE = "https://storage.googleapis.com/somegoat/logo.png";
	public static String META_TITLE = "Patricio Martin - Architects based on the Costa del Sol";
	public static String META_DESCRIPTION = "Patricio Martin can provide a full architectural and building service. From the initial survey and design concept, through all stages of the building process, right up to the completed project and final result.";
	
	
	//SESSION STRINGS
	public static String USER_ID = "user_id";
	public static String USER_TYPE = "user_type";	
	public static String USER_NAME = "user_name";
	public static String USER_EMAIL = "user_email";
	
	//COOKIES
	public static String COOKIE_LOGIN = "patricio-martin_auth";
	
	//DOMAIN INFO
	public static String BRAND = "Patricio Martin";
	public static String DOMAIN_FULL = "https://www.patriciomartin.com";
	public static String DOMAIN_NAKED = "patriciomartin.com";
	public static String DOMAIN_APPSPOT = "patricio-martin.appspot.com";
	
	//EMAIL STUFF
	public static String MAILGUN_API_KEY = "";
	public static String MAILGUN_BASE_URL = "\r\n" + "";
	public static String MAILGUN_MAIL_DOMAIN = "mail."+DOMAIN_NAKED;
	public static String MAILGUN_FROM = BRAND;
	public static String EMAIL_LOGO = "img/email-logo-v2.png"; //mailgun
	public static String EMAIL_CID_LOGO = "cid:email-logo-v2.png"; // google
	public static String EMAIL_ADDRESS_CONTACT = "info@patriciomartin.com";
	public static Map<String, String> EMAIL_ADMIN_HASHMAP = new HashMap<String, String>()
	{{
	     put("Jonathan", "jonathan@thewebdevil.com");
	     put("Patricio", EMAIL_ADDRESS_CONTACT);
	}};
	
	//EMAIL SOCIAL BTNS
    public static String EMAIL_CID_FACEBOOK = "cid:facebook-32.png";
	public static String EMAIL_CID_GOOGLEPLUS = "cid:google-32.png";
	public static String EMAIL_CID_TWITTER = "cid:twitter-32.png";
    public static String EMAIL_CID_INSTAGRAM = "cid:instagram-32.png";
	public static String EMAIL_CID_PINTEREST = "cid:pinterest-32.png";
	public static String EMAIL_CID_LINKEDIN = "cid:linkedin-32.png";
	
	
	//SOCIAL WEB LINKS
	public static String SOCIAL_FACEBOOK = "";
	public static String SOCIAL_GOOGLEPLUS = "";
	public static String SOCIAL_TWITTER = "";
	public static String SOCIAL_INSTAGRAM = "";
	public static String SOCIAL_PINTEREST = "https://www.linkedin.com/company/businesshere/";
	public static String SOCIAL_LINKEDIN = "";
	


//	public static boolean isMultiLingual() {
//		//check if project has language files
//	    String propsFile = "text";
//	    String propsPath = Globals.class.getClassLoader().getResource(".").getPath();
//	    File f = new File(propsPath, propsFile + ".properties");
//	    if(f.exists()){
//	        return true;
//	    }else {
//	    	return false;
//	    }
//	}

	public static String getBundleString(String key) {
		return ResourceBundle.getBundle("text").getString(key);
	}
	/**
	 * in the header.jsp there is jstl that checks if param.lang is checked or if session langage set and if not it sets it as request.locale.language
	 * so we pass that result to getLanguage to make sure that whatever language we got there is a language that the application supports. 
	 * If the language is not in supported languages then it will get the default language.
	 * 
	 * @param lang
	 * @return String
	 */
	public static String getLanguage(String lang) {
//		List<String> URL_TEST = Arrays.asList(new String[]{"/test.jsp","test.jsp", "en"});
//		ArrayList<String> languages = (ArrayList<String>) Arrays.asList(Globals.LANGUAGES);
		
		//if requested lang does not exist in our array of languages then default to default lang
		if(!Arrays.stream(Globals.LANGUAGES).anyMatch(lang::equals)) {
			lang = DEFAULT_LANG;
		}
		//keep this
		//not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale.language
		
		
		//language eq 'en' || language eq 'es' ? language : 'en'
		
		
		
		return  lang;
	}
	
}
