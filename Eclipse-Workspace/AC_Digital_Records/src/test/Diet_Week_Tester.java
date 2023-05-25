package test;

import java.time.LocalDate;

import package_model.Time_Stamp;

public class Diet_Week_Tester {

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
