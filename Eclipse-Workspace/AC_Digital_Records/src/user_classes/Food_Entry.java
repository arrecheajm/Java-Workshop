package user_classes;

/**
 * A food entry for a particular food item. Entries are color coded based on how often they can be administered
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
	
	/**
	 * @param value
	 */
	Food_Entry(String value){
		
	}
	
	/**
	 * @param value
	 * @param frequency
	 * @throws Invalid_Food_Entry_Value_Exception 
	 */
	public void setAll(String value, String frequency) throws Invalid_Food_Entry_Value_Exception {
		setValue(value);
		setFrequency(frequency);
	}

	/**
	 * @param frequency
	 */
	private void setFrequency(String frequency) {
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
	 * @param value
	 * @throws Invalid_Food_Entry_Value_Exception
	 */
	private void setValue(String value) throws Invalid_Food_Entry_Value_Exception {
		String temp = value.strip();
		
		if (temp != null && temp != "") {
			this.value = value;
		} else {
			throw new Invalid_Food_Entry_Value_Exception("Food Entry value cannot be NULL or \"\" ");
		}
		
	}
}
