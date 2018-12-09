package com.fym.cse.dbUtils;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Ahmed Fayez
 * Created on 8/12/2018
 */
public class StringToDate {

	public static Date convert(String dateString) {
		Date result = null;
		try {
			
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
	    result = sdt.parse(dateString);
	    
		}
		catch(Exception e) {
			System.out.println("Date converter exception");
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
}
