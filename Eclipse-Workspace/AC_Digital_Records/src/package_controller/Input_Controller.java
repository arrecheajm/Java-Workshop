package package_controller;

import java.time.LocalDate;
import java.util.Scanner;

import utility_classes.Utility;

public class Input_Controller {
	private static boolean printToCommanLine = true; 	// controller prints to command line
	private static boolean useViewController = false; 	// TRUE: controller uses Veiw_Controller to prompt and returns data from Veiw_Controller only 
												// FALSE: controller does not Veiw_Controller, returns data from console input instead 
	private static Scanner keyboard = null;
	
	/**
	 * 
	 */
	private static void initKeyboardScanner() {
		keyboard = new Scanner(System.in);
	}	
	
	/**
	 * @param requestStringInputText
	 * @return
	 */
	public static String requestStringInput(String requestStringInputText) {
		String input = null;		
		if (printToCommanLine && useViewController) {
			System.out.println(requestStringInputText);
		}		
		if (useViewController) {
			//TODO add view controller access
		} else {
			if (keyboard == null) {
				initKeyboardScanner();
			}
			input = Utility.readWord(requestStringInputText, keyboard);
		}		
		return input;
	}
	
	/**
	 * @param requestBooleanInputText
	 * @return
	 */
	public static boolean requestBooleanInput(String requestBooleanInputText) {
		boolean input = false;
		if (printToCommanLine && useViewController) {
			System.out.println(requestBooleanInputText);
		}		
		if (useViewController) {
			//TODO add view controller access
		} else {
			if (keyboard == null) {
				initKeyboardScanner();
			}
			input = Utility.continuePrompt(requestBooleanInputText, keyboard);
		}	
		return input;
	}
	
	public static int requestIntInput(String requestIntText) {
		int input = 0;
		if (printToCommanLine && useViewController) {
			System.out.println(requestIntText);
		}		
		if (useViewController) {
			//TODO add view controller access
		} else {
			if (keyboard == null) {
				initKeyboardScanner();
			}
			input = Utility.readInt(requestIntText, keyboard, 0, 9999);
		}	
		return input;
	}
	// TODO handle request message on date input request
	public static LocalDate requestDate(String requestDateText) {
		LocalDate newDate = null;
		int year, month,dayOfMonth;
		year = requestIntInput(Prompt_Controller.ENTER_YEAR);
		month = requestIntInput(Prompt_Controller.ENTER_MOTNH);
		dayOfMonth = requestIntInput(Prompt_Controller.ENTER_DAY);
		newDate = LocalDate.of(year, month, dayOfMonth);
		return newDate;
	}
}
