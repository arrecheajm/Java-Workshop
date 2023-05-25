package package_model;

import utility_classes.MyLinkedList;

/**
 * Contains animal data including ID data, diet information and log, Notes and daily tasks
 * @author jma_u
 *
 */

public class Animal {
	private Animal_Data info;
	private Diet diet;
	private MyLinkedList<Diet_Week> dietLog;
	private MyLinkedList<String> notes;
	private MyLinkedList<String> dailyTasks;
	
	/****** CONSTRUCTORS ******/
		
	/**
	 * @param info
	 * @param diet
	 * @param dietLog
	 * @param notes
	 * @param dailyTasks
	 * @param initials
	 */
	public Animal(Animal_Data info, Diet diet, MyLinkedList<Diet_Week> dietLog, MyLinkedList<String> notes,
			MyLinkedList<String> dailyTasks, String initials) {
		setAll(info, diet, notes, dailyTasks, initials);
		dietLog = new MyLinkedList<Diet_Week>();
	}
	
	/**
	 * @param otherAnimal
	 * @param initials
	 */
	public Animal(Animal otherAnimal, String initials) {
		setAll(otherAnimal.getInfo(), otherAnimal.getDiet(), otherAnimal.getNotes(), otherAnimal.getDailyTasks(), initials);
		setDietLog(otherAnimal.getDietLog());
	}	

	/****** MUTATORS ******/
	
	/**
	 * @param info
	 * @param diet
	 * @param notes
	 * @param dailyTasks
	 * @param initials
	 */
	private void setAll(Animal_Data info, Diet diet, MyLinkedList<String> notes,
			MyLinkedList<String> dailyTasks, String initials) {
		setInfo(info, initials);
		setDiet(diet, initials);
		setNotes(notes);
		setDailyTasks(dailyTasks);
	}

	/**
	 * @param dailyTasks
	 */
	private void setDailyTasks(MyLinkedList<String> dailyTasks) {
		this.dailyTasks = new MyLinkedList<String>();
		if(dailyTasks !=null) {
			for(int i=0; i<dailyTasks.size(); i++) {
				this.dailyTasks.add(dailyTasks.get(i));
			}
		}
		
	}

	/**
	 * @param notes
	 */
	public void setNotes(MyLinkedList<String> notes) {
		this.notes = new MyLinkedList<String>();
		if(notes != null) {
			for(int i=0; i<notes.size(); i++) {
				this.notes.add(notes.get(i));
			}
		}		
	}

	/**
	 * @param dietLog
	 */
	public void setDietLog(MyLinkedList<Diet_Week> dietLog) {
		this.dietLog = new MyLinkedList<Diet_Week>();
		if(dietLog != null) {
			for(int i=0; i<dietLog.size(); i++) {
				this.dietLog.add(dietLog.get(i));
			}
		}		
	}

	private void setDiet(Diet diet, String initials) {
		this.diet = new Diet(diet, initials); 
		
	}

	public void setInfo(Animal_Data info, String initials) {
		this.info = new Animal_Data(info, initials);
		
	}
	
	/****** ACCESSORS ******/
	/**
	 * @return
	 */
	public MyLinkedList<String> getDailyTasks() {
		return this.dailyTasks;
	}

	/**
	 * @return
	 */
	public MyLinkedList<String> getNotes() {
		return this.notes;
	}
	
	public MyLinkedList<Diet_Week> getDietLog() {
		return this.dietLog;
	}

	public Diet getDiet() {
		return this.diet;
	}

	public Animal_Data getInfo() {
		return this.info;
	}
	
	/****** UTILITY ******/
	public void validateDietLog() {
		if (Time_Stamp.validateWeek((Diet_Week)((Time_Stamp) dietLog.get(dietLog.size()-1)).getMondaysDate());
	}
	
}
