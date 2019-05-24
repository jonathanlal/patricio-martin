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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import javax.ws.rs.core.MediaType;

import com.patriciomartin.objects.Envelope;

public class SendEmail {
	
	//for each new type of email, define a variable for the subject here. (it's defined here because of the i18n implementation)
	//is language is spanish then these variables are overridden by reflection
	public static String email_contact_subject = "We have received your message and we will reply shortly!";
	public static String email_contact_intro = "Thanks for contacting us. Here's a copy of the message you sent us:";
	public static String email_contact_admin = "Here's a copy of the message they sent:";
	
	//used at the bottom of emails to users so that they don't reply to a noreply address...
	public static String email_greeting = "Hello ";
	public static String email_footer_confirm = "This is an automated email just to confirm that we got your message!";
	public static String email_footer_noreply = "Please do not reply to this email.";
	public static String email_footer_regards = "Sincerely,";
	

	
	public void sendContactMail(String visitor_name, String visitor_email, String msg, String phone, String lang)  {
		
		//SEND USER EMAIL
		Envelope visitor_env = new Envelope();
		visitor_env.setMsg(msg);
		visitor_env.setLang(lang);
		visitor_env.setVisitor_name(visitor_name);
		visitor_env.setVisitor_email(visitor_email);
		visitor_env.setAdmin_flag(false);
		
		try {
			visitor_env = HtmlSnippets.createContactEmail(visitor_env);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}	
			
		send(visitor_env.getVisitor_email(), visitor_env.getBody(), visitor_env.getSubject());
		 
		//SEND ADMIN EMAILS
		Map<String,String> admin_emails = getAdminEmails();
		for(Entry<?, ?> e: admin_emails.entrySet()){
			String admin_name = (String) e.getKey();
			String admin_email = (String) e.getValue();
			Envelope admin_env = new Envelope();
			admin_env.setMsg(msg);
			admin_env.setLang(lang);
			admin_env.setAdmin_name(admin_name);
			admin_env.setAdmin_email(admin_email);
			admin_env.setAdmin_flag(true);
			admin_env.setVisitor_email(visitor_email);
			admin_env.setVisitor_name(visitor_name);
			admin_env.setPhone(phone);
			
			try {
				admin_env = HtmlSnippets.createContactEmail(admin_env);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			} 
			
			send(admin_email, admin_env.getBody(), admin_env.getSubject()); //make a switch here... so based on what mail sender implementation we use we send with that
		}
	}
  public void sendNewsLetterMail(String email) throws MalformedURLException {
	  
		//SEND USER EMAIL -no need..."confirmed that you are now signed up" waste...
	  
		//SEND ADMIN EMAILS
		Map<String,String> admin_emails = getAdminEmails();
		for(Entry<?, ?> e: admin_emails.entrySet()){
			String admin_name = (String) e.getKey();
			String admin_email = (String) e.getValue();
			Envelope admin_env = new Envelope();
			admin_env.setAdmin_name(admin_name);
			admin_env.setAdmin_email(admin_email);
			admin_env.setAdmin_flag(true);
			admin_env = HtmlSnippets.createNewsletterEmail(admin_env); 
			send(admin_email, admin_env.getBody(), admin_env.getSubject());
		}
  }
	public Map<String, String> getAdminEmails(){
		return Globals.EMAIL_ADMIN_HASHMAP;
	}

	
	
	public void send(String email, String body, String subject) {
		
		//what to do about images? ??????
		if(Globals.EMAIL_SENDER_TYPE_GOOGLE) {
			try {
				sendWithGoogle(email, body, subject);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else {
			//MAILGUN
			sendWithMailgun(email, body, subject);
		}
		
	}
	
	
	
	public void sendWithGoogle(String useremail, String htmlBody,String subject) throws MalformedURLException{

		//ADD IMAGES
		Map<String, String> mapInlineImages = new HashMap<String, String>(); //what to do about images? 
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
	

	
	  public static ClientResponse sendWithMailgun(String useremail,String htmlBody,String subject) {
	   Client client = Client.create();
	   client.addFilter(new HTTPBasicAuthFilter("api",Globals.MAILGUN_API_KEY));
	   WebResource webResource = client.resource(Globals.MAILGUN_BASE_URL);
	   FormDataMultiPart form = new FormDataMultiPart();
	   form.field("from", Globals.MAILGUN_FROM+" <postmaster@" + Globals.MAILGUN_MAIL_DOMAIN + ">");
	   form.field("to", useremail);
	   form.field("subject", subject);
	   form.field("html", htmlBody);
	   File logo = new File("img/email-logo-v2.png");
	   form.bodyPart(new FileDataBodyPart("inline",logo,MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   
	   File shareFacebook = new File("img/facebook-32.png");
	   File shareTwitter = new File("img/twitter-32.png");
	   File shareLinkedIn = new File("img/link-32.png");
	   form.bodyPart(new FileDataBodyPart("inline",shareFacebook,MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   form.bodyPart(new FileDataBodyPart("inline",shareTwitter,MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   form.bodyPart(new FileDataBodyPart("inline",shareLinkedIn,MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   
	   return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
	}

}
