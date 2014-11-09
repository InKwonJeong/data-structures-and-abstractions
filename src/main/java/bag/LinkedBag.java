package bag;

/** Implements a bag which is an unordered collection with repetition. This
 * implementation's underlying data store is a linked chain. Implements
 * the bag interface from Carrano.
 * @author John Bannister */
public class LinkedBag<T> implements BagInterface<T> {
	protected Node<T> firstNode;
	protected int numberOfEntries;

	/** no arguments */
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}

	/** @see bag.BagInterface#getCurrentSize() */
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/** @see bag.BagInterface#isFull() */
	public boolean isFull() {
		return false;
	}

	/** @see bag.BagInterface#isEmpty() */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/** @see bag.BagInterface#add(java.lang.Object) */
	public boolean add(T newentry) {
		Node<T> newNode = new Node<T>(newentry);

		newNode.setNextNode(firstNode);
		firstNode = newNode;
		numberOfEntries++;

		return true;
	}

	/** @see bag.BagInterface#remove() */
	public T remove() {
		T item = null;

		if(!isEmpty()){
			item = (T)firstNode.getData();
			Node<T> newFirst = firstNode.getNextNode();
			firstNode = newFirst;
			numberOfEntries--;
		}

		return item;
	}

	/** @see bag.BagInterface#remove(java.lang.Object) */
	public boolean remove(T anEntry) {
		Node<T> previous = firstNode;
		Node<T> current = firstNode;
		boolean found = false;

		if(!isEmpty()){
			// assert previous != null && current != null;
			while(!found && current != null) {
				if(current.getData().equals(anEntry)) {
					found = true;
					Node<T> next = current.getNextNode();  // could be null
					previous.setNextNode(next);
					numberOfEntries--;
				} else {
					previous = current;
					current = current.getNextNode();
				}
			}
		}

		return found;
	}

	/** @see bag.BagInterface#clear() */
	public void clear() {
		//while(!isEmpty())
		//	remove();
		numberOfEntries = 0;
		firstNode = null;
	}

	/** @see bag.BagInterface#getFrequencyOf(java.lang.Object) */
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		Node<T> current = firstNode;

		while(current != null){
			if(current.getData().equals(anEntry))
				count++;
			current = current.getNextNode();
		}

		return count;
	}

	/** @see bag.BagInterface#contains(java.lang.Object) */
	public boolean contains(T anEntry) {
		return getFrequencyOf(anEntry) > 0;
	}

	/** @see bag.BagInterface#toArray() */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] theArray = (T[])new Object[numberOfEntries];  // initialized to nulls
		Node<T> current = firstNode;
		if(!isEmpty()){
			for(int i = 0; i < numberOfEntries; i++){
				theArray[i] = current.getData();
				current = current.getNextNode();
			}
		}

		return theArray;
	}

	/** a Node is the basic element of a linked chain */
	class Node<S> {
		private S    data;  // entry in bag
		private Node<S> next;  // link to next node

		Node(S dataPortion) {
			this(dataPortion, null);
		}
		Node(S dataPortion, Node<S> nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		/** @return the next */
		protected Node<S> getNextNode() {
			return next;
		}
		/** @param next the next to set */
		protected void setNextNode(Node<S> next) {
			this.next = next;
		}
		/** @return the data */
		protected S getData() {
			return data;
		}
		/** @param data the data to set */
		protected void setData(S data) {
			this.data = data;
		}
	}
}
