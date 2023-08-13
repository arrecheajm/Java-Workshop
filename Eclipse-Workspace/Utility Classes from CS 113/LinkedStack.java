
import java.util.EmptyStackException;

/**
 * LinkedStack Class: Stack Class implemented using a LinkedList as the data type
 * @author Juan Arrechea <juanarrechea90@gmail.com>
 *
 * @param <T>
 */
public class LinkedStack<T> {
	private int top;
	private MyLinkedList<T> data;
	
	/**
	 * LinkedStack Constructor
	 * 
	 */
	public LinkedStack(){
		data = new MyLinkedList<T>();
		top = -1;
	}
	/**
	 * Checks if Stack is empty
	 * @return true if Stack.top equals -1
	 */
	public boolean empty(){
		return (top == -1);
	}
	/**
	 * Returns the top value of a stack without removing it
	 * @return data from the top of value of the stack
	 */
	public T peek() {
		if (top == -1){
			throw new EmptyStackException();
		}
		return (T) data.get(top);
	}
	/**
	 *Removes the first item on a stack and returns it's data
	 * @return data from top removed value
	 */
	public T pop(){
		if (top == -1){
			throw new EmptyStackException();
		}
		top--;
		return data.removeLast();
	}
	/**
	 * Adds an item to the top of a stack
	 * @param data to be added at the top of the stack
	 * @return data passed to the method
	 */
	public T push(T data){
		this.data.add(data);
		top++;
		return data;
	}
}
