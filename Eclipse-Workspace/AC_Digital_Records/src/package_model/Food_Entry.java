package package_model;

import java.io.Serializable;

/**
 * A food entry for a particular food item. Entries have a name (name) and frequency String.
 * Frequency can be one of three names: Normal, low, rare. Also contains boolean to show if it entry
 * is isSelected or not.
 * @author jma_u
 *
 */
public class Food_Entry implements Serializable {
	
	private static final long serialVersionUID = 8741336005180147101L;
	public static final String DEFAULT_FREQUENCY = "Normal";
	public static final String NORMAL_FREQUENCY = "Normal";
	public static final String LOW_FREQUENCY = "Low";
	public static final String RARE_FREQUENCY = "Rare";
	
	private String name;
	private String frequency;
	private boolean isSelected;
	
	/****** CONSTRUCTORS ******/
	
	/**
	 * Creates a new Food_Entry object with given name, default frequency and isSelected set to False.
	 * @param name name to identify the entry.
	 * @throws Invalid_Food_Entry_name_Exception name cannot be null or empty. 
	 */
	public Food_Entry(String name) throws Invalid_Food_Entry_Name_Exception{
		setAll(name, DEFAULT_FREQUENCY, false);
	}
	
	/**
	 * Creates a new Food_Entry object with given name and frequency. Frequency must match one of the preset names.
	 * @param name name to identify the entry.
	 * @param frequency frequency must match one of the preset names or will be set to default.
	 * @throws Invalid_Food_Entry_name_Exception name cannot be null or empty.
	 */
	public Food_Entry(String name, String frequency) throws Invalid_Food_Entry_Name_Exception{
		setAll(name,frequency, false);
	}
	
	/**
	 * Creates a new Food_Entry from a given Food_Entry object
	 * @param otherEntry Food_Entry object to be copied
	 * @throws Invalid_Food_Entry_Name_Exception name cannot be null or empty
	 */
	public Food_Entry(Food_Entry otherEntry) throws Invalid_Food_Entry_Name_Exception {
		setAll(otherEntry.getName(),otherEntry.getFrequency(), otherEntry.getisSelected());
	}
		
	/****** MUTATORS ******/
	
	/**
	 * @param name  name to identify the entry.
	 * @param frequency frequency must match one of the preset names or will be set to default.
	 * @param isSelected flag denoting selection.
	 * @throws Invalid_Food_Entry_name_Exception name cannot be null or empty.
	 */
	public void setAll(String name, String frequency, boolean isSelected) throws Invalid_Food_Entry_Name_Exception {
		setName(name);
		setFrequency(frequency);
		setisSelected(isSelected);
	}

	/**
	 * Sets the name of isSelected.
	 * @param isSelected boolean denoting selection.
	 */
	public void setisSelected(boolean isSelected) {
		this.isSelected = isSelected;		
	}

	/**
	 * Sets the name of frequency.
	 * @param frequency frequency must match one of the preset names or will be set to default.
	 */
	public void setFrequency(String frequency) {
		if (frequency == NORMAL_FREQUENCY) {
			this.frequency = NORMAL_FREQUENCY;
		} else if (frequency == LOW_FREQUENCY) {
			this.frequency = LOW_FREQUENCY;
		} else if (frequency == RARE_FREQUENCY) {
			this.frequency = RARE_FREQUENCY;
		} else {
			this.frequency = DEFAULT_FREQUENCY;
		}		
	}	
	/**
	 * @param name name to identify the entry.
	 * @throws Invalid_Food_Entry_name_Exception name cannot be null or empty.
	 */
	public void setName(String name) throws Invalid_Food_Entry_Name_Exception {
		String temp = name;
		if (temp != null) {
			temp = temp.strip();
			if (temp != "") {
				this.name = name;
			} else {
				throw new Invalid_Food_Entry_Name_Exception("Food Entry name cannot be empty");
			}	
		} else {
			throw new Invalid_Food_Entry_Name_Exception("Food Entry name cannot be NULL");
		}			
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return name variable as a String.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return frequency variable as a String.
	 */
	public String getFrequency() {
		return this.frequency;
	}
	/**
	 * @return isSelected as a boolean
	 */
	public boolean getisSelected() {
		return this.isSelected;
	}
	
	/****** UTILITY ******/
	
	/**
	 *Returns a String containing names for all the Food_Entry Data.
	 */
	public String toString() {
		return "Entry name: "+this.name+" Frequency: "+this.frequency+" isSelected? "+this.isSelected;
	}
}
