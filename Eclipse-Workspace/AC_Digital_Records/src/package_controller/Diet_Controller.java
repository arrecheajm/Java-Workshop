package package_controller;

import package_model.Diet;
import package_model.Food_Entry;
import package_model.Food_Group;
import package_model.Food_Item;
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
		name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NAME);
		notes = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_FOOD_GROUP_NOTES);
		numberOfAllowedOptions = Prompt_Controller.requestIntInput(Prompt_Controller.ENTER_FOOD_ITEM_ALLOWED_OPTIONS);
		foodEntries = getFoodEntries();	
		newFoodItem = new Food_Item(name,notes,numberOfAllowedOptions,foodEntries);
		return newFoodItem;
	}

	private static MyLinkedList<Food_Entry> getFoodEntries() {
		// TODO Auto-generated method stub
		return null;
	}

}
