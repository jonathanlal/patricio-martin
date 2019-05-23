package com.patriciomartin.models;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Globals {
	
	
	//METAS
	public static String META_fbid = "";
	public static String META_googleplus = "";
	public static String META_IMAGE = "https://storage.googleapis.com/somegoat/logo.png";
	public static String META_TITLE = "The Web Devil - Custom Website Design and Development";
	public static String META_DESCRIPTION = "Custom webite development or design work & custom web applications for individuals and businesses on Costa Del Sol, Spain or in the UK.";
	
	
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
	


	public boolean isMultiLingual() {
		//check if project has language files
	    String propsFile = "text";
	    String propsPath = this.getClass().getClassLoader().getResource(".").getPath();
	    File f = new File(propsPath, propsFile + ".properties");
	    if(f.exists()){
	        return true;
	    }else {
	    	return false;
	    }
	}

	
}
