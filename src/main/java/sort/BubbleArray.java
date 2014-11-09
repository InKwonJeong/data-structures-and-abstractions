package sort;

/** Bubble sorting.
 * @author John Bannister */
public abstract class BubbleArray {
	
	/** Bubble sort a subarray defined by first and last.
	 * @param a  the array to operate on.
	 * @param first  the position of the first element of the subarray
	 * @param last  the position of the last element of the subarray */
	public static <T extends Comparable<? super T>> void
			bubbleSortArray(T[] a, int first, int last) {
		int ultimate = last;
		while(ultimate > 0) {
			for(int i = first; i < ultimate; i++) {
				if(a[i].compareTo(a[i + 1]) > 0) {
					ArrayHelpers.swap(a, i, i + 1);
				}
			}
			ultimate--;
		}
	}
	
	/* A silly use of recursion.*/ 
	public static <T extends Comparable<? super T>> void
			bubbleSortArrayRecursive(T[] a, int first, int last) {
		if (first != last) {
			for(int i = first; i < last; i++) {
				if(a[i].compareTo(a[i + 1]) > 0) {
					ArrayHelpers.swap(a, i, i + 1);
				}
			}
			bubbleSortArrayRecursive(a, first, last - 1);
		}
	}
}
