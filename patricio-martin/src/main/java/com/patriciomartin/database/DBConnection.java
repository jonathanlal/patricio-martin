package com.patriciomartin.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.appengine.api.utils.SystemProperty;
import com.patriciomartin.models.Globals;

public class DBConnection {
	
	 public static Connection getConnection(String db_schema_name){
		 
		 if(db_schema_name == null){
			 db_schema_name = "patricio_martin";
		 }
		 
		 String url = null;
		 Connection conn = null;
		 try{
			 if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
				 Class.forName("com.mysql.jdbc.GoogleDriver");
				 url = "jdbc:google:mysql://"+Globals.DB_INSTANCE_CONNECTION_NAME+"/"+db_schema_name; 
			 } else {
				 Class.forName("com.mysql.jdbc.Driver"); //don't need to specify this apparently
				 url = "jdbc:mysql://"+Globals.DB_LOCALHOST+"/"+db_schema_name;
			 }
			 	conn = DriverManager.getConnection(url,Globals.DB_LOCAL_USER,Globals.DB_LOCAL_PASSWORD);
		 	}catch(Exception e) {e.printStackTrace();} 
		 return conn;
	 }
}
