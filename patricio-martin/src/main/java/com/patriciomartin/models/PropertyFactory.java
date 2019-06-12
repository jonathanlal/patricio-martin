package com.patriciomartin.models;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
		byte[] b = gs.readBlob(Globals.DEFAULT_BUCKET, filename+".properties");
		String str = new String(b, StandardCharsets.UTF_8);
		prop.load(new StringReader(str));
		return prop;
		
	}
	
	//get property from file
	public String getPropertyKey(String filename, String key, String lang) throws IOException {
		
		if(lang != null && !lang.equals(Globals.DEFAULT_LANG)) {
			filename = filename+"_"+lang;
		}
		
		Properties prop = new Properties();
		byte[] b = gs.readBlob(Globals.DEFAULT_BUCKET, filename+".properties");
		String str = new String(b, StandardCharsets.UTF_8);
		prop.load(new StringReader(str));
		
		return prop.getProperty(key);
		
	}

	
	
	
	
	
}
