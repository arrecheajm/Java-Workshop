package vet_office;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * LinkedList class implementing List Interface
 * @author Juan Arrechea <juanarrechea90@gmail.com>
 * @version 1.0;
 *
 * @param <T>
 */
public class MyLinkedList<T> implements List {
	/***** START OF NODE CLASS *****/
	/**
	 * Node class for creating nodes on MyLinkedList
	 * @author Juan Arrechea <juanarrechea90@gmail.com>
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		Node<T> next = null;
		Node<T> prev = null;
		T data;
		
		/**
		 * Node constructor
		 * @param data
		 */
		private Node(T data){
			this.data = data;			
		}
	}
	/***** END OF NODE CLASS *****/
	/***** START OF ITERATOR CLASS *****/
	/**
	 * Iterator class for MyLinkedList
	 * @author Node class for creating nodes on MyLinkedList
	 *
	 * @param <T>
	 */
	private class MyIterator<T> implements ListIterator<T>{
		private Node<T> nextItem;
		private Node<T> lastItemReturned;
		private int index = 0;

		/**
		 * Creates a new MyIterator at index i
		 * @param i must be an index greater than 0 and less than size
		 */
		public MyIterator(int i){
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index: "+i);
			}
			lastItemReturned = null;
			if (i == size) {
				index = size;
				nextItem = null;
			} else {
				nextItem = (Node<T>) head;
				for (index = 0; index < i; index++){
					nextItem = nextItem.next;
				}
			}
		}
		
		/* (non-Javadoc)
		 * @see java.util.ListIterator#add(java.lang.Object)
		 */
		@Override
		public void add(T data) {
			if (head == null){
				head = new Node(data);
				tail = head;
			}
			else if (nextItem == head){
				Node newNode = new Node<T>(data);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			}
			else if (nextItem == null){
				Node newNode = new Node<T>(data);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			else {
				Node newNode = new Node<T>(data);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			size++;
			index++;
			
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return nextItem != null;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#hasPrevious()
		 */
		@Override
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.prev !=null;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#next()
		 */
		@Override
		public T next() {
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#nextIndex()
		 */
		@Override
		public int nextIndex() {
			return index+1;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previous()
		 */
		@Override
		public T previous() {
			if (!hasPrevious()){
				throw new NoSuchElementException();
			}
			if (nextItem == null) {
				nextItem = (Node<T>) tail;
			}
			else {
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#previousIndex()
		 */
		@Override
		public int previousIndex() {
			return index-1;
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#remove()
		 */
		@Override
		public void remove() {
			if(lastItemReturned==null){
        		throw new IllegalStateException();
			}
        	lastItemReturned.next.prev=lastItemReturned.prev;
        	lastItemReturned.prev.next=lastItemReturned.next;
        	lastItemReturned=null;
			
		}

		/* (non-Javadoc)
		 * @see java.util.ListIterator#set(java.lang.Object)
		 */
		@Override
		public void set(T data) {
			if(lastItemReturned==null){
        		throw new IllegalStateException();
			}
        	lastItemReturned.data=data;
        	lastItemReturned=null;			
		}
		
	}
	/***** END OF ITERATOR CLASS *****/
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	/**
	 * Constructor
	 */
	public MyLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.util.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(Object data) {
		addLast((T)data);
		return true;
	}
	/**
	 * Creates a new node and adds it to the front of the list
	 * @param data
	 */
	public void addFirst(T data){
		add(0,data);
	}
	/**
	 * Creates a new node and adds it to the end of the list
	 * @param data
	 */
	public void addLast(T data){
		add(size, data);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String data = "";
		for (int i=0; i<size; i++){
			data+= get(i);
			if (i<size-1){
				data+="-> ";
			}
		}
		return data;
	}

	/* (non-Javadoc)
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Object data) {
		listIterator(index).add(data);
	}	

	/* (non-Javadoc)
	 * @see java.util.List#clear()
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;	
		size = 0;
	}

	/* (non-Javadoc)
	 * @see java.util.List#get(int)
	 */
	@Override
	public Object get(int index) {
		return listIterator(index).next();
	}

	/* (non-Javadoc)
	 * @see java.util.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return head==null;
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	@Override
	public ListIterator listIterator() {
		return new MyIterator<T>(0);
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	@Override
	public ListIterator listIterator(int index) {
		return new MyIterator<T>(index);
	}

	/* (non-Javadoc)
	 * @see java.util.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.List#remove(int)
	 */
	@Override
	public Object remove(int index) {
		if (index<0 || index>size){
			throw new IndexOutOfBoundsException("Invalid index "+index);
		}
		T data;
		if (index == 1){
			data = removeFirst();
		}
		else if (index == size){
			data = removeLast();
		}
		else {
			ListIterator iter = listIterator(index-1);
			data = (T) iter.next();
			iter.remove();
			size--;	
		}
			
		return data;
	}
	/**
	 * Removes the first item on the list
	 * @return data from removed item
	 */
	public T removeFirst(){
		T data = head.data;
		head = head.next;
		size--;	
		return data;
		
	}
	/**
	 * Removes the last item on the list
	 * @return data from removed item
	 */
	public T removeLast(){
		T data = tail.data;
		tail = tail.prev;
		size--;	
		return data;	
		
	}

	/* (non-Javadoc)
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	@Override
	public Object set(int index, Object data) {
		if (index<0 || index>size){
			throw new IndexOutOfBoundsException("Invalid index "+index);
		}
		ListIterator iter = listIterator(index-1);
		T Olddata = (T) iter.next();
		iter.set(data);
		return Olddata;
	}

	/* (non-Javadoc)
	 * @see java.util.List#size()
	 */
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
