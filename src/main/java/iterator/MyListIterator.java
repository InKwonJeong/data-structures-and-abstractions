package iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author John Bannister
 *
 */
public class MyListIterator<E> implements ListIterator<E> {
	private int cursorPosition, maxCursorPosition;
	private List<E> myList;
	private boolean nextCalled, prevCalled;
	
	public MyListIterator(List<E> theList) {
		this(theList, 0);
	}
	public MyListIterator(List<E> theList, int index) {
		myList = theList;
		if(index < 0 || index > theList.size()) throw new
			IndexOutOfBoundsException(String.valueOf(index));
		cursorPosition = index;
		maxCursorPosition = theList.size();
		nextCalled = false;
		prevCalled = false;
	}

	/** @see java.util.ListIterator#hasNext() */
	public boolean hasNext() {
		if(myList.isEmpty()) return false;
		else return cursorPosition < maxCursorPosition;
	}

	/** @see java.util.ListIterator#next() */
	public E next() {
		if(!hasNext()) throw new NoSuchElementException();
		
		nextCalled = true;
		prevCalled = false;
		return myList.get(cursorPosition++);
	}

	/** @see java.util.ListIterator#hasPrevious() */
	public boolean hasPrevious() {
		if(myList.isEmpty()) return false;
		else return cursorPosition > 0 && cursorPosition <= myList.size();
	}

	/** @see java.util.ListIterator#previous() */
	public E previous() {
		if(!hasPrevious()) throw new NoSuchElementException();
		
		nextCalled = false;
		prevCalled = true;
		return myList.get(--cursorPosition);
	}

	/** @see java.util.ListIterator#nextIndex() */
	public int nextIndex() {
		if(cursorPosition == maxCursorPosition) return maxCursorPosition;
		else return cursorPosition;
	}

	/** @see java.util.ListIterator#previousIndex() */
	public int previousIndex() {
		if(cursorPosition == 0) return -1;
		else return cursorPosition - 1;
	}

	/** @see java.util.ListIterator#remove() */
	public void remove() {
		if(!nextCalled && !prevCalled) throw new IllegalStateException();
		
		if(nextCalled) {
			myList.remove(cursorPosition - 1);
			cursorPosition--;
		}
		else if(prevCalled) {
			myList.remove(cursorPosition);
		}
		
		nextCalled = false;
		prevCalled = false;
		maxCursorPosition = myList.size();		
	}

	/** @see java.util.ListIterator#set(java.lang.Object) */
	public void set(E e) {
		if(!nextCalled && !prevCalled) throw new IllegalStateException();
		
		if(nextCalled) {
			myList.set(cursorPosition - 1, e);
		}
		else if(prevCalled) {
			myList.set(cursorPosition, e);
		}
		
		nextCalled = false;
		prevCalled = false;
	}

	/** @see java.util.ListIterator#add(java.lang.Object) */
	public void add(E e) {
		if(myList.isEmpty() || cursorPosition == maxCursorPosition) {
			myList.add(e);
		}
		else {
			myList.add(cursorPosition, e);
		}
		cursorPosition++;
		maxCursorPosition = myList.size();
	}

}
