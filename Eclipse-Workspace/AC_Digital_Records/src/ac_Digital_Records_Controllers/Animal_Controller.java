package ac_Digital_Records_Controllers;

import java.time.LocalDate;

import ac_Digital_Records_Models.Animal;
import ac_Digital_Records_Models.Animal_Data;
import ac_Digital_Records_Models.Diet;
import ac_Digital_Records_Models.Diet_Week;
import utility_classes.MyLinkedList;

public class Animal_Controller {

	/**
	 * @param initials
	 * @return
	 */
	public static Animal getNewAnimal(String initials) {
		String verifiedInitials;
		if (initials == null) {
			verifiedInitials = Prompt_Controller.requestInitials();
		} else {
			verifiedInitials = initials;
		}		
		Animal_Data info = Animal_Controller.getNewAnimalInfo(verifiedInitials);
		Diet diet = Animal_Controller.getNewAnimalDiet(verifiedInitials);
//		MyLinkedList<Diet_Week> dietLog = Animal_Controller.getNewAnimalLog(initials);
		MyLinkedList<Diet_Week> dietLog = null;
		MyLinkedList<String> notes = Animal_Controller.getNewAnimalNotes(verifiedInitials);
		MyLinkedList<String> dailyTasks = Animal_Controller.getNewAnimalDailyTasks(verifiedInitials);
		Animal newAnimal = new Animal(info, diet, dietLog, notes, dailyTasks, verifiedInitials);
		return newAnimal;
	}

	/**
	 * @param initials
	 * @return
	 */
	private static MyLinkedList<String> getNewAnimalDailyTasks(String initials) {
		boolean repeatChoice = false;		
		MyLinkedList<String> dailyTasks = new MyLinkedList<String>();
		String task = "";
		do {
			task = Prompt_Controller.requestStringInput(Prompt_Controller.REQUEST_DAILY_TASK);
			dailyTasks.add(task);
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_DAILY_TASK_PROMPT);
		}while(repeatChoice);		
		return dailyTasks;
	}

	/**
	 * @param initials
	 * @return
	 */
	private static MyLinkedList<String> getNewAnimalNotes(String initials) {
		boolean repeatChoice = false;		
		MyLinkedList<String> notes = new MyLinkedList<String>();
		String task = "";
		do {
			task = Prompt_Controller.requestStringInput(Prompt_Controller.REQUEST_NOTE);
			notes.add(task);
			repeatChoice = Prompt_Controller.repeatPrompt(Prompt_Controller.ADD_ANOTHER_NOTE_PROMPT);
		}while(repeatChoice);		
		return notes;
	}

//	private static MyLinkedList<Diet_Week> getNewAnimalLog(String initials) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * @param initials
	 * @return
	 */
	public static Diet getNewAnimalDiet(String initials) {
		Diet newDiet = Diet_Controller.getNewDiet(initials);		
		return newDiet;
	}
	/**
	 * @param initials
	 * @return
	 */
	public static Animal_Data getNewAnimalInfo(String initials) {
		String name, nickname, species, sex;
		LocalDate dOB, dOA;
		Animal_Data newAnimalData = null;
		
		name = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_ANIMAL_NAME);
		nickname = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_ANIMAL_NICKNAME);
		species = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_ANIMAL_SPECIES);
		sex = Prompt_Controller.requestStringInput(Prompt_Controller.ENTER_ANIMAL_SEX);
		dOB = Prompt_Controller.requestDateInput(Prompt_Controller.ENTER_DATE_OF_BIRTH);
		dOA = Prompt_Controller.requestDateInput(Prompt_Controller.ENTER_DATE_OF_ACQUISITION);
		
		newAnimalData = new Animal_Data(name,nickname,species,sex, dOB, dOA, initials);
		
		return newAnimalData;
	}

}
