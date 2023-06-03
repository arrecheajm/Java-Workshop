package package_controller;

import java.time.LocalDate;

public class Prompt_Controller {
	public static final String ADD_ANOTHER_ANIMAL_PROMPT = "Would you like to add another animal?";
	public static final String REQUEST_DAILY_TASK = "Please enter daily task:";
	public static final String ADD_ANOTHER_DAILY_TASK_PROMPT = "Would you like to add another daily task?";
	public static final String ENTER_INITIALS_PROMPT = "Enter your initials:";
	public static final String REQUEST_NOTE = "Please enter a note:";
	public static final String ADD_ANOTHER_NOTE_PROMPT = "Would you like to add another note?";
	public static final String ENTER_ANIMAL_NAME = "Enter the name of the animal:";
	public static final String ENTER_ANIMAL_NICKNAME = "Enter the nickname of the animal:";
	public static final String ENTER_ANIMAL_SPECIES = "Enter the species of the animal:";
	public static final String ENTER_ANIMAL_SEX = "Enter the sex of the animal:";
	public static final String ENTER_DATE_OF_ACQUISITION = "Enter date of acquisition: ";
	public static final String ENTER_DATE_OF_BIRTH = "Enter date of birth: ";
	public static final String ENTER_YEAR = "Enter year:";
	public static final String ENTER_MOTNH = "Enter month:";
	public static final String ENTER_DAY = "Enter day:";
	public static final String ENTER_DIET_NOTE = "Enter Diet Note:";
	public static final String ENTER_FOOD_GROUP_NAME = "Enter Food Group Name:";
	public static final String ENTER_FOOD_GROUP_NOTES = "Enter Food Group Notes:";
	public static final String ADD_ANOTHER_FOOD_GROUP_PROMPT = "Would you like to add another food group?";
	public static final String ADD_ANOTHER_FOOD_ITEM_PROMPT = "Would you like to add another food item?";
	public static final String ENTER_FOOD_ITEM_ALLOWED_OPTIONS = "Enter number of allowed options";
	
	public static boolean repeatPrompt(String repeatPromptText) {
		boolean choice = Input_Controller.requestBooleanInput(repeatPromptText);
		return choice;
	}

	public static String requestInitials() {
		String input = Input_Controller.requestStringInput(ENTER_INITIALS_PROMPT);		
		return input;
	}

	public static String requestStringInput(String requestStringText) {
		String input = Input_Controller.requestStringInput(requestStringText);		
		return input;
	}
//	TODO: Add request date input method in 
	public static LocalDate requestDateInput(String requestDateText) {
		LocalDate newDate = null;				
		newDate = Input_Controller.requestDate(requestDateText);
		return newDate;
	}

	public static int requestIntInput(String enterFoodItemAllowedOptions) {
		// TODO Auto-generated method stub
		return 0;
	}
}
