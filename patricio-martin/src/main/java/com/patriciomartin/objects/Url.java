package com.patriciomartin.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Url {
	
	public Url() {}
	
	  @XmlAttribute
	  public String name,url,lang,call,id;
//	  @XmlAttribute
//	  public String url;
//	  @XmlAttribute
//	  public String lang;
//	  @XmlAttribute
//	  public String call;
//	  @XmlAttribute
//	  public String id;


	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	 
	
}
