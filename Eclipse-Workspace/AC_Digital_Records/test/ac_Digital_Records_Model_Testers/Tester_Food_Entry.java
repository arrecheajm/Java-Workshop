package ac_Digital_Records_Model_Testers;

import ac_Digital_Records_Models.Food_Entry;
import ac_Digital_Records_Models.Invalid_Food_Entry_Name_Exception;

public class Tester_Food_Entry {
	public static void main (String[] args) {
		/****** CONSTRUCTORS ******/
		Food_Entry t1= null;
		Food_Entry t2 = null;
		
		try {
			t1 = new Food_Entry("");
		} catch (Invalid_Food_Entry_Name_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t1 = new Food_Entry("t1");
		} catch (Invalid_Food_Entry_Name_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t2 = new Food_Entry("t2", "Rare");
		} catch (Invalid_Food_Entry_Name_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/****** MUTATORS ******/
		
		
		/****** ACCESSORS ******/
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
		/****** UTILITY ******/
	}

}
