package com.patriciomartin.models;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
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
	//if language is spanish then these variables are overridden by reflection
	public static String email_contact_subject = "We have received your message and we will reply shortly!";
	public static String email_contact_intro = "Thanks for contacting us. Here's a copy of the message you sent us:";
	public static String email_contact_admin = "Here's a copy of the message they sent:";
	
	public static String email_newsletter_subject = "New newsletter signup!";
	public static String email_newsletter_intro = "Someone signuped for the newsletter with the following email address:";
	
	
	//used at the bottom of emails to users so that they don't reply to a noreply address...
	public static String email_greeting = "Hello ";
	public static String email_footer_confirm = "This is an automated email just to confirm that we got your message!";
	public static String email_footer_noreply = "Please do not reply to this email.";
	public static String email_footer_regards = "Sincerely,";
	

	
	public void sendContactMail(Envelope visitor_env)  {
		
		//CREATE USER CONTACT EMAIL & SEND
		visitor_env = HtmlSnippets.createContactEmail(visitor_env);
		send(visitor_env.getVisitor_email(), visitor_env.getBody(), visitor_env.getSubject());
		 
		//FOR EACH ADMIN EMAIL
		Map<String,String> admin_emails = getAdminEmails();
		for(Entry<?, ?> e: admin_emails.entrySet()){
			String admin_name = (String) e.getKey();
			String admin_email = (String) e.getValue();
			Envelope admin_env = new Envelope();
			admin_env.setMsg(visitor_env.getMsg());
			admin_env.setLang(visitor_env.getLang());
			admin_env.setAdmin_name(admin_name);
			admin_env.setAdmin_email(admin_email);
			admin_env.setAdmin_flag(true);
			admin_env.setVisitor_email(visitor_env.getVisitor_email());
			admin_env.setVisitor_name(visitor_env.getVisitor_name());
			admin_env.setPhone(visitor_env.getPhone());
			//CREATE ADMIN CONTACT EMAIL & SEND
			admin_env = HtmlSnippets.createContactEmail(admin_env);
			send(admin_email, admin_env.getBody(), admin_env.getSubject()); 
		}
		//RECORD IN DB
		LeadManager lm = new LeadManager();
		lm.newContact(visitor_env);
	}
  public void sendNewsLetterSignUpMail(String email) throws MalformedURLException {
	  
		//SEND USER EMAIL -no need..."confirmed that you are now signed up" waste...
	   System.out.println("Sending admin email");
		//SEND ADMIN EMAILS
		Map<String,String> admin_emails = getAdminEmails();
		for(Entry<?, ?> e: admin_emails.entrySet()){
			String admin_name = (String) e.getKey();
			String admin_email = (String) e.getValue();
			Envelope admin_env = new Envelope();
			admin_env.setVisitor_email(email);
			admin_env.setAdmin_name(admin_name);
			admin_env.setAdmin_email(admin_email);
			admin_env.setAdmin_flag(true);
			admin_env = HtmlSnippets.createNewsletterSignUpEmail(admin_env); 
			send(admin_email, admin_env.getBody(), admin_env.getSubject());
			  System.out.println("Email sent!");
		}
		//RECORD IN DB
		LeadManager lm = new LeadManager();
		lm.newNewsLetter(email);
  }
	public Map<String, String> getAdminEmails(){
		return Globals.EMAIL_ADMIN_HASHMAP;
	}

	
	
	public void send(String email, String body, String subject) {
		
		//what to do about images? ??????
		if(Globals.EMAIL_SENDER_TYPE_GOOGLE) {
			try {
				  System.out.println("Sending with google");
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
		Map<String, String> mapInlineImages = new HashMap<String, String>();
//		mapInlineImages.put(Globals.EMAIL_LOGO, "img/email/"+Globals.EMAIL_LOGO);
		
	   if(Globals.EMAIL_FACEBOOK_ON)
	   mapInlineImages.put(Globals.EMAIL_FACEBOOK, "img/email/"+Globals.EMAIL_FACEBOOK);
	   if(Globals.EMAIL_TWITTER_ON)
		   mapInlineImages.put(Globals.EMAIL_TWITTER, "img/email/"+Globals.EMAIL_TWITTER);
	   if(Globals.EMAIL_LINKEDIN_ON)
		   mapInlineImages.put(Globals.EMAIL_LINKEDIN, "img/email/"+Globals.EMAIL_LINKEDIN);
	   if(Globals.EMAIL_PINTEREST_ON)
		   mapInlineImages.put(Globals.EMAIL_PINTEREST, "img/email/"+Globals.EMAIL_PINTEREST);
	   if(Globals.EMAIL_GOOGLEPLUS_ON)
		   mapInlineImages.put(Globals.EMAIL_GOOGLEPLUS, "img/email/"+Globals.EMAIL_GOOGLEPLUS);
	   if(Globals.EMAIL_INSTAGRAM_ON)
		   mapInlineImages.put(Globals.EMAIL_INSTAGRAM, "img/email/"+Globals.EMAIL_INSTAGRAM);
		
	    Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);
	    String msgBody = "...";
	    try {
	    	  System.out.println("try clause");
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
	   
	   form.bodyPart(new FileDataBodyPart("inline", new File("img/email/"+Globals.EMAIL_LOGO),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   
	   
	   if(Globals.EMAIL_FACEBOOK_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_FACEBOOK),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   if(Globals.EMAIL_TWITTER_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_TWITTER),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   if(Globals.EMAIL_LINKEDIN_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_LINKEDIN),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   if(Globals.EMAIL_PINTEREST_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_PINTEREST),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   if(Globals.EMAIL_GOOGLEPLUS_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_GOOGLEPLUS),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   if(Globals.EMAIL_INSTAGRAM_ON)
	   form.bodyPart(new FileDataBodyPart("inline",new File("img/email/"+Globals.EMAIL_INSTAGRAM),MediaType.APPLICATION_OCTET_STREAM_TYPE));
	   
	   return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
	}

}
