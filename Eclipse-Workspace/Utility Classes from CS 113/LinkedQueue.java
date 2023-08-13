

import java.util.NoSuchElementException;

/**
 * Queue Class using a doubly linked list as the data type
 * @author Juan Arrechea <juanarrechea90@gmail.com>
 * @version 1.0;
 * 
 * @param <T>
 */
public class LinkedQueue<T> {
	private MyLinkedList<T> data;
	/**
	 * Default constructor
	 * 
	 */
	public LinkedQueue(){
		data = new MyLinkedList<T>();
	}
	
	/**
	 * Adds new item to the queue
	 * @param newData must be of type T
	 * @return always returns true when using a linked list
	 */
	public boolean offer(T newData){
		data.addLast(newData);
		return true;
	}
	/**
	 * Removes the top of the queue, throws NoSuchElementException if queue is empty
	 * @return data from removed object
	 */
	public T remove(){
		if (data.isEmpty()){
			throw new NoSuchElementException();
		}
		return data.removeFirst();		
	}
	/**
	 * Removes the top of the queue, returns null if queue is empty
	 * @return data from removed object
	 */
	public T poll(){
		if (data.isEmpty()){
			return null;
		}
		return data.removeFirst();		
	}
	/**
	 * Returns the data from the first item in the queue without removing it,
	 * returns null if queue is empty
	 * @return data from top object in stack 
	 */
	public T peek(){ 
		if (data.isEmpty()){
			return null;
		}
		return (T) data.get(0);		
	}
	/**
	 * Returns the data from the first item in the queue without removing it,
	 * throws NoSuchElementException is queue is empty
	 * @return data from top object in stack
	 */
	public T element(){
		if (data.isEmpty()){
			throw new NoSuchElementException();
		}
		return (T) data.get(0);		
	}
	/**
	 * returns the size of the stack
	 * @return interger size of stack
	 */
	public int size(){
		return data.size();
	}
	/**
	 * Checks for empty queue
	 * @return true is queue is empty
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}
}
