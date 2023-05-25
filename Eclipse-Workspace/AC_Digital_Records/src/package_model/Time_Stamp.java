package package_model;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Class creates a TimeStamp with initials. TimeStamp cannot be edited after it is created
 * @author jma_u
 *
 */
@SuppressWarnings("serial")
public class Time_Stamp extends Timestamp{
	
	String initials;
	
	/****** CONSTRUCTORS ******/
	
	/**
	 * Constructor for TimeStamp. Requires a time in milliseconds in a variable of type of long
	 * and a string containing the initials creating the TimeStamp.
	 * 
	 * @param time Long - time in milliseconds
	 * @param initials String containing the initials of the TimeStamp creator.
	 */
	public Time_Stamp(long time, String initials) {
		super(time);
		this.initials = initials;
	}
	
	
	/****** MUTATORS ******/
	
	/****** ACCESSORS ******/

	/**
	 * Returns a String containing the value of the initials used to create the TimeStamp.
	 * @return
	 */
	public String getInitials() {
		return this.initials;
	}
	
	/****** UTILITY ******/
	/**
	 *Returns a String containing TimeStamp data, initials followed by time.
	 */
	public String toString() {
		return "By: "+this.initials+" at: "+super.toString()+"\n";		
	}
	
	/**
	 * Static method for creating a TimeStamp with given initials.
	 * @param initials String containing the initials of the TimeStamp creator
	 * @return
	 */
	public static Time_Stamp stamp(String initials) {
		long temp = new java.util.Date().getTime();
		return new Time_Stamp(temp, initials);
	}
	
	/**
	 * @return A LocalDate object containing the date of the most recent Monday
	 */
	public static LocalDate getMondaysDate() {
		LocalDate date = LocalDate.now();
		int day = date.getDayOfWeek().getValue();
		if (day > 1) {
			int offset = day-1;
			date = date.minusDays(offset);
		}
		return date;
	}
	
	/**
	 * @return
	 */
	public static String getMondaysDateAsString() {
		return getMondaysDate().toString();
	}
	
	public static boolean validateWeek(LocalDate mondayDate) {
		return getMondaysDate().isEqual(mondayDate); 
	}
}
