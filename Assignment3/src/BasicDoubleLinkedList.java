import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * 
 * @author Huan Shiuan Huang
 *
 * @param <T> Generic type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected int size = 0;
	protected Node head = null, tail = null;

	// inner class Node
	protected class Node {
		protected T data;
		protected Node next;
		protected Node prev;

		Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

	}

	// inner class myIterator
	class myIterator implements ListIterator<T> {

		Node point;

		public myIterator() {
			point = new Node(null, head,null);
		}

		@Override
		public boolean hasNext() {
			if (point.next == null)
				return false;
			else
				return true;
		}

		@Override
		public T next() {
			T next;

			if (hasNext()) {
				next = point.next.data;
				point.prev = point.next;
				point.next = point.prev.next;
				return next;
			} else
				throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
				
			if (point.prev == null)
				return false;
			else
				return true;
		}

		@Override
		public T previous() {
			T previous;

			if (hasPrevious()) {
				previous = point.prev.data;
				point.next = point.prev;
				point.prev = point.next.prev;
				return previous;
			} else
				throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Notice you must not traverse the list to compute the size. This method just returns the value of the instance variable you use to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds an element to the end of the list. Do not use iterators to implement this method.
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node node = new Node(data, null, tail);

		if (head == null)
			head = node;

		if (tail != null)
			tail.next = node;

		tail = node;
		size++;
		return this;
	}

	/**
	 * Adds element to the front of the list. Do not use iterators to implement this method.
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node node = new Node(data, head, null);

		if (tail == null)
			tail = node;

		if (head != null)
			head.prev = node;

		head = node;
		size++;
		return this;

	}

	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst() {
		if (head != null)
			return head.data;
		else
			return null;
	}

	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getLast() {
		if (tail != null)
			return tail.data;
		else
			return null;
	}

	/**
	 * This method must be implemented using an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous(). Remember that we should be able to call the hasNext() method as many times as we want without changing what is considered the next element.
	 * @throws java.util.NoSuchElementException - Your next() method should throw NoSuchElementException if there are no more elements (at the end of the list and calling next() or at the beginning of the list and calling previous()).
	 * @throws java.lang.UnsupportedOperationException - You don't need to implement the ListIterator's remove(), add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
	 */
	@Override
	public java.util.ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException {
		return new myIterator();
	}

	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list. You may not use any of the other retrieval methods associated with the class in order to complete the removal process. You must use the provided comparator (do not use equals) to find those elements that match the target. Do not implement this method using iterators.
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
		Node data1;

		//remove if there is only one element
		if (head == tail && comparator.compare(head.data, targetData) == 0) {
			head = tail = null;
			return this;
		}

		//Find the targetData in the element
		data1 = head;
		while (comparator.compare(data1.data, targetData) != 0) {
			if (data1 == tail)
				return this;

			data1 = data1.next;
		}

		if (data1 == head) {
			head.next.prev = null;
			head = head.next;
			size--;
		}
		else if (data1 == tail) {
			tail.prev.next = null;
			tail = tail.prev;
			size--;
		} else {
			data1.prev.next = data1.next;
			data1.next.prev = data1.prev;
			size--;
		}
		
		return this;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		Node first;
		if (head == null)
			return null;
		else if(head == tail) {
			first = head;
			head = tail = null;
			return first.data;
		}
		else {
			first = head;
			head.next.prev = null;
			head = head.next;
			size--;
			return first.data;
		}
	}

	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null. Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		Node last;
		if (tail == null)
			return null;
		else if(head == tail) {
			last = tail;
			head = tail = null;
			return last.data;
		}
		else {
			last = tail;
			tail.prev.next = null;
			tail = tail.prev;
			size--;
			return last.data;
		}
	}

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list
	 * @return an arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList() {
		ArrayList<T> array = new ArrayList<>();
		// Create a iterator
		ListIterator<T> it = iterator();
		// go through the Node
		while (it.hasNext()) {
			array.add(it.next());
		}
		
		return array;
	}
}
