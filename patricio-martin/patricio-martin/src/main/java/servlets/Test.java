package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.repackaged.com.google.gson.JsonArray;
import com.google.appengine.repackaged.com.google.gson.JsonObject;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		HttpSession session = (request.getSession(false));
//		session.setAttribute("cool", "nope");
//		
//		
//		System.out.println(session.isNew());
//		
//		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
//		rd.forward(request, response);
		
		
		
		   JsonObject json_response = new JsonObject();
		    JsonArray data_json = new JsonArray();
		
		
		    JsonObject json = new JsonObject();
		    json.addProperty("id", "1");
	        json.addProperty("nombre", "AQUA");
	        data_json.add(json);
	        
	        

		    JsonObject json2 = new JsonObject();
		    json2.addProperty("id", "2");
	        json2.addProperty("nombre", "AJEDREZ");
	        data_json.add(json2);
	        
	        
		    JsonObject json3 = new JsonObject();
		    json3.addProperty("id", "3");
	        json3.addProperty("nombre", "AUTO");
	        data_json.add(json3);
	        
		    
	        json_response.add("aaData", data_json);

	        response.setContentType("application/Json");
	        response.getWriter().write(json_response.toString());
		
		
	}


}
