package package_model;

import utility_classes.MyLinkedList;

/**
 * Class contains a collection of Food Items that make up a food group.
 * @author jma_u
 *
 */
public class Food_Group {
	private String name;
	private String notes;
	private MyLinkedList<Food_Item> foodItems;
	
	/****** CONSTRUCTORS ******/
	/**
	 * 
	 */
	public Food_Group() {
		setAll(null,null,null);
	}
	
	/**
	 * @param name
	 * @param notes
	 * @param foodItems
	 */
	public Food_Group(String name, String notes, MyLinkedList<Food_Item> foodItems) {
		setAll(name, notes, foodItems);
	}
	
	/****** MUTATORS ******/
	
	/**
	 * @param name
	 * @param notes
	 * @param foodItems
	 */
	public void setAll(String name, String notes, MyLinkedList<Food_Item> foodItems) {
		setName(name);
		setNotes(notes);
		setFoodItems(foodItems);
	}
	
 	/**
 	 * @param foodItems
 	 */
	public void setFoodItems(MyLinkedList<Food_Item> foodItems) {
		this.foodItems = new MyLinkedList<Food_Item>();
		if (foodItems != null) {			
			for (int i=0; i<foodItems.size(); i++) {
				this.foodItems.add(foodItems.get(i));
			}
		} 
	}
 	
	/**
	 * @param notes
	 */
 	public void setNotes(String notes) {
		if (notes != null) {
			this.notes = notes;
		}
		
	}
	
	/**
	 * @param name
	 */
 	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}		
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return
	 */
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * @return
	 */
	public MyLinkedList<Food_Item> getFoodItems() {
		return this.foodItems;
	}
	
	/****** UTILITY ******/
	
}
