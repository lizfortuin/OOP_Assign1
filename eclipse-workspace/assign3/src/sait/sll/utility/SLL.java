package sait.sll.utility;

/**
 * Singly Liked List implementation of LinkedListADT interface
 * Stores elements as generic Objects using Node objects
 */

public class SLL implements LinkedListADT {
	
	private Node head; 	// first node in the list
	private int size;   // number of elements in the list
	
	/**
	 * Creates an empty singly linked list
	 */
	
	public SLL() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Returns true if the list has no elements
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all elements from the list
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 */
	@Override
	public void append(Object data) {
		Node newNode = new Node(data);

	    if (head == null) {
	        head = newNode;
	    } else {
	        Node current = head;
	        while (current.getNext() != null) {
	            current = current.getNext();
	        }
	        current.setNext(newNode);
	    }

	    size++;
	}

	/**
	 * Prepends an element to the begining of the list
	 */
	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);
		
		newNode.setNext(head);
		head = newNode;
		
		size++;
	}

	/**
	 * Inserts an element at a specific index
	 */
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
	        throw new IndexOutOfBoundsException("Invalid index: " + index);

	    if (index == 0) {
	        prepend(data);
	        return;
	    }

	    if (index == size) {
	        append(data);
	        return;
	    }

	    Node newNode = new Node(data);

	    Node current = head;
	    for (int i = 0; i < index - 1; i++) {
	        current = current.getNext();
	    }

	    newNode.setNext(current.getNext());
	    current.setNext(newNode);

	    size++;
	}

	/**
	 * Replaces the eleent at a specific index
	 */
	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
		
		Node current = head;
		
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		current.setData(data);
	}

	/**
	 * Returns the number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Deletes the element at a specific index
	 */
	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
		
		if (index == 0) {
			head = head.getNext();
		} else {
			Node current = head;
			for(int i = 0; i< index - 1; i++) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
		}
		size--;
	}

	/**
	 * Retrieves the element at a specific index
	 */
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("Invalid index: " + index);

	    Node current = head;

	    for (int i = 0; i < index; i++) {
	        current = current.getNext();
	    }

	    return current.getData();
	}

	/**
	 * Returns the index of the first occurence of the given data
	 */
	@Override
	public int indexOf(Object data) {
		Node current = head;
		int index = 0;
		
		while (current != null) {
			if (current.getData().equals(data)) return index;
			
			current = current.getNext();
			index++;
		}
		return -1; // not found
	}

	/**
	 * Returns true if the list contains the given data
	 */
	@Override
	public boolean contains(Object data) {
		return indexOf(data) != -1;
	}
	
}
