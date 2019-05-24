package com.patriciomartin.objects;

public class Envelope {

	String visitor_name;
	String visitor_email;
	String admin_name;
	String admin_email;
	String lang;
	String msg; //the text the user inputs in contact form msg textarea
	boolean admin_flag;
	String subject;
	String body;
	
	
	
	public String getVisitor_name() {
		return visitor_name;
	}
	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getVisitor_email() {
		return visitor_email;
	}
	public void setVisitor_email(String visitor_email) {
		this.visitor_email = visitor_email;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public boolean isAdmin_flag() {
		return admin_flag;
	}
	public void setAdmin_flag(boolean admin_flag) {
		this.admin_flag = admin_flag;
	}
	

	
	
	
}
