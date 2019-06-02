package com.patriciomartin.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.patriciomartin.models.GetDate;


public class PageStatsDao {
	

	public static void recordRequest(String url, String mem, String load_time, String url_mapping_type) {
		  try(Connection conn= DBConnection.getConnection(null)){  
		PreparedStatement	pst = conn.prepareStatement("insert into page_speed (url,mem,load_time,url_mapping_type,date) values (?,?,?,?,?);");
		  
		  pst.setString(1, url);  
		  pst.setString(2, mem);
		  pst.setString(3, load_time);
		  pst.setString(4, url_mapping_type);
		  pst.setString(5, GetDate.now());

		  pst.executeUpdate();
	  }catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
