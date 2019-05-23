package com.patriciomartin.models;

import javax.servlet.http.HttpServletRequest;


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
	
	public static String emailHead(){
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
		return htmlMessage;
	}
	public static String emailFoot(){
		//END OF GREY BOX
		String htmlMessage = "<br><div style=\"text-align:center;\"><br>";
		
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
		 htmlMessage += "<a style=\"text-decoration:none;font-size:22px;weight:700;color:#1071b1;\" href=\""+Globals.DOMAIN_FULL+"\">";
		 htmlMessage += Globals.DOMAIN_NAKED;
		 htmlMessage += "</a>";
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
	public static String emailContact(String name, String msg){
		//WHITE BOX
		String htmlMessage = "<div style=\"background-color: white;display: inline-block;padding: 20px;text-align: center;margin-top:10px;\">";
		//GREETING PART
		htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">Hello "+name+",</h1>";
		//NEW USER
		htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">Thanks for contacting us. Here's a copy of the message you sent us:</h3>";
		//USER MSG COPY BOX
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: inline-block;padding: 20px;max-width: 700px;\"><p style=\"font-size:16px;\">\"";
		htmlMessage += msg;
		htmlMessage += "\"</p></div><br>";
		//WRAP UP
		htmlMessage += "<p style=\"color:#999999;\">This is an automated email just to confirm that we got your message!</p>";
		htmlMessage += "<p style=\"color:#999999;\">Please do not reply to this email.</p><br>";
		htmlMessage += "<p style=\"color:#000000;\">Sincerely,</p>";
		htmlMessage += "<p style=\"color:#000000;\"><b>"+Globals.BRAND+"<b></p>";
		htmlMessage += "</div>";
		return htmlMessage;
	}
	
	

}
