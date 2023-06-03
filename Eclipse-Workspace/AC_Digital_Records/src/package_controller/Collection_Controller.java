package package_controller;

import package_model.Animal;
import package_model.Collection;

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
