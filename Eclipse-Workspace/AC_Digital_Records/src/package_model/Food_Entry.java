package package_model;

/**
 * A food entry for a particular food item. Entries have a value (name) and frequency String.
 * Frequency can be one of three values: Normal, low, rare. Also contains boolean to show if it entry
 * is isSelected or not.
 * @author jma_u
 *
 */
public class Food_Entry {
	public static final String DEFAULT_FREQUENCY = "Normal";
	public static final String NORMAL_FREQUENCY = "Normal";
	public static final String LOW_FREQUENCY = "Low";
	public static final String RARE_FREQUENCY = "Rare";
	
	private String value;
	private String frequency;
	private boolean isSelected;
	
	/****** CONSTRUCTORS ******/
	/**
	 * Creates a new Food_Entry object with given value, default frequency and isSelected set to False.
	 * @param value value to identify the entry.
	 * @throws Invalid_Food_Entry_Value_Exception value cannot be null or empty. 
	 */
	Food_Entry(String value) throws Invalid_Food_Entry_Value_Exception{
		setAll(value, DEFAULT_FREQUENCY, false);
	}
	
	/**
	 * Creates a new Food_Entry object with given value and frequency. Frequency must match one of the preset values.
	 * @param value value to identify the entry.
	 * @param frequency frequency must match one of the preset values or will be set to default.
	 * @throws Invalid_Food_Entry_Value_Exception value cannot be null or empty.
	 */
	Food_Entry(String value, String frequency) throws Invalid_Food_Entry_Value_Exception{
		setAll(value,frequency, false);
	}
		
	/****** MUTATORS ******/
	/**
	 * @param value  value to identify the entry.
	 * @param frequency frequency must match one of the preset values or will be set to default.
	 * @param isSelected flag denoting selection.
	 * @throws Invalid_Food_Entry_Value_Exception value cannot be null or empty.
	 */
	public void setAll(String value, String frequency, boolean isSelected) throws Invalid_Food_Entry_Value_Exception {
		setValue(value);
		setFrequency(frequency);
		setisSelected(isSelected);
	}

	/**
	 * Sets the value of isSelected.
	 * @param isSelected boolean denoting selection.
	 */
	public void setisSelected(boolean isSelected) {
		this.isSelected = isSelected;		
	}

	/**
	 * Sets the value of frequency.
	 * @param frequency frequency must match one of the preset values or will be set to default.
	 */
	public void setFrequency(String frequency) {
		if (frequency == "Normal") {
			this.frequency = NORMAL_FREQUENCY;
		} else if (frequency == "Low") {
			this.frequency = LOW_FREQUENCY;
		} else if (frequency == "Rare") {
			this.frequency = RARE_FREQUENCY;
		} else {
			this.frequency = DEFAULT_FREQUENCY;
		}		
	}	
	/**
	 * @param value value to identify the entry.
	 * @throws Invalid_Food_Entry_Value_Exception value cannot be null or empty.
	 */
	public void setValue(String value) throws Invalid_Food_Entry_Value_Exception {
		String temp = value.strip();
		
		if (temp != null && temp != "") {
			this.value = value;
		} else {
			throw new Invalid_Food_Entry_Value_Exception("Food Entry value cannot be NULL or empty");
		}		
	}
	
	/****** ACCESSORS ******/
	/**
	 * @return value variable as a String.
	 */
	public String getValue() {
		return this.value;
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
	 *Returns a String containing values for all the Food_Entry Data.
	 */
	public String toString() {
		return "Entry value: "+this.value+" Frequency: "+this.frequency+" isisSelected? "+this.isSelected+"\n";
	}
}
