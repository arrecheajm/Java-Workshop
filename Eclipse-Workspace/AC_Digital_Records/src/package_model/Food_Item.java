package package_model;

import java.io.Serializable;

import utility_classes.MyLinkedList;

/**
 * An item of food that is part of a diet. The food item contains the possible options for given item and stores the selected options from the available list
 * @author jma_u
 *
 */
public class Food_Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2254919578924255313L;
	private int numberOfAllowedOptions;
	private String name;
	private String notes;
	private MyLinkedList<Food_Entry> options;
	
	/****** CONSTRUCTORS ******/
	
	
	/**
	 * @param options
	 * @throws Invalid_Number_Of_Options_Exception
	 */
	public Food_Item(MyLinkedList<Food_Entry> options) throws Invalid_Number_Of_Options_Exception{
		if (options == null) {
			throw new Invalid_Number_Of_Options_Exception("Null list passed to constructor");
		}
		setAll(null, null, options.size(), options);
	}
	
	/**
	 * @param options
	 * @throws Invalid_Number_Of_Options_Exception
	 * @throws Invalid_Food_Entry_Name_Exception
	 */
	public Food_Item(String name, String notes, String[] options) throws Invalid_Number_Of_Options_Exception, Invalid_Food_Entry_Name_Exception{
		if (options == null) {
			throw new Invalid_Number_Of_Options_Exception("Null list passed to constructor");
		}
		setAll(name, notes, options.length, createOptionList(options));
	}
	
	/**
	 * @param name
	 * @param notes
	 * @param numberOfAllowedOptions
	 * @param options
	 * @throws Invalid_Number_Of_Options_Exception
	 */
	public Food_Item(String name,String notes,int numberOfAllowedOptions, MyLinkedList<Food_Entry> options) throws Invalid_Number_Of_Options_Exception {
		setAll(name, notes, numberOfAllowedOptions, options);
	}
	
	/**
	 * @param otherItem
	 * @throws Invalid_Number_Of_Options_Exception
	 */
	public Food_Item(Food_Item otherItem) throws Invalid_Number_Of_Options_Exception {
		setAll(otherItem.getName(), otherItem.getNotes(), otherItem.getNumberOfAllowedOptions(), otherItem.getOptions());
	}
	
	/****** MUTATORS ******/
	
	/**
	 * @param name
	 * @param notes
	 * @param numberOfAllowedOptions
	 * @param options
	 * @throws Invalid_Number_Of_Options_Exception
	 */
	public void setAll(String name,String notes,int numberOfAllowedOptions, MyLinkedList<Food_Entry> options) throws Invalid_Number_Of_Options_Exception {
		setName(name);
		setNotes(notes);
		setnumberOfAllowedOptions(numberOfAllowedOptions);
		setOptions(options);
	}
	/**
	 * @param options
	 */
	private void setOptions(MyLinkedList<Food_Entry> options) {  // TODO how to validate options?
													// TODO method to create list from string of values
		this.options = new MyLinkedList<Food_Entry>();
		if (options != null) {			
			for (int i=0; i<options.size(); i++) {
				options.add(options.get(i));
			}
		}
		
	}
	/**
	 * @param numberOfAllowedOptions
	 * @throws Invalid_Number_Of_Options_Exception 
	 */
	private void setnumberOfAllowedOptions(int numberOfAllowedOptions) throws Invalid_Number_Of_Options_Exception {
		if (numberOfAllowedOptions > 0) {
			if (options != null && numberOfAllowedOptions < options.size()) {
				this.numberOfAllowedOptions = numberOfAllowedOptions;
			} else {
				throw new Invalid_Number_Of_Options_Exception("Number of options must be less than the number of options");
			}
		} else {
			throw new Invalid_Number_Of_Options_Exception("Number of options must be greater than zero");
		}
		
	}
	/**
	 * @param notes
	 */
	public void setNotes(String notes) {
		if(notes != null) {
			this.notes = notes;
		}
		
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
		
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return
	 */
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * @return
	 */
	public int getNumberOfAllowedOptions() {
		return this.numberOfAllowedOptions;
	}
	
	/**
	 * @return
	 */
	public MyLinkedList<Food_Entry> getOptions() {
		return this.options;
	}
	
	/**
	 * Returns a string containing all the options names in a comma separated list.
	 * @return
	 */
	public String getOptionsAsString() {
		String optionsString = "";
		for (int i=0; i<options.size(); i++) {
			optionsString = optionsString + ", " + ((Food_Entry)options.get(i)).toString();
		}
		return optionsString;
	}
 	/****** UTILITY  ******/		

	public MyLinkedList<Food_Entry> createOptionList(String[] options) throws Invalid_Food_Entry_Name_Exception {
		int numberOfOptions = options.length;
		MyLinkedList<Food_Entry> temp = new MyLinkedList<Food_Entry>();
		if (options != null) {
			for (int i=0; i<numberOfOptions; i++) {
				temp.add(new Food_Entry(options[i]));				
			}
		}
		return temp;		
	}
}
