package com.patriciomartin.servlets;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

@WebServlet("/GetPage")
public class GetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
    	System.out.println("getting page: "+page);

		
		if(page == null || page.isEmpty()){
			
			page= "error.jsp";
			
		}else if(page.contains("project.jsp")) {
			
			ArrayList<String> images = new ArrayList<String>();
			File folder = new File("img/la-cala");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
				  String image = "img/"+listOfFiles[i].getName();
				  images.add("../../"+image);
				 Dimension d = getImageDimension(image);
				 System.out.println(d.getHeight() +"x"+d.getWidth());
			  }
			}
			
			request.setAttribute("project", request.getParameter("p"));
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
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
//		      log.warn("Error reading: " + imgFile.getAbsolutePath(), e);
		    } finally {
		      reader.dispose();
		    }
		  }

		  throw new IOException("Not a known image file: " + imgFile.getAbsolutePath());
		}

}
