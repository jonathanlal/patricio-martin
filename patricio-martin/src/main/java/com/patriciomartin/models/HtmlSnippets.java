package com.patriciomartin.models;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import static j2html.TagCreator.*;

import javax.servlet.http.HttpServletRequest;

import com.patriciomartin.objects.Envelope;


public class HtmlSnippets {
	

	
	
	public String customMetaTags(String title, String description, String image, String url_end){
	String canonical = Globals.DOMAIN_FULL+url_end;
	if(null == title || title.isEmpty()){
		title = Globals.META_TITLE;
	}
	if(null == description || description.isEmpty()){
		description = Globals.META_DESCRIPTION;
	}
	if(null == image || image.isEmpty()){
		image = Globals.META_IMAGE;
	}
	String metas = 	
	"<title>"+title+"</title>"+
    "<meta property=\"title\" content=\""+title+"\">"+ //title and description of page as they appear in search results.
    "<meta property=\"description\" content=\""+description+"\">"+
    "<meta property=\"og:title\" content=\""+title+"\">"+
    "<meta property=\"og:url\" content=\""+canonical+"\">"+
    "<meta property=\"og:image\" content=\""+image+"\">"+
    "<meta property=\"og:description\" content=\""+description+"\">"+
    "<meta property=\"og:type\" content=\"website\">"+
    "<meta property=\"twitter:title\" content=\""+title+"\">" + 
    "<meta property=\"twitter:description\" content=\""+description+"\">"+
    "<meta property=\"twitter:image:src\" content=\""+image+"\">";
	return metas;
	}
	
	private static String emailHead(){
		//START EMAIL BODY			
		String htmlMessage = "<html>";
		//GREY BOX
		htmlMessage +="<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"20\"><tr><td>";
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: block;padding: 20px;text-align: center;\">";
		//TITLE PART
		htmlMessage += "<div style=\"text-align: center;margin-top: 0px;\">";
		htmlMessage += "<a href=\""+Globals.DOMAIN_FULL+"\" style=\"text-decoration:none;\">";
		htmlMessage += "<img style=\"vertical-align:middle;width:70%;max-width:300px;\" alt=\""+Globals.BRAND+"\" src=\""+Globals.EMAIL_CID_LOGO+"\">";
		htmlMessage += "</a>";
		htmlMessage += "</div>";
		htmlMessage += "<div style=\"background-color: white;display: inline-block;padding: 20px;text-align: center;margin-top:10px;\">";
		return htmlMessage;
	}
	private static String emailFoot(){
		
		
		String htmlMessage = "<p style=\"color:#999999;\">"+SendEmail.email_footer_confirm+"</p>";
		htmlMessage += "<p style=\"color:#999999;\">"+SendEmail.email_footer_noreply+"</p><br>";
		htmlMessage += "<p style=\"color:#000000;\">"+SendEmail.email_footer_regards+"</p>";
		htmlMessage += "<p style=\"color:#000000;\"><b>"+Globals.BRAND+"<b></p>";
		htmlMessage += "</div>"; //the opening tag is in emailHead();
		
		//END OF GREY BOX
		htmlMessage += "<br><div style=\"text-align:center;\"><br>";
		
		//FACEBOOK
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_FACEBOOK+"\"> ";
		htmlMessage += "<img alt=\"Facebook\" src=\""+Globals.EMAIL_CID_FACEBOOK+"\">";
		htmlMessage += "</a>";
		//GOOGLE+
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_GOOGLEPLUS+"\"> ";
		htmlMessage += "<img alt=\"Google\" src=\""+Globals.EMAIL_CID_GOOGLEPLUS+"\">";
		htmlMessage += "</a>";
		//TWITTER
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_TWITTER+"\"> ";
		htmlMessage += "<img alt=\"Twitter\" src=\""+Globals.EMAIL_CID_TWITTER+"\">";
		htmlMessage += "</a>";
		//INSTAGRAM
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_INSTAGRAM+"\"> ";
		htmlMessage += "<img alt=\"Instagram\" src=\""+Globals.EMAIL_CID_INSTAGRAM+"\">";
		htmlMessage += "</a>";
		//PINTEREST
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_PINTEREST+"\"> ";
		htmlMessage += "<img alt=\"Pinterest\" src=\""+Globals.EMAIL_CID_PINTEREST+"\">";
		htmlMessage += "</a>";
		//LINKEDIN
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_LINKEDIN+"\"> ";
		htmlMessage += "<img alt=\"Linkedin\" src=\""+Globals.EMAIL_CID_LINKEDIN+"\">";
		htmlMessage += "</a>";
		
		htmlMessage += "<br>";
		 htmlMessage += "<a style=\"text-decoration:none;font-size:22px;weight:700;color:#1071b1;\" href=\""+Globals.DOMAIN_FULL+"\">"+Globals.DOMAIN_NAKED+"</a>";
		 htmlMessage += "<p style=\"font-size:16;font-weight:bold;color:#58595b;margin-top:0;text-decoration:none;\">"+Globals.EMAIL_ADDRESS_CONTACT+"</p>";
		 htmlMessage += "</div>";
		//END EMAIL BODY
			//END OF WHITE BOX
			htmlMessage += " </div>";
			//END OF GREY BOX
			htmlMessage += "</div>";
			htmlMessage +="</td></tr></table>";

		htmlMessage += "</html>";
		return htmlMessage;
	}
	private static void overrideTextWithLanguageIfi18n(String lang, String[] overrides) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//overrides the text values set in emails and replaces it with the value for the correct language
		
