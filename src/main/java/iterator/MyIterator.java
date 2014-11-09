package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author John Bannister
 *
 */
public class MyIterator<E> implements Iterator<E> {
	private List<E> myList;
	boolean nextCalled;
	int index, maxIndex;
	
	public MyIterator(List<E> theList) {
		myList = theList;
		nextCalled = false;
		index = 0;
		maxIndex = myList.size() - 1;
	}

	/** @see java.util.Iterator#hasNext() */
	public boolean hasNext() {
		return !myList.isEmpty() && index <= maxIndex;
	}

	/** @see java.util.Iterator#next() */
	public E next() {
		nextCalled = true;
		if(hasNext()) return myList.get(index++);
		else throw new NoSuchElementException();
	}

	/** @see java.util.Iterator#remove() */
	public void remove() {
		if(nextCalled) myList.remove(--index);
		else throw new IllegalStateException();
		nextCalled = false;
		maxIndex = myList.size() - 1;
	}
}
