package utils;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class used for parsing date and string within different formats
 * @author Ahmed Fayez
 * Created on 8/12/2018
 */
public class DateUtils {

	public static Date convert(String dateString) {
		Date result = null;
		try {
			
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
	    result = formatter.parse(dateString);
	    
		}
		catch(Exception e) {
			System.out.println("Exception at date converter");
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * Converts from Date to String, will return empty string in case of null-date input
	 * @param date
	 * @return string
	 */
	public static String convert(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY"); 
		if (date==null)
			return "";
		return formatter.format(date);
	}
	
}
