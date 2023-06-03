package package_model;

import java.io.Serializable;

import utility_classes.MyLinkedList;

/**
 * Class manages a collection of items of type Animal and the necessary methods. This class should be the binary object that gets saved
 * @author jma_u
 *
 */
public class Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4757050862071691151L;
	MyLinkedList<Animal> animals;
	
	public Collection() {
		this.animals = new MyLinkedList<Animal>();
	}
	
	public Collection(MyLinkedList<Animal> animals) {		
		if(animals != null) {
			for (int i=0; i<animals.size(); i++) {
				this.animals.add(animals.get(i));
			}			
		}
	}
	
	public Collection(Animal animal) {
		this.animals = new MyLinkedList<Animal>();
		this.animals.add(animal);		
	}
	
	public MyLinkedList<Animal> getAnimals(){
		return this.animals;
	}
	
	public void addAnimal(Animal animal) {
		this.animals.add((Animal)animal);
	}
}