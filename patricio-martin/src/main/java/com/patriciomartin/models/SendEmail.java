package com.patriciomartin.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
//import javax.ws.rs.core.MediaType;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
//import com.sun.jersey.multipart.FormDataMultiPart;
//import com.sun.jersey.multipart.file.FileDataBodyPart;

public class SendEmail {

	


//	CONTACT CONFIRMATION EMAIL 
	public void sendContactMailConfirmation(String name,String email, String msg) throws FileNotFoundException, MalformedURLException{
		
		String subject = "We have received your message and we will reply shortly!";
		
					//START EMAIL BODY			
					String htmlMessage = HtmlSnippets.emailHead();

					htmlMessage += HtmlSnippets.emailContact(name, msg);
					
					//END EMAIL BODY
					htmlMessage += HtmlSnippets.emailFoot();
					
			//SEND MAIL
			send(email,htmlMessage,subject);
	}
//	CONTACT ADMIN EMAIL 
	private void sendAdminContactLeadMail(String name,String email, String hearus, String msg, String toemail, String adminname) throws FileNotFoundException, MalformedURLException{
		//START EMAIL BODY			
		String htmlMessage = HtmlSnippets.emailHead();
		//WHITE BOX
		htmlMessage += "<div style=\"background-color: white;display: inline-block;padding: 20px;text-align: center;\">";
		//GREETING PART
		htmlMessage += "<h1 style=\"margin-top: 0px;color: #84A9E5;font-weight: bolder;text-align:center;font-size: 20px;\">Hello "+adminname+",</h1>";
		//NEW USER
		htmlMessage += "<h3 style=\"color:#55C5AE;font-weight: bolder;\">"+name+" sent us a message:</h3>";
		//USER MSG COPY BOX
		htmlMessage += "<div style=\"background-color: #FAFAFA;display: inline-block;padding: 20px;max-width: 700px;\"><p style=\"font-size:16px;\">\"";
		htmlMessage += msg;
		htmlMessage += "\"</p></div><br>";
		//WRAP UP
		htmlMessage += "<p style=\"color:#999999;\">"+name+" found us "+hearus+"</p>";
		htmlMessage += "<p style=\"color:#999999;\">And their contact email is: "+email+"</p>";
		htmlMessage += "</div>";
		//END EMAIL BODY
		htmlMessage += HtmlSnippets.emailFoot();
		
		//SEND MAIL
		send(toemail,htmlMessage,"Message from "+name);
	}


	
	
	
	
	
	
	
	
	public void sendContactMail(String name, String email, String msg, String lang) {
		
		String subject = "";
		if(lang == null || lang.equals("en"))
			subject = "We have received your message and we will reply shortly!";
		else if(lang.equals("es"))
			subject =  "¡Hemos recibido tu mensaje y te responderemos pronto!";
		//get the html for the email
		
		
		
		//send to admin(s)
		
		//send to client
		
		
	}
	
	
	
	
	
	
	
	
	

	


	public void sendAdminContactLead(String name, String email, String hearfrom, String msg) throws FileNotFoundException, MalformedURLException {
		
		Map<String,String> admins = getAdminEmails();
		for(Entry<?, ?> e: admins.entrySet()){
		    String adminName = (String) e.getKey();
		    String adminEmail = (String) e.getValue();
			sendAdminContactLeadMail(name, email, hearfrom, msg, adminEmail, adminName);
		}
	}


	public Map<String, String> getAdminEmails(){
		return Globals.EMAIL_ADMIN_HASHMAP;
//	     Map<String, String> admins = new HashMap<>();
//	     admins.put("Jonathan", "jonathan@thewebdevil.com");
//		return admins;
	}
	
	
	
	
	
	
	
	
	
//	  public static ClientResponse sendFromMailgun(String useremail,String htmlBody,String subject) {
//	   Client client = Client.create();
//	   client.addFilter(new HTTPBasicAuthFilter("api",Globals.MAILGUN_API_KEY));
//	   WebResource webResource = client.resource(Globals.MAILGUN_BASE_URL);
//	   FormDataMultiPart form = new FormDataMultiPart();
//	   form.field("from", Globals.MAILGUN_FROM+" <postmaster@" + Globals.MAILGUN_MAIL_DOMAIN + ">");
//	   form.field("to", useremail);
//	   form.field("subject", subject);
//	   form.field("html", htmlBody);
//	   File logo = new File("img/email-logo-v2.png");
//	   form.bodyPart(new FileDataBodyPart("inline",logo,MediaType.APPLICATION_OCTET_STREAM_TYPE));
//	   
//	   File shareFacebook = new File("img/facebook-32.png");
//	   File shareTwitter = new File("img/twitter-32.png");
//	   File shareLinkedIn = new File("img/link-32.png");
//	   form.bodyPart(new FileDataBodyPart("inline",shareFacebook,MediaType.APPLICATION_OCTET_STREAM_TYPE));
//	   form.bodyPart(new FileDataBodyPart("inline",shareTwitter,MediaType.APPLICATION_OCTET_STREAM_TYPE));
//	   form.bodyPart(new FileDataBodyPart("inline",shareLinkedIn,MediaType.APPLICATION_OCTET_STREAM_TYPE));
//	   
//	   return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
//	}
	
	
	
	
	
	
	public void send(String useremail, String htmlBody,String subject) throws MalformedURLException{

		//ADD IMAGES
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		mapInlineImages.put("logo1", Globals.EMAIL_LOGO);
		
	    Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);
	    String msgBody = "...";
	    try {
	      Message msg = new MimeMessage(session);
	      msg.setFrom(new InternetAddress("noreply@"+Globals.DOMAIN_APPSPOT, Globals.BRAND));
	      msg.addRecipient(Message.RecipientType.TO,new InternetAddress(useremail, "Admin"));
	      msg.setSubject(subject);
	      msg.setText(msgBody);
	    MimeBodyPart messageBodyPart = new MimeBodyPart();
	    messageBodyPart.setContent(htmlBody, "text/html");
	    Multipart multipart = new MimeMultipart("related");
	    multipart.addBodyPart(messageBodyPart);
	    if (mapInlineImages != null && mapInlineImages.size() > 0) {
	        Set<String> setImageID = mapInlineImages.keySet();
	        for (String contentId : setImageID) {
	            MimeBodyPart imagePart = new MimeBodyPart();
	            imagePart.setHeader("Content-ID", "<" + contentId + ">");
	            imagePart.setDisposition(MimeBodyPart.INLINE);
	            String imageFilePath = mapInlineImages.get(contentId);
	            try {imagePart.attachFile(imageFilePath);
	            } catch (IOException ex) {ex.printStackTrace();
	            }multipart.addBodyPart(imagePart);}}
	    msg.setContent(multipart);
	    Transport.send(msg);
	    } catch (AddressException e) {} 
	    catch (MessagingException e) {} 
	    catch (UnsupportedEncodingException e) {}
	}

}
