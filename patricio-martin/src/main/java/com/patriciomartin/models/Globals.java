package com.patriciomartin.models;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.patriciomartin.objects.Url;

public class Globals {
	
	//CONFIG
	public static String PROJECT_ID = "patricio-martin"; //the GOOGLE PROJECT ID WHICH IS ALSO USED AS THE DB NAME in the web devil sql server
	public static boolean IS_i18n = true; //  internationalization is abbreviated as i18n, because there are 18 letters between "i" and "n."
	public static boolean REWRITE_i18n_URLS = true; //if session variable lang is 'en' and user tries to access /acerca-de/ then it will rewrite url to /about/ (other wise it won't and only change page language)
	public static boolean EMAIL_SENDER_TYPE_GOOGLE = true; //Use java mail api and send via google or some other implementation (via mailgun for example)
	public static boolean IS_URLMAPS_XML = false; //make false if you want to define your URL mappings in Mappings.java instead of url-mappings.xml (Mappings.java is like 20-100ms faster....)
	public static String DEFAULT_LANG = "en"; //default language of the website
	public static String[] LANGUAGES = {"en","es"}; //languages of the website
	public static String URL_MAPPINGS_FILENAME = "url-mappings.xml"; //must be in the resources folder
	
	//DATABASE
	public static String DB_INSTANCE_CONNECTION_NAME = "the-web-devil:europe-west1:the-web-devil"; //google cloud sql old:  
	public static String DB_SCHEMA_NAME = "webdevil";
	public static String DB_LOCALHOST = "localhost:3306";
	public static String DB_LOCAL_USER = "root";
	public static String DB_LOCAL_PASSWORD = "1234";
	
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
	public static List<Url> URL_MAPS = UrlMap.getUrlMappingsXML();
	
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
	public static String EMAIL_LOGO = "email-logo.png"; //300x217 is good
	public static String EMAIL_ADDRESS_CONTACT = "info@patriciomartin.com";
	@SuppressWarnings("serial")
	public static Map<String, String> EMAIL_ADMIN_HASHMAP = new HashMap<String, String>()
	{{
	     put("Jonathan", "jonathan@thewebdevil.com");
	     //put("Patricio", EMAIL_ADDRESS_CONTACT);
	}};
	
	
	//EMAIL SOCIAL BTNS DISABLE OR ENABLE //make false to turn them off in the footer of the email
	public static boolean EMAIL_FACEBOOK_ON = true;
	public static boolean EMAIL_GOOGLEPLUS_ON = true;
	public static boolean EMAIL_TWITTER_ON = true;
	public static boolean EMAIL_INSTAGRAM_ON = true;
	public static boolean EMAIL_PINTEREST_ON = true;
	public static boolean EMAIL_LINKEDIN_ON = true;
	
	//EMAIL SOCIAL BTNS IMGS
    public static String EMAIL_FACEBOOK = "facebook-32.png";
	public static String EMAIL_GOOGLEPLUS = "google-32.png";
	public static String EMAIL_TWITTER = "twitter-32.png";
    public static String EMAIL_INSTAGRAM = "instagram-32.png";
	public static String EMAIL_PINTEREST = "pinterest-32.png";
	public static String EMAIL_LINKEDIN = "linkedin-32.png";
	
	//SOCIAL WEB LINKS
	public static String SOCIAL_FACEBOOK = "";
	public static String SOCIAL_GOOGLEPLUS = "";
	public static String SOCIAL_TWITTER = "";
	public static String SOCIAL_INSTAGRAM = "";
	public static String SOCIAL_PINTEREST = "https://www.linkedin.com/company/businesshere/";
	public static String SOCIAL_LINKEDIN = "";
	



	public static File getUrlMappingFile() {
		URL res = Globals.class.getClassLoader().getResource(Globals.URL_MAPPINGS_FILENAME);
		File f = null;
		try {
			f = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static String getBundleString(String key) {
		return ResourceBundle.getBundle("text").getString(key);
	}
	/**
	 * in the header.jsp there is jstl that checks if param.lang is checked or if session langage set and if not it sets it as request.locale.language
	 * so we pass that result to getLanguage to make sure that whatever language we got there is a language that the application supports. 
	 * If the language is not in supported languages then it will get the default language.
	 * //not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale.language
	 * @param lang
	 * @return String
	 */
	public static String getLanguage(String lang) {
		if(!Arrays.stream(Globals.LANGUAGES).anyMatch(lang::equals)) {
			lang = DEFAULT_LANG;
		}
		return  lang;
	}
	public static String getDefaultLang() {
		return DEFAULT_LANG;
	}
	
	
	
}
