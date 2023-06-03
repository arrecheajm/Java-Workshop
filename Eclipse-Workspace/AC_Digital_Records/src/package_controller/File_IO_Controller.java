package package_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

import package_model.Collection;

/**
 * @author jma_u
 *
 */
public class File_IO_Controller {
	
	/**
	 * @param fileName
	 * @return
	 */
	public static Collection openCollectionFromBinaryFile(String fileName) {
		ObjectInputStream inputStream = null;
		Collection dbCollection = null;
		try {
			inputStream = new ObjectInputStream (new FileInputStream(fileName+".dat"));
			dbCollection = (Collection)inputStream.readObject();
			System.out.println("Done reading from: "+fileName);
			inputStream.close();
		}
		catch (ClassNotFoundException e) {
			System.out.println("ERROR: cannot read object from "+fileName+".dat");
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: cannot find file");
		}
		catch (IOException e) {
			System.out.println("ERROR: problem with file input from"+fileName+".dat");
		}
		return dbCollection;
	}
	
	/**
	 * @param fileName
	 * @param dbCollection
	 */
	public static void saveCollectionToBinaryFile(String fileName, Collection dbCollection) {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream 
								(new FileOutputStream(fileName+".dat"));
			outputStream.writeObject(dbCollection);
			System.out.println("Calendar "+fileName+" saved");
			outputStream.close();
		}
		catch (IOException e) {
			System.out.println("ERROR: Data not saved");
		}
	}


	public static String openCollectionFromTextFile(String fileName) {
		Scanner inputStream;
		String textFile = "";
		inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: File "+fileName+" could not be opened");
		}
		while (inputStream.hasNextLine()) {
			textFile += inputStream.nextLine()+"\n\n";  //TODO select format for reading
		}
		return textFile;		
	}
	
	public static void saveCollectionToTextFile(String fileName, Collection dbCollection) {
		//TODO
	}
	
//	public static void createLocalCopy(String fileName, String source) {
//		Files.copy(source, null)
//	}
}