		if(Globals.IS_i18n) {
			
			 Locale l = new Locale(lang); // "es", "en" ...
			 ResourceBundle b = ResourceBundle.getBundle("text", l);
			
			 for(int i = 0; i < overrides.length;i++) {
				 //REFLECTION (to get the class variable value and change it based on the language)
				 Field declaredField = SendEmail.class.getDeclaredField(overrides[i]);
		         boolean accessible = declaredField.isAccessible();
		         declaredField.setAccessible(true);
		         String new_email_greeting = b.getString(overrides[i].replace("_", "."));
		         declaredField.set(SendEmail.class, new_email_greeting);
		         declaredField.setAccessible(accessible);
			 }
			 //same for every mail so do manually...(same thing as above line)
			 SendEmail.email_greeting = b.getString("email.greeting");
			 SendEmail.email_footer_confirm = b.getString("email.footer.confirm");
			 SendEmail.email_footer_noreply = b.getString("email.footer.noreply");
			 SendEmail.email_footer_regards = b.getString("email.footer.regards");
		}
		
	}
	

	
	
	//MOVE THIS METHOD OVER TO SENDEMAIL and keep all the html in this class...
	public static Envelope createContactEmail(Envelope e) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		if(e.getLang() != null) {
		//i18n, whatever we put in the array below, will make it so that when you call overrideTextWithLanguageIfi18n(), the variable is overridden with whatever language
		String[] overrides = {"email_contact_subject", "email_contact_intro"};
		overrideTextWithLanguageIfi18n(e.getLang(), overrides); //really really cool lol
		}
		
		e.setSubject(SendEmail.email_contact_subject);// (important to do after the override method above)
		
		String htmlMessage = emailHead();
		
		if(e.isAdmin_flag()) {
			//GREETING & INTRO PART
			htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">"+SendEmail.email_greeting+e.getAdmin_name()+",</h1>";
			htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+SendEmail.email_contact_admin+"</h3>";	
		}else {
			//GREETING & INTRO PART
			htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">"+SendEmail.email_greeting+e.getVisitor_name()+",</h1>";
			htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+SendEmail.email_contact_intro+"</h3>";
		}
		
		//USER MSG COPY BOX
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: inline-block;padding: 20px;max-width: 700px;\"><p style=\"font-size:16px;\">\"";
		htmlMessage += e.getMsg();
		htmlMessage += "\"</p></div><br>";
		
		if(e.isAdmin_flag()) {
			htmlMessage += "<hr><br><p style=\"color:#999999;\">Their contact email is: "+e.getVisitor_email()+"</p>";
			
			if(!e.getPhone().isEmpty()) {
				htmlMessage += "<p style=\"color:#999999;\">Their phone number is: "+e.getPhone()+"</p>";
			}
			
			htmlMessage += "<p style=\"color:#999999;\">And their name is: "+e.getVisitor_name()+"</p><br><hr>";
		}
		htmlMessage += p(join("This paragraph has", b("bold"), "and", i("italic"), "text.")).render(); //recreate all the emails with this stuff - it's fun.
		htmlMessage += emailFoot();
		
		e.setBody(htmlMessage);
		
		return e;
	}
	
	//MOVE THIS METHOD OVER TO SENDEMAIL and keep all the html in this class...
	public static Envelope createNewsletterEmail(Envelope admin_env) {

		
		return null;
	}
	
	

}
