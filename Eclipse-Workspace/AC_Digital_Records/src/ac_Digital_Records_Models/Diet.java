package ac_Digital_Records_Models;

import java.io.Serializable;

import utility_classes.MyLinkedList;

/**
 * Class contains a collection of food groups as a part of animal's diet. Diet Cannot be created or 
 * edited without providing initials for TimeStamp
 * @author jma_u
 *
 */

// TODO validate initials: Initials cannot be null or "", initials must be at least 2 characters, no more than 4.
// TODO add fed by variable or make a new diet_week_item class?

public class Diet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1686610493409941578L;
	private MyLinkedList<Food_Group> foodGroups;
	private String notes;
	private boolean locked;
	private Time_Stamp lastEdited;
	private Time_Stamp created;

	/****** CONSTRUCTORS ******/
	
	/**
	 * @param initials
	 */
	public Diet(String initials){
		created = Time_Stamp.stamp(initials);
		setLocked(false, initials);
		try {
			setAll(null, null, initials);
		} catch (Locked_Diet_Edit_Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param dailyDiet
	 * @param initials
	 */
	public Diet(Diet otherDiet, String initials) {
		created = Time_Stamp.stamp(initials);
		setLocked(false, initials);
		try {
			setAll(otherDiet.notes, otherDiet.getFoodGroup(), initials);
		} catch (Locked_Diet_Edit_Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param notes
	 * @param foodGroups
	 * @param initials
	 */
	public Diet(String notes, MyLinkedList<Food_Group> foodGroups, String initials){
		created = Time_Stamp.stamp(initials);
		setLocked(false, initials);
		try {
			setAll(notes, foodGroups, initials);
		} catch (Locked_Diet_Edit_Exception e) {
			e.printStackTrace();
		}
	}
	
	/****** MUTATORS ******/
	
	/**
	 * @param notes
	 * @param locked
	 * @param foodGroups
	 * @param initials
	 * @throws Locked_Diet_Edit_Exception
	 */
	public void setAll(String notes, MyLinkedList<Food_Group> foodGroups, String initials) throws Locked_Diet_Edit_Exception {
		setNotes(notes, initials);		
		setFoodGroup(foodGroups, initials);		
	}
	
	/**
	 * @param foodGroups
	 * @param initials
	 * @throws Locked_Diet_Edit_Exception
	 */
	public void setFoodGroup(MyLinkedList<Food_Group> foodGroups, String initials) throws Locked_Diet_Edit_Exception {
		if (!this.locked) {
			this.foodGroups = new MyLinkedList<Food_Group>();
			if(foodGroups != null) {
				for (int i=0; i<foodGroups.size(); i++) {				
					this.foodGroups.add(foodGroups.get(i));
				}
			}
			this.stamp(initials);
		} else {
			throw new Locked_Diet_Edit_Exception("Cannot edit a locked diet");
		}		
	}
	
	/**
	 * @param locked
	 * @param initials
	 */
	public void setLocked(boolean locked, String initials) {
		this.locked = locked;
		this.stamp(initials);
	}
	
	/**
	 * @param notes
	 * @param initials
	 * @throws Locked_Diet_Edit_Exception 
	 */
	public void setNotes(String notes, String initials) throws Locked_Diet_Edit_Exception {
		if (!this.locked) {
			this.notes = notes;
			this.stamp(initials);
		} else {
			throw new Locked_Diet_Edit_Exception("Cannot edit a locked diet");
		}	
		
	}
	
	/**
	 * 
	 */
	public void lock(String initials) {
		this.locked = true;
		this.stamp(initials);
	}
	
	/**
	 * @param initials
	 */
	public void unlock(String initials) {
		this.locked = false;
		this.stamp(initials);
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * @return
	 */
	public boolean getLocked() {
		return this.locked;
	}
	
	/**
	 * @return
	 */
	public MyLinkedList<Food_Group> getFoodGroup() {
		return this.foodGroups;
	}
	
	/**
	 * @return
	 */
	public Time_Stamp getCreatedStamp() {
		return this.created;
	}
	
	/**
	 * @return
	 */
	public String getCreatedTime() {
		return this.created.toString();
	}
	
	/**
	 * @return
	 */
	public Time_Stamp getEditedStamp() {
		return this.lastEdited;
	}
	
	/**
	 * @return
	 */
	public String getEditedTime() {
		return this.created.toString();
	}
	/****** UTILITY ******/
	
	/**
	 * @param initials
	 */
	private void stamp(String initials) {
		lastEdited = Time_Stamp.stamp(initials);
	}
	
}