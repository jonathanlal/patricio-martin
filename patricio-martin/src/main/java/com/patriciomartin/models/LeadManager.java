package com.patriciomartin.models;

import com.patriciomartin.database.LeadManagerDao;
import com.patriciomartin.objects.Envelope;

/**
 * Model that saves to DB all interactions from users with forms like contact,newsletter,referral whatever
 */
public class LeadManager {

	LeadManagerDao lmdao = new LeadManagerDao();
	
	public void newContact(Envelope e) {
		lmdao.newContact(e);
	}
	
	
	public void newNewsLetter(String email) {
		lmdao.newNewsletter(email);
	}
	
}
