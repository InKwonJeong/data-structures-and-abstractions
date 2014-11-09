package iterator;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/** Implementation of a java list by extending the java collections framework's
 * AbstractList. Done for practice...
 * @author John Bannister
 *
 */
public class MyList<E> extends AbstractList<E> {
	Node<E> head, tail;
	int size;
	
	public MyList() {
		head = null;
		tail = null;
		size = 0;
	}
	public MyList(Collection<E> col) {
		this();
		if(col == null) throw new NullPointerException();
				
		for(E i : col)
			add(i);
	}

	/** @see java.util.AbstractList#add(java.lang.Object) */
	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	/** @see java.util.AbstractList#add(int, java.lang.Object) */
	@Override
	public void add(int index, E e) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		Node<E> nd = new Node<E>(e);
		
		if(index == size) {  // append
			if(size == 0) {  // add to empty list
				head = tail = nd;
			}
			else {
				tail.setNext(nd);
				tail = nd;
			}
		}
		else if(index == 0) {  // prepend, list has at least 1 element
			nd.setNext(head);
			head = nd;
		}
		else {  // list has at least 2 elements
			Node<E> prev = null;
			Node<E> next = head;
			int counter = 0;
			
			// assert: next will not be null
			while(counter < index) {
				prev = next;
				next = next.getNext();
				counter++;
			}
			
			prev.setNext(nd);
			nd.setNext(next);
		}
		size++;
	}

	/** @see java.util.AbstractList#remove(int) */
	@Override
	public E remove(int index) {
		if(size == 0 || index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		E result = null;
		
		/* assert: (size != 0 && index >= 0 && index < size) => index == 0 */
		if(size == 1) {
			result = head.getData();
			head = tail = null;
		}
		/* assert: size > 1 => head != null */
		else if(index == 0) {
			result = head.getData();
			head = head.getNext();
		}
		else {
			int counter = 0;
			Node<E> prev = null;
			Node<E> rem = head;
			
			/* assert: counter < index && index < size => rem != null */
			while(counter < index) {
				prev = rem;
				rem = rem.getNext();
				counter++;
			}
			
			/* assert: counter == index */
			result = rem.getData();
			prev.setNext(rem.getNext());  // getNext() may be null
			if(index == size - 1)
				tail = prev;
		}
		
		
		size--;
		
		return result;
	}

	/** @see java.util.AbstractCollection#remove(java.lang.Object) */
	@Override
	public boolean remove(Object o) {
		if(size == 0) return false;
		
		int counter = 0;
		Node<E> rem = head;
		boolean found = false;
		
		while(counter < size && !found) {
			E result = rem.getData();
			if(result == null) {
				if(o == null)
					found = true;
			}
			else if(result.equals(o)) found = true;
			if(!found) {
				counter++;
				rem = rem.getNext();
			}
		}
		
		if(found) remove(counter);
		
		return found;
	}

	/** @see java.util.AbstractList#set(int, java.lang.Object) */
	@Override
	public E set(int index, E element) {
		E result = remove(index);
		add(index, element);
		return result;
	}

	/** @see java.util.AbstractList#iterator() */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<E>(this);
	}
	
	/** @see java.util.AbstractList#listIterator() */
	@Override
	public ListIterator<E> listIterator() {
		return new MyListIterator<E>(this);
	}
	
	/** @see java.util.AbstractList#get(int) */
	@Override
	public E get(int index) {
		if(index < 0 || index >= size || size == 0)
			throw new IndexOutOfBoundsException();
		
		if(index == 0) return head.getData();
		else if(index == size - 1) return tail.getData();
		
		int counter = 0;
		Node<E> nd = head;
		
		/* assert: index != 0 */
		while(counter < index) {
			nd = nd.getNext();
			counter++;
		}
		
		return nd.getData();
	}

	/** @see java.util.AbstractCollection#size() */
	@Override
	public int size() {
		return size;
	}

	
	
	/** Node in a linked list */
	private class Node<T> {
		Node<T> next;
		T data;
		
		Node(T data) {
			this.data = data;
		}
		
		/** @return the next */
		public Node<T> getNext() {
			return next;
		}
		/** @param next the next to set */
		public void setNext(Node<T> next) {
			this.next = next;
		}
		/** @return the data */
		public T getData() {
			return data;
		}	
	}
}
