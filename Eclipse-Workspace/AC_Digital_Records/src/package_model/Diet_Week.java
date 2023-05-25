package package_model;

import java.time.LocalDate;

/**
 * Class holds a week of diet entry for a feeding cycle starting on Monday
 * @author jma_u
 *
 */
public class Diet_Week {
	public static final int DAYS_IN_A_WEEK = 7;
	
	LocalDate mondayDate;
	Diet_Week_Item[] diet_week;
	
	/****** CONSTRUCTORS ******/
	
	public Diet_Week(Diet dailyDiet, String initials) throws Undefined_Diet_Exception {
		mondayDate = Time_Stamp.getMondaysDate();
		createNewDietWeek(dailyDiet, initials);
	}

	

	/****** MUTATORS ******/
	
	/**
	 * @param mondayDate
	 * @param diet_week
	 */
	public void setAll(LocalDate mondayDate, Diet_Week_Item[] diet_week) {
		setMondayDate(mondayDate);
		setDietWeek(diet_week);
	}

	/**
	 * @param diet_week
	 */
	public void setDietWeek(Diet_Week_Item[] diet_week) {
		if (diet_week != null) {
			this.diet_week = diet_week;
		}
		
	}

	/**
	 * @param mondayDate
	 */
	public void setMondayDate(LocalDate mondayDate) {
		if (mondayDate != null) {
			this.mondayDate = mondayDate;
		}
		
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public LocalDate getMondayDate() {
		return this.mondayDate;
	}
	
	/**
	 * @return
	 */
	public Diet_Week_Item[] getDietWeek() {
		return this.diet_week;
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Diet_Week_Item getDietWeekIndex(int index) {
		return this.diet_week[index];
	}
	
	public Diet_Week_Item getDietWeekDay(String weekDay) {
		String temp = weekDay.toUpperCase();
		switch(temp) {
		case "MONDAY":
			return getDietWeekIndex(0);
		case "TUESDAY":
			return getDietWeekIndex(1);
		case "WEDNESDAY":
			return getDietWeekIndex(2);
		case "THURSDAY":
			return getDietWeekIndex(3);
		case "FRIDAY":
			return getDietWeekIndex(4);
		case "SATURDAY":
			return getDietWeekIndex(5);
		case "SUNDAY":
			return getDietWeekIndex(0);
		default:
			return null;
		}
	}
	
	/****** UTILITY ******/
	
	
	private void createNewDietWeek(Diet dailyDiet, String initials) throws Undefined_Diet_Exception {
		if (dailyDiet != null) {
			diet_week = new Diet_Week_Item[DAYS_IN_A_WEEK];
			for (int i=0; i<diet_week.length; i++) {
				diet_week[i] = new Diet_Week_Item(dailyDiet, initials);
			}
		} else {
			throw new Undefined_Diet_Exception("Daily Diet is not defined.");
		}
	}
	
}
