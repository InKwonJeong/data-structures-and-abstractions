package sort;

/** Group of subroutines that implement selection sort on arrays.
 * @author John Bannister */
public abstract class SelectionArray{
	
	/** Sort a subarray of Comparable using iterative selection sort
	 * 
	 * @param a  the array to work on
	 * @param n  the index of the last element to sort */
	public static <T extends Comparable<? super T>>
		void selectionSortArrayIterative(T[] a, int n) {
		int currentElement = 0;
		
		while(currentElement < n) {
			int smallest = ArrayHelpers.getIndexOfSmallest(a, currentElement, n);
			ArrayHelpers.swap(a, currentElement, smallest);
			currentElement++;
		}
	}
	
	/** Sort a subarray of Comparable using recursive selection sort
	 * 
	 * @param a  the array to work on
	 * @param n  the index of the last element to sort */
	public static <T extends Comparable<? super T>>
		void selectionSortArrayRecursive(T[] a, int n) {
		selectionSortArrayRecursiveHelper(a, 0, n);
	}
	
	/** Recursive implementation of selection sort
	 * 
	 * @param a  the array to work on
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray
	 * @return the sorted array */
	private static <T extends Comparable<? super T>>
		void selectionSortArrayRecursiveHelper(T[] a, int first, int last) {
		if(first == last) {  // base case: subarray containing one element
			return;
		} else {
			int smallest = ArrayHelpers.getIndexOfSmallest(a, first, last);
			ArrayHelpers.swap(a, first, smallest);
		}
		/* first element is smallest in the subarray; call this function
		 * on the subarray that is one element smaller */
		selectionSortArrayRecursiveHelper(a, first + 1, last);
	}
	
}
