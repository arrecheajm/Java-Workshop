package package_controller;

import java.util.Scanner;

import package_model.*;
import utility_classes.MyLinkedList;
import utility_classes.Utility;


// TODO make static
// TODO rework class using other controllers, remove extra packages

public class Command_Line_Controller {
	
	public static final String STORAGE_FILENAME = "Collection.dat";
	
	public static final String INITIALIZE_PROMPT = "Enter a number to continue: ";
	public static final int INITIALIZE_LOW_VAL = 1;
	public static final int INITIALIZE_UPPER_VAL = 3;
	
	
	Collection dbCollection;
	Scanner keyboard;
	
	public Command_Line_Controller() {
		initialize();
	}
	
	private void initialize() {
		keyboard = new Scanner(System.in);
		
		initPrompt();
		int choice = Utility.readInt(INITIALIZE_PROMPT, keyboard, INITIALIZE_LOW_VAL, INITIALIZE_UPPER_VAL);
		switch (choice){
		case 1:
			dbCollection = File_IO_Controller.openCollectionFromBinaryFile(STORAGE_FILENAME);
		case 2:
			dbCollection = new Collection();
		default:
			createTestCollection();
		}
	}

	private void initPrompt() {
		System.out.println("Select an option to start: ");
		System.out.println("1) Read Collection from file");
		System.out.println("2) Create New Collection");
		System.out.println("3) Use Test Collection");
	}
	
	private void createTestCollection() {
		
		// Initials
		String initials = "Test";		
		
		/***** Nikita *****/
		
		/* Animal Data */
		
		String name = "Nikita";
		String nickName = "Kita";
		String species = "Gray Fox";
		String sex = "Female";		
		Animal_Data nikitaInfo = new Animal_Data(name, nickName, species, sex, initials);
		
		/* Diet Data */
		
		String dietNotes = null;
		
		// Produce
		String produceVegName = "VEGGIES";
		String produceVegNotes = "";
		String[] produceVeggiesEntries= {"carrots","corn","sweet potato","snap peas","yellow squash"};
		
		String produceFruitsName = "FRUITS";
		String produceFruitsNotes = "";
		String[] produceFruitsEntries = {"apple", "blackberry", "blueberry", "rasberry", "plum", "strawberry", "pear", "peach", "cherry",};
				
		MyLinkedList<Food_Item> kitasProduceFoodItems = new MyLinkedList<Food_Item>();
		try {
			kitasProduceFoodItems.add(new Food_Item(produceVegName,produceVegNotes,produceVeggiesEntries));
			kitasProduceFoodItems.add(new Food_Item(produceFruitsName,produceFruitsNotes,produceFruitsEntries));
		} catch (Invalid_Number_Of_Options_Exception | Invalid_Food_Entry_Name_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// Food Group
		MyLinkedList<Food_Group> nikitasFoodGroup = new MyLinkedList<Food_Group>();
		
		
		nikitasFoodGroup.add(new Food_Group("Produce", "CHOOSE 2 DIFFERNT ITEMS(1 vegetable  1 fuit) -- 1/2 cup tota:",kitasProduceFoodItems));
		
		Diet nikitaDiet = new Diet(dietNotes, nikitasFoodGroup, initials);
		
		// Animal
		Animal nikita = new Animal(nikitaInfo, null, null, null, null, null);
				
		// Collection
		dbCollection = new Collection(nikita);		
		
	}
}
