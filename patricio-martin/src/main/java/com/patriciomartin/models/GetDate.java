package com.patriciomartin.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class GetDate {
	public static String now(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date now = new Date();
		   return dateFormat.format(now);
	}
	public String uniqueNumbers(){
		   return Long.toString(System.currentTimeMillis());
	}
	 public String getFormattedDate(String input) throws ParseException{
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date date = dateFormat.parse(input);
       Calendar cal=Calendar.getInstance();
       cal.setTime(date);
       //2nd of march 2015
       int day=cal.get(Calendar.DATE);

       if(!((day>10) && (day<19)))
       switch (day % 10) {
       case 1:  
           return new SimpleDateFormat("d'st' 'of' MMMM yyyy").format(date);
       case 2:  
           return new SimpleDateFormat("d'nd' 'of' MMMM yyyy").format(date);
       case 3:  
           return new SimpleDateFormat("d'rd' 'of' MMMM yyyy").format(date);
       default: 
           return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(date);
   }
   return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(date);
}
	 
	 
	 public static String addDays(String old_date, int days) {
		 
			//Given Date in String format
			String oldDate = old_date;  
//			System.out.println("Date before Addition: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, days);  
			//Date after adding the days to the given date
			return sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
//			System.out.println("Date after Addition: "+newDate);
		 
	 }
	 
	    public static String convertDate(String date) throws ParseException {
	    	String oldFormatData = date;
	    	SimpleDateFormat oldDate = new SimpleDateFormat("dd/MM/yyyy");
	    	SimpleDateFormat newDate = new SimpleDateFormat("MM/dd/yyyy");
	    	Date old = oldDate.parse(oldFormatData);
	    	return newDate.format(old);
	    }
	 
	
}
