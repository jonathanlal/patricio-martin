package com.patriciomartin.models;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;

/**
 * Manages the writing and reading of property files stored in Google Cloud Platform
 */
public class PropertyFactory {

	GoogleStorage gs = new GoogleStorage();
	
	//new property file
	public void newPropertyFile(String filename, HashMap<String, String> properties, String lang) throws IOException{
		String text = "";
		 String lineEnd = " \n";
		for (Map.Entry<String, String> entry : properties.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    text += key+" = "+value+lineEnd;
		}
		if(lang != null && !lang.equals(Globals.DEFAULT_LANG)) {
			filename = filename+"_"+lang;
		}
		
		gs.createTextBlob(Globals.DEFAULT_BUCKET, filename+".properties", text);
	}
	//update property file
	
	
	
	
	//get property file
	public Properties getPropertyFile(String filename, String lang) throws IOException {
		
		if(lang != null && !lang.equals(Globals.DEFAULT_LANG)) {
			filename = filename+"_"+lang;
		}
		
		Properties prop = new Properties();
		prop.load(new ByteArrayInputStream(gs.readBlob(Globals.DEFAULT_BUCKET, filename+".properties")));
		return prop;
		
	}
	
	//get property from file
	public String getPropertyKey(String filename, String key, String lang) throws IOException {
		
		if(lang != null && !lang.equals(Globals.DEFAULT_LANG)) {
			filename = filename+"_"+lang;
		}
		
		Properties prop = new Properties();
		prop.load(new ByteArrayInputStream(gs.readBlob(Globals.DEFAULT_BUCKET, filename+".properties")));
		
		return prop.getProperty(key);
		
	}

	
	
	
	
	
}
