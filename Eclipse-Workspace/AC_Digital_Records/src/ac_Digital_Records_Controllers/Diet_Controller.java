package ac_Digital_Records_Controllers;

import ac_Digital_Records_Models.Diet;
import ac_Digital_Records_Models.Food_Entry;
import ac_Digital_Records_Models.Food_Group;
import ac_Digital_Records_Models.Food_Item;
import ac_Digital_Records_Models.Invalid_Food_Entry_Name_Exception;
import ac_Digital_Records_Models.Invalid_Number_Of_Options_Exception;
import utility_classes.MyLinkedList;

public class Diet_Controller {

	public static Diet getNewDiet(String initials) {
		Diet newDiet;
		String notes;
		MyLinkedList<Food_Group> foodGroups = null;
		
		notes = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_DIET_NOTE);
		foodGroups = getFoodGroups();
		
		newDiet = new Diet(notes,foodGroups,initials);
		
		return newDiet;
	}

	public static MyLinkedList<Food_Group> getFoodGroups() {
		MyLinkedList<Food_Group> foodGroups = new MyLinkedList<Food_Group>();
		boolean repeatChoice = false;		
		do {
			foodGroups.add(getFoodGroup());
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_FOOD_GROUP_PROMPT);
		}while(repeatChoice);					
		return foodGroups;
	}	

	public static Food_Group getFoodGroup() {		
		Food_Group newFoodGroup = null;
		MyLinkedList<Food_Item> foodItems;		
		String name, notes;
		name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NAME);
		notes = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NOTES);
		foodItems = getFoodItems();	
		newFoodGroup = new Food_Group(name,notes,foodItems);		
		return newFoodGroup;
	}
	
	public static MyLinkedList<Food_Item> getFoodItems() {
		MyLinkedList<Food_Item> foodItems = new MyLinkedList<Food_Item>();
		boolean repeatChoice = false;		
		do {
			foodItems.add(getFoodItem());
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_FOOD_ITEM_PROMPT);
		}while(repeatChoice);					
		return foodItems;
	}

	private static Food_Item getFoodItem() {
		Food_Item newFoodItem = null;
		MyLinkedList<Food_Entry> foodEntries;		
		String name, notes;
		int numberOfAllowedOptions = 0;
		boolean isValid = false;
		
		name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NAME);
		notes = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NOTES);
		numberOfAllowedOptions = Prompt_Controller.requestIntInput(Prompt_Controller.ENTER_FOOD_ITEM_ALLOWED_OPTIONS);
		foodEntries = getFoodEntries();	
		
		do {
			try {
				newFoodItem = new Food_Item(name,notes,numberOfAllowedOptions,foodEntries);
				isValid = true;
			} catch (Invalid_Number_Of_Options_Exception e) {
				Prompt_Controller.showMessage(Prompt_Controller.INVALID_NUMBER_OF_ALLOWED_OPTIONS);
				numberOfAllowedOptions = Prompt_Controller.requestIntInput(Prompt_Controller.ENTER_FOOD_ITEM_ALLOWED_OPTIONS);
				isValid = true;
				e.printStackTrace();
			}
		}while (!isValid);		
		return newFoodItem;
	}

	private static MyLinkedList<Food_Entry> getFoodEntries() {
		MyLinkedList<Food_Entry> newfoodEntries = new MyLinkedList<Food_Entry>();		
		boolean repeatChoice = false;
		
		do {
			newfoodEntries.add(getFoodEntry());
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_FOOD_ENTRY_PROMPT);
		}while (repeatChoice);
		
		return newfoodEntries;
	}

	private static Food_Entry getFoodEntry() {
		Food_Entry newFoodEntry = null;
		String name, frequency;
		boolean isValid = false;
		
		name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_ENTRY_NAME);
		frequency = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FREQUENCY);
		do {
			try {
				newFoodEntry = new Food_Entry(name, frequency);
				isValid = true;
			} catch (Invalid_Food_Entry_Name_Exception e) {
				isValid = false;
				Prompt_Controller.showMessage(Prompt_Controller.INVALID_FOOD_ENTRY_NAME);
				name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_ENTRY_NAME);
				e.printStackTrace();
			}
		}while(!isValid);		
		return newFoodEntry;
	}

}
