package com.patriciomartin.models;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import static j2html.TagCreator.*;

import com.patriciomartin.objects.Envelope;


public class HtmlSnippets {
	

	
	
	public static String customMetaTags(String title, String description, String image, String url_end){
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
    "<meta property=\"description\" name=\"description\" content=\""+description+"\">"+
    "<meta property=\"og:title\" content=\""+title+"\">"+
    "<meta property=\"og:url\" content=\""+canonical+"\">"+
    "<meta property=\"og:image\" content=\""+image+"\">"+
    "<meta property=\"og:description\" content=\""+description+"\">"+
    "<meta property=\"og:type\" content=\"website\">"+
    "<meta name=\"twitter:title\" content=\""+title+"\">" + 
    "<meta name=\"twitter:description\" content=\""+description+"\">"+
    "<meta name=\"twitter:image:src\" content=\""+image+"\">";
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
		
		htmlMessage += "<img style=\"vertical-align:middle;width:70%;max-width:200px;\" alt=\""+Globals.BRAND+"\" ";
		if(Globals.EMAIL_SENDER_TYPE_GOOGLE)
		htmlMessage += "src=\"cid:"+Globals.EMAIL_LOGO+"\" />";
		else
		htmlMessage += "src=\"img/email/"+Globals.EMAIL_LOGO+"\" />";
		htmlMessage += "</a>";
		htmlMessage += "<br/></div><br/>";
		htmlMessage += "<div style=\"background-color: white;display: inline-block;padding: 20px;text-align: center;margin-top:10px;\">";
		
		System.out.println(htmlMessage);
		return htmlMessage;
	}
	private static String emailFoot(Properties p){
		
		
		
		boolean isCID = Globals.EMAIL_SENDER_TYPE_GOOGLE;
		
		String htmlMessage = "<p style=\"color:#999999;\">"+p.getProperty("footer.confirm")+"</p>";
		htmlMessage += "<p style=\"color:#999999;\">"+p.getProperty("footer.noreply")+"</p>";
		htmlMessage += "<p style=\"color:#000000;\">"+p.getProperty("footer.regards")+"</p>";
		htmlMessage += "<p style=\"color:#000000;\"><b>"+Globals.BRAND+"<b></p>";
		htmlMessage += "</div>"; //the opening tag is in emailHead();
		
		//END OF GREY BOX
		htmlMessage += "<br><div style=\"text-align:center;\"><br>";
		
		if(Globals.EMAIL_FACEBOOK_ON) {
		//FACEBOOK
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_FACEBOOK+"\"> ";
		htmlMessage += "<img alt=\"Facebook\" ";
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_FACEBOOK+"\" />": "src=\"img/email/"+Globals.EMAIL_FACEBOOK+"\" />";
		htmlMessage += "</a>";
		}
		if(Globals.EMAIL_GOOGLEPLUS_ON) {
		//GOOGLE+
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_GOOGLEPLUS+"\"> ";
		htmlMessage += "<img alt=\"Google\" ";
		
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_GOOGLEPLUS+"\" />": "src=\"img/email/"+Globals.EMAIL_GOOGLEPLUS+"\" />";
		htmlMessage += "</a>";
		}
		if(Globals.EMAIL_TWITTER_ON) {
		//TWITTER
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_TWITTER+"\"> ";
		htmlMessage += "<img alt=\"Twitter\" ";
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_TWITTER+"\" />": "src=\"img/email/"+Globals.EMAIL_TWITTER+"\" />";
		htmlMessage += "</a>";
		}
		if(Globals.EMAIL_INSTAGRAM_ON) {
		//INSTAGRAM
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_INSTAGRAM+"\"> ";
		htmlMessage += "<img alt=\"Instagram\" ";
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_INSTAGRAM+"\" />": "src=\"img/email/"+Globals.EMAIL_INSTAGRAM+"\" />";
		htmlMessage += "</a>";
		}
		if(Globals.EMAIL_PINTEREST_ON) {
		//PINTEREST
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_PINTEREST+"\"> ";
		htmlMessage += "<img alt=\"Pinterest\" ";
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_PINTEREST+"\" />": "src=\"img/email/"+Globals.EMAIL_PINTEREST+"\" />";
		htmlMessage += "</a>";
		}
		if(Globals.EMAIL_LINKEDIN_ON) {
		//LINKEDIN
		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_LINKEDIN+"\"> ";
		htmlMessage += "<img alt=\"LinkedIn\" ";
		htmlMessage +=  isCID ? "src=\"cid:"+Globals.EMAIL_LINKEDIN+"\" />": "src=\"img/email/"+Globals.EMAIL_LINKEDIN+"\" />";
		htmlMessage += "</a>";
		}
		
//		htmlMessage += "<a style=\"text-decoration:none;\" href=\""+Globals.SOCIAL_LINKEDIN+"\"> ";
//		htmlMessage += "<img alt=\"Linkedin\" src=\""+Globals.EMAIL_CID_LINKEDIN+"\">";
//		htmlMessage += "</a>";
		
		htmlMessage += "<br>";
		 htmlMessage += "<a style=\"text-decoration:none;font-size:22px;weight:700;color:#1071b1;\" href=\""+Globals.DOMAIN_FULL+"\">"+Globals.DOMAIN_NAKED+"</a>";
		 htmlMessage += "<p style=\"font-size:16;font-weight:bold;color:#58595b;margin-top:0;text-decoration:none;\">"+Globals.EMAIL_ADDRESS_CONTACT+"</p>";
		 htmlMessage += "</div>";
		//END EMAIL BODY
		 
			//htmlMessage += p(join("This paragraph has", b("bold"), "and", i("italic"), "text.")).render(); //recreate all the emails with this stuff - it's fun.

		 
		 
			//END OF WHITE BOX
			htmlMessage += " </div>";
			//END OF GREY BOX
			htmlMessage += "</div>";
			htmlMessage +="</td></tr></table>";

		htmlMessage += "</html>";
		return htmlMessage;
	}
	private static void overrideTextWithLanguageIfi18n(String lang, String[] overrides)  {
		//overrides the text values set in emails and replaces it with the value for the correct language
		
		if(Globals.IS_i18n) {
			
			 Locale l = new Locale(lang); // "es", "en" ...
			 ResourceBundle b = ResourceBundle.getBundle("text", l);
			
			 for(int i = 0; i < overrides.length;i++) {
				 //REFLECTION (to get the class variable value and change it based on the language)
				 Field declaredField;
				try {
					declaredField = SendEmail.class.getDeclaredField(overrides[i]);
	
		         boolean accessible = declaredField.isAccessible();
		         declaredField.setAccessible(true);
		         String new_email_greeting = b.getString(overrides[i].replace("_", "."));
		         declaredField.set(SendEmail.class, new_email_greeting);
		         declaredField.setAccessible(accessible);
		         
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			 }
			 //same for every mail so do manually...(same thing as above line)
//			 SendEmail.email_greeting = b.getString("email.greeting");
//			 SendEmail.email_footer_confirm = b.getString("email.footer.confirm");
//			 SendEmail.email_footer_noreply = b.getString("email.footer.noreply");
//			 SendEmail.email_footer_regards = b.getString("email.footer.regards");
		}
		
	}
	

	
	
	//MOVE THIS METHOD OVER TO SENDEMAIL and keep all the html in this class...
	public static Envelope createContactEmail(Envelope e) throws IOException {
//		if(Globals.IS_i18n && e.getLang() != null) {
//		//i18n, whatever we put in the array below, will make it so that when you call overrideTextWithLanguageIfi18n(), the variable is overridden with whatever language
//		String[] overrides = {"email_contact_subject", "email_contact_intro"};
//		overrideTextWithLanguageIfi18n(e.getLang(), overrides); //really really cool lol
//		}
		PropertyFactory pf = new PropertyFactory();
		Properties p = pf.getPropertyFile("email", e.getLang());
//		String subject = pf.getPropertyKey("email","contact.subject", e.getLang());
		
//		e.setSubject(SendEmail.email_contact_subject);// (important to do after the override method above)
		String subject = p.getProperty("contact.subject");
	
		String htmlMessage = emailHead();
		if(e.isAdmin_flag()) {
			subject = p.getProperty("contact.admin.subject");
			//GREETING & INTRO PART
			htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">"+p.getProperty("greeting")+" "+e.getAdmin_name()+",</h1>";
			htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+p.getProperty("contact.admin")+"</h3>";	
		}else {
			//GREETING & INTRO PART
			htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">"+p.getProperty("greeting")+" "+e.getVisitor_name()+",</h1>";
			htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+p.getProperty("contact.intro")+"</h3>";
		}
		//USER MSG COPY BOX
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: inline-block;padding: 20px;max-width: 700px;\"><p style=\"font-size:16px;\">\"";
		htmlMessage += e.getMsg();
		htmlMessage += "\"</p></div><br>";
		if(e.isAdmin_flag()) {
			htmlMessage += "<hr><br><p style=\"color:#999999;\">Email: "+e.getVisitor_email()+"</p>";
			if(!e.getPhone().isEmpty()) {
				htmlMessage += "<p style=\"color:#999999;\">Telephone: "+e.getPhone()+"</p>";
			}
			htmlMessage += "<p style=\"color:#999999;\">Name: "+e.getVisitor_name()+"</p><br><hr>";
		}
		htmlMessage += emailFoot(p);
		e.setBody(htmlMessage);
		e.setSubject(subject);
		return e;
	}
	
	
	public static Envelope createNewsletterSignUpEmail(Envelope e) throws IOException {
		PropertyFactory pf = new PropertyFactory();
		Properties p = pf.getPropertyFile("email", e.getLang());
		e.setSubject(p.getProperty("newsletter.subject"));// (important to do after the override method above)
		String htmlMessage = emailHead();
		//GREETING & INTRO PART
		htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">"+p.getProperty("greeting")+" "+e.getAdmin_name()+",</h1>";
		htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+p.getProperty("newsletter.intro")+"</h3>";	
		//USER MSG COPY BOX
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: inline-block;padding: 20px;max-width: 700px;\"><p style=\"font-size:16px;\">\"";
		htmlMessage += e.getVisitor_email();
		htmlMessage += "\"</p></div><br>";
		htmlMessage += emailFoot(p);
		e.setBody(htmlMessage);
		return e;
	}
	
	

}
