package ac_Digital_Records_Model_Testers;

import java.time.LocalDate;

import ac_Digital_Records_Models.Time_Stamp;

public class Tester_Diet_Week {

	public static void main(String[] args) {
		long temp = new java.util.Date().getTime();
		LocalDate dt = LocalDate.now();
		dt = dt.minusDays(1);
//		System.out.println("Date: "+dt.toString());
//		System.out.println("Day of the week: "+dt.getDayOfWeek().getValue());
		System.out.println(Time_Stamp.stamp("JA").toString());
		System.out.println(Time_Stamp.getMondaysDateAsString());

	}

}
