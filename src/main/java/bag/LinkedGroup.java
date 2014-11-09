package bag;

/** Extends the LinkedBag with a sort function.
 * @author John Bannister
 *
 */
public class LinkedGroup<T extends Comparable<? super T>>
		extends LinkedBag<T> {
	public LinkedGroup(){
		super();
	}
	
	/** Insertion sort for the linked chain */
	public void sort() {
		if(getCurrentSize() != 0) {
			/* Break the list into two lists: sorted (first element)
			 * and unsorted (the rest of the list) */
			Node<T> unsortedPart = firstNode.getNextNode();
			firstNode.setNextNode(null);
			
			while(unsortedPart != null) {
				/* for each element in unsorted, insert it into the
				 * sorted list */
				Node<T> nodeToInsert = unsortedPart;
				unsortedPart = unsortedPart.getNextNode();
				insertInOrder(nodeToInsert);
			}
		}
	}
	
	/** Insert a given node in the correct order in the list
	 * @param nodeToInsert  a Node that will be inserted into the list */
	private void insertInOrder(Node<T> nodeToInsert) {
		T item = (T)nodeToInsert.getData();
		Node<T> currentNode = firstNode;
		Node<T> previousNode = null;
		
		/* walk through the list updating the current item until it is
		 * larger than the insert item
		 */
		while( (currentNode != null) &&
			   (item.compareTo(currentNode.getData())) > 0) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if(previousNode != null) {  // i.e., not at beginning of list
			previousNode.setNextNode(nodeToInsert);
			nodeToInsert.setNextNode(currentNode);
		}
		else { // at beginning of list so insert node is new first node
			nodeToInsert.setNextNode(firstNode);
			firstNode = nodeToInsert;
		}
		
	}
	
}
