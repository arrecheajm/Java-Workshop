package package_model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Class creates a TimeStamp with initials. TimeStamp cannot be edited after it is created
 * @author jma_u
 *
 */
public class Time_Stamp extends Timestamp{
	
	//Date time;
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
		System.out.println(temp);
		return new Time_Stamp(temp, initials);
	}
}
