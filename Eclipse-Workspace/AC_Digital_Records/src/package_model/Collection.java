package package_model;

import utility_classes.MyLinkedList;

/**
 * Class manages a collection of items of type Animal and the necessary methods. This class should be the binary object that gets saved
 * @author jma_u
 *
 */
public class Collection {
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
}