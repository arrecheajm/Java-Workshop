package package_model;

//TODO add comment section!!!!
public class Diet_Week_Item extends Diet{
	private boolean completed;
	private Time_Stamp completeTime;
	
	/****** CONSTRUCTORS ******/
	
	/**
	 * @param dailyDiet
	 * @param initials
	 */
	public Diet_Week_Item(Diet dailyDiet, String initials) {
		super(dailyDiet, initials);
//		dailyDiet.lock(initials);
		completed = false;
		completeTime = null;
	}
		
	
	/****** MUTATORS ******/
	public void completeDiet(String initials) {
		completed = true;
		completeTime = Time_Stamp.stamp(initials);
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public boolean getCompleted() {
		return this.completed;
	}
	
	/**
	 * @return
	 */
	public Time_Stamp getCompletedTime() {
		return this.completeTime;
	}
	
	/**
	 * @return
	 */
	public String getCompletedTimeString() {
		return this.completeTime.toString();
	}
	/****** UTILITY ******/
}
