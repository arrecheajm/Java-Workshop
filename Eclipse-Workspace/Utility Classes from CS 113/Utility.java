
// TITLE:		Utility Class
// PROGRAM DESCRIPTION:	Contains various useful methods for Java course

import java.util.Scanner;

public class Utility
{
	// CONSTANTS
	public static final String NAME = "JUAN ARRECHEA";
	public static final String COURSE = "Basic Data Structures and Algorithms";
	public static final String SECTION = "Mon/Wed 11:00am - 1:00pm";

	// DESCRIPTION:		Print author information for start of program
	// PRE-CONDITIONS:	All parameters are given valid values
	// POST-CONDITIONS:	Outputs author info to console
	public static void printHeader(int homework, int project, String lastModified)
	{
		//output
		System.out.println("/*****************************************************");
		System.out.println("* AUTHOR:        " + NAME);
		System.out.println("* COURSE:        " + COURSE);
		System.out.println("* SECTION:       " + SECTION);
		System.out.println("* HOMEWORK #:    " + homework);
		System.out.println("* PROJECT #:	 " + project);
		System.out.println("* LAST MODIFIED: " + lastModified);
		System.out.println("*****************************************************/");
	}

	// DESCRIPTION:		reads input from user, returns integer value (error-checked using bounds)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: ", lower < upper
	// POSTCONDITIONS:	returns integer value between lower and upper (inclusive)
	public static int readInt(String prompt, Scanner key, int lower, int upper)
	{
		String temp;
		int result = -1;
		boolean isNotValid = true;

		do
		{
			try{
				System.out.print(prompt);
				temp = key.nextLine();
				result = Integer.parseInt(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(isNotValid)
				{
					System.out.println("ERROR: please enter a value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException nf){
				System.out.println("ERROR: please enter a value between " + lower + " - " + upper);
			}
			
		} while(isNotValid);

		return result;
	}

	// DESCRIPTION:		reads input from user, returns double value (error-checked using bounds)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: ", lower < upper
	// POSTCONDITIONS:	returns double value between lower and upper (inclusive)
	public static double readDouble(String prompt, Scanner key, double lower, double upper)
	{
		String temp;
		double result;
		boolean isNotValid;

		do
		{
			System.out.print(prompt);
			temp = key.nextLine();
			result = Double.parseDouble(temp);
			isNotValid = (result < lower) || (result > upper);
			
			if(isNotValid)
			{
				System.out.println("ERROR: please enter value between " + lower + " - " + upper);
			}
		} while(isNotValid);

		return result;
	}

	// DESCRIPTION:		reads input from user, returns char value (only allowed chars are contained in validChars)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: "
	// POSTCONDITIONS:	returns valid char value (must be within validChars)
	public static char readChar(String prompt, Scanner key, String validChars)
	{
		String temp;
		char result;
		boolean isNotValid;

		do
		{
			System.out.print(prompt);
			temp = key.nextLine();
			result = temp.charAt(0);
			isNotValid = validChars.indexOf(result) == -1;
			
			if(isNotValid)
			{
				System.out.println("ERROR: please enter one of the following valid chars: " + validChars);
			}
		} while(isNotValid);

		return result;
	}

	//ARRAY METHODS (feel free to document rest of methods as they are
	//documented above as an exercise to practice the way we document in this course!)
	/**
	 * @param original
	 */
	public static void printArray(double[] original)
	{
        for(int i = 0; i < original.length; i++)
        {
            System.out.printf("#%2d = %f%n", (i+1), original[i]);
        }
	}
    /**
     * @param original
     * @param val
     */
    public static void initializeArray(double[] original, double val)
    {
        for(int i = 0; i < original.length; i++)
        {
            original[i] = val;
        }
    }

    /**
     * @param original
     * @return
     */
    public static double[] copyArray(double[] original)
    {
        double[] copy;
        copy = new double[original.length];

        for(int i = 0; i < copy.length; i++)
        {
            copy[i] = original[i];
        }

        return copy;
    }

	/**
	 * @param original
	 */
	public static void printArray(int[] original)
	{
        for(int i = 0; i < original.length; i++)
        {
            System.out.printf("#%2d = %d%n", (i+1), original[i]);
        }
	}
	
    /**
     * @param original
     * @param val
     */
    public static void initializeArray(int[] original, int val)
    {
        for(int i = 0; i < original.length; i++)
        {
            original[i] = val;
        }
    }
	
    /**
     * @param original
     * @return
     */
    public static int[] copyArray(int[] original)
    {
        int[] copy;
        copy = new int[original.length];

        for(int i = 0; i < copy.length; i++)
        {
            copy[i] = original[i];
        }

        return copy;
    }

	/**
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean arraysAreEqual(double[] first, double[] second)
	{
		int i;
		boolean result;
		result = true;
		
		if(first.length != second.length)
		{
			result  = false;
		}
		else
		{
			i = 0;
			while(i < first.length && result) //can also use second.length, doesnt matter
			{
				if(first[i] != second[i])
				{
					result = false;
				}
				
				i++;
			}
		}
		return result;
	}
	
	/**
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean arraysAreEqual(int[] first, int[] second)
	{
		int i;
		boolean result;
		result = true;
		
		if(first.length != second.length)
		{
			result  = false;
		}
		else
		{
			i = 0;
			while(i < first.length && result) //can also use second.length, doesnt matter
			{
				if(first[i] != second[i])
				{
					result = false;
				}
				
				i++;
			}
		}
		return result;
	}
	/**
	 * Method for reading a single word from the user using Scanner (add to Utility)
	 * @param prompt Must pass the prompt to be displayed to user
	 * @param keyboard open keyboard from calling class
	 * @return the string entered by the user
	 */
	public static String readWord(String prompt, Scanner keyboard){
		System.out.print(prompt);
		String temp = keyboard.nextLine();
		temp.trim();
		return temp;
	}
	
	/**
	 * Method for prompting the console a "yes" or "no" question (add to utility)
	 * @param prompt yes or no question print to console
	 * @param keyboard calling class must have a scanner object instaciated
	 * @return true for "yes" and false for "no'
	 */
	public static boolean continuePrompt(String prompt, Scanner keyboard){
		boolean isNotValid = true;
		String temp;		
		do {
			System.out.print(prompt);
			temp = keyboard.nextLine();
			temp.trim();
			if (temp.equalsIgnoreCase("yes")){
				return true;
			}
			else if (temp.equalsIgnoreCase("no")){
				return false;
			}
			else {
				System.out.println("Please answer yes/no");
			}
		}while (isNotValid);
		return false;
	}
	/**
	 * 
	 */
	public static void clearConsole(){
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
