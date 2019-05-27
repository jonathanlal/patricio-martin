package com.patriciomartin.models;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PhotoSwipe {
	
	
	@SuppressWarnings("unchecked")
	public static String createPhotoswipeArray(String project) throws IOException {
	    JSONArray arr = new JSONArray();
	    JSONObject tmp;
		File folder = new File("img/"+project);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  tmp = new JSONObject();
			  
			  String name = listOfFiles[i].getName();
			  
			  if(!name.contains("logo")) {
			  String image = "img/"+project+"/"+name;
			  tmp.put("src", "../../"+image);
			  Dimension d = getImageDimension(image);
			  tmp.put("w",  String.format("%.0f", d.getWidth()));
			  tmp.put("h", String.format("%.0f", d.getHeight()));
			  arr.add(tmp);
			  
			  }
		  }
		}
		return "window.photoswipe_items = "+arr.toJSONString();
	}
	private static Dimension getImageDimension(String file) throws IOException {
		File imgFile = new File(file);
		  int pos = imgFile.getName().lastIndexOf(".");
		  if (pos == -1)
		    throw new IOException("No extension for file: " + imgFile.getAbsolutePath());
		  String suffix = imgFile.getName().substring(pos + 1);
		  Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
		  while(iter.hasNext()) {
		    ImageReader reader = iter.next();
		    try {
		      ImageInputStream stream = new FileImageInputStream(imgFile);
		      reader.setInput(stream);
		      int width = reader.getWidth(reader.getMinIndex());
		      int height = reader.getHeight(reader.getMinIndex());
		      return new Dimension(width, height);
		    } catch (IOException e) {
		    	//log.warn("Error reading: " + imgFile.getAbsolutePath(), e);
		    } finally {
		      reader.dispose();
		    }
		  }
		  throw new IOException("Not a known image file: " + imgFile.getAbsolutePath());
		}


}
