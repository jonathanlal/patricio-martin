package com.patriciomartin.servlets;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/GetPage")
public class GetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
    	//System.out.println("getting page: "+page);

		if(page == null || page.isEmpty()){
			request.setAttribute("error", "page variable was null or empty!");
			page= "error.jsp";
			
		}else if(page.startsWith("error.jsp")) { //check that this doesn't fire after first check is true.. (shoudn't in else if ?) 
			String error = page.replace("error.jsp?error=", "");
			if(error == null) {
				error = "error parameter was null wtf?";
			}
			request.setAttribute("error", error);
			
		}else if(page.startsWith("project.jsp")) { //changed from contains
			
			String project = page.replace("project.jsp?p=", "");
			String photos = createPhotoswipeArray(project);
			request.setAttribute("photos", photos);
			request.setAttribute("project", project);
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	
	@SuppressWarnings("unchecked")
	public String createPhotoswipeArray(String project) throws IOException {
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
	public static Dimension getImageDimension(String file) throws IOException {
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
