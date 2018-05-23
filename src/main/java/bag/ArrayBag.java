package bag;

/** Creates a bag object which is an unordered collection with repetition. This
 * implementation's underlying data store is an array. Implements the
 * bag interface from Carrano.
 * @author John Bannister */
public class ArrayBag<T> implements BagInterface<T> {
	private static final int DEFAULT_SIZE = 16;
    private T[] bag;
    private int numberOfEntries;
    
    // **************  Constructors  **************  //
    /** no arguments */
	public ArrayBag() {
		this(DEFAULT_SIZE);
	}
    
	/** @param numberOfEntries size of initial bag */
	@SuppressWarnings("unchecked") // initialized to nulls
	public ArrayBag(int initialSize) {
		super();
		bag = (T[]) new Object[initialSize];
		numberOfEntries = 0;
	}
	// ***********  End Constructors  *************  //
	

	/** @see bag.BagInterface#getCurrentSize() */
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/** @see bag.BagInterface#isFull() */
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}

	/** @see bag.BagInterface#isEmpty() */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/** @see bag.BagInterface#add(java.lang.Object) */
	public boolean add(T newentry) {
		if(isFull()) resize();
		bag[numberOfEntries++] = newentry;
		return true;
	}
	
	/** enlarge the array */
	private void resize(){
		int currentSize = bag.length;
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Comparable[2 * currentSize];  // initialized
		for(int i = 0; i < numberOfEntries; i++) {             // to nulls
			newArray[i] = bag[i];
		}
		bag = newArray;
	}

	/** @see bag.BagInterface#remove() */
	public T remove() {
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}
	
	/** remove an entry by index
	 * @param givenIndex
	 * @return the entry removed or null */
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			numberOfEntries--;
			bag[givenIndex] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		}
		return result;
	}

	/** @see bag.BagInterface#remove(java.lang.Object) */
	public boolean remove(T anEntry) {
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}
	
	/** @param anEntry 
	 * @return index of anEntry or -1 */
	private int getIndexOf(T anEntry) {
		boolean found = false;
		int counter = 0;
		
		while(counter < numberOfEntries && !found) {
			if(bag[counter].equals(anEntry)) {
				found = true;
				return counter;
			}
			counter++;
		}
		return -1;
	}

	/** @see bag.BagInterface#clear() */
	public void clear() {
		while(!isEmpty())
			remove();
	}

	/** @see bag.BagInterface#getFrequencyOf(java.lang.Object) */
	public int getFrequencyOf(T anEntry) {
		int count = 0,counter =0;
		while(counter < numberOfEntries){
			if(bag[counter++].equals(anEntry))
				++count;
		}
		return count;
	}

	/** @see bag.BagInterface#contains(java.lang.Object) */
	public boolean contains(T anEntry) {
		return getIndexOf(anEntry) > -1;
	}

	/** @see bag.BagInterface#toArray() */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])new Object[numberOfEntries];  // initialized
		for(int i = 0; i < numberOfEntries; i++) {        // to nulls
			newArray[i] = bag[i];
		}
		return newArray;
	}

}
