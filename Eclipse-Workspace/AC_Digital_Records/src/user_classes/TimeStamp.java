package user_classes;

import java.sql.Timestamp;
import java.util.Date;

/**
 * This class should extend existing timestamp
 * @author jma_u
 *
 */
public class TimeStamp extends Timestamp{
	
	Date time;
	String initials;
	
	public TimeStamp(long time, String initials) {
		super(time);
		this.initials = initials;
	}
	
}
