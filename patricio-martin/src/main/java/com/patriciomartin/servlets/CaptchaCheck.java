package com.patriciomartin.servlets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/CaptchaCheck")
public class CaptchaCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USER_AGENT = "Mozilla/5.0";
    public CaptchaCheck() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String token = request.getParameter("token");
		//String action = request.getParameter("action");
		//String jsonString = "{  \"success\": true,  \"challenge_ts\": \"2019-06-12T23:29:07Z\",  \"hostname\": \"patriciomartin.com\",  \"score\": 0.9,  \"action\": \"newsletter\"}";

		String check = "false";
		
		try {
	     JSONObject jo = new JSONObject(sendPost(token));
		     
		     String result = jo.get("success").toString();
		     
		     if(result != null && result.equals("true")) {
		    	 check = "true";
		     }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	

	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(check);       // Write response body.
		
		
	}
	// HTTP POST request
	private String sendPost(String token) throws Exception {
		String secret_key = "6LdnQKcUAAAAAI43aVbujpheAy4gXwEgUDvBVTp9";
		
		String url = "https://www.google.com/recaptcha/api/siteverify";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "secret="+secret_key+"&response="+token;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		return response.toString();

	}

}
