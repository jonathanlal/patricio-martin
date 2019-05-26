package com.patriciomartin.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
 

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "url-mappings")
public class Urls {
	
//	public static HashMap<String,String> URLS = getUrlJspMappings(null);
	

    @XmlElement(name = "map")
    private List<Url> urls = new ArrayList<Url>();
	
    public Urls() {}
 
    public List<Url> getUrls() {
        return urls;
    }
 
    public void setUrls(List<Url> urls) {
        this.urls = urls;
    } 
    
	
	



}
