package com.patriciomartin.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.patriciomartin.models.GetDate;
import com.patriciomartin.objects.Envelope;


public class LeadManagerDao {

	public void newContact(Envelope e) {
		  try(Connection conn= DBConnection.getConnection(null)){
			  PreparedStatement	pst = conn.prepareStatement("insert into contact_responses (name,email,telephone,message,date) values (?,?,?,?,?);");  
			  pst.setString(1, e.getVisitor_name());
			  pst.setString(2, e.getVisitor_email());
			  pst.setString(3, e.getPhone());
			  pst.setString(4, e.getMsg());
			  pst.setString(5, GetDate.now());
				pst.executeUpdate();	
		  }catch (SQLException x) {
				x.printStackTrace();
			}
	}
	
	public void newNewsletter(String email) {
		  try(Connection conn= DBConnection.getConnection(null)){
			  PreparedStatement	pst = conn.prepareStatement("insert into newsletter_signup (email,date) values (?,?);");  
			  pst.setString(1, email);
			  pst.setString(2, GetDate.now());
				pst.executeUpdate();	
		  }catch (SQLException x) {
				x.printStackTrace();
			}
	}

}
