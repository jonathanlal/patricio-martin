package com.patriciomartin.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Imgrid {
	
	
	public static ArrayList<String> createImgGrid(String project) throws IOException {
		ArrayList<String> images = new ArrayList<>();
		File folder = new File("img/"+project+"/dd");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  
			  String name = listOfFiles[i].getName();
			  images.add("/img/"+project+"/dd/"+name);
			  
			  }
		  }
		return images;
	}

}
