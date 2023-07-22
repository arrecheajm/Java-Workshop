package ac_Digital_Records_Controllers;

import ac_Digital_Records_Models.Animal;
import ac_Digital_Records_Models.Collection;

public class Collection_Controller {	

	/***** ADD ****/
	public static Collection addAnimal(Collection inventory) {		
		boolean repeatChoice = false;
		String initials = null;
		
		do {
			initials = Prompt_Controller.requestInitials();
		}while(!Validation_Controller.areInitialsValid(initials));	
		
		do {
			Animal newAnimal = Animal_Controller.getNewAnimal(initials);
			inventory.addAnimal(newAnimal);
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_ANIMAL_PROMPT);
		}while(repeatChoice);	
		
		return inventory;
		
	}
}
