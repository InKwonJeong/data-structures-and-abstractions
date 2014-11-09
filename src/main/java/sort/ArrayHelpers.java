package sort;

/** Helper functions for sorting.
 * @author John Bannister */
public abstract class ArrayHelpers {
	
	/** Swap two elements of an array given their indices.
	 * 
	 * @param a  the array to work on
	 * @param first  the index of the first element to swap
	 * @param second  the index of the second element to swap
	 */
	public static void swap(Object[] a, int first, int second){
		Object newFirst = a[second];
		a[second] = a[first];
		a[first] = newFirst;
	}
	
	/** Find the smallest Comparable in a subarray determined by
	 * indices first and last.
	 * 
	 * @param a  the array
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray
	 * @return the index of the smallest element of the subarray */
	public static <T extends Comparable<? super T>> int
			getIndexOfSmallest(T[] a, int first, int last){
		int smallest = first;
		for(int index = first + 1; index <= last; index++) {
			if(a[smallest].compareTo(a[index]) == 1)
				smallest = index;
		}
		return smallest;
	}
	
	/** Given array indices that define a sorted subarray, place the element
	 * just above the subarray at the end of the subarray if it is smaller
	 * than the largest element and recurse on a 1-smaller subarray.
	 * 
	 * @param a  the array to work on
	 * @param begin  the index of the beginning of the sorted subarray
	 * @param end  the index of the end of the sorted subarray */
	public static <T extends Comparable<? super T>>
			void insertInOrderRecursive(T[] a, int begin, int end) {
		/* pre: end is not the last element of a */
		if(begin <= end) {
			if(a[end + 1].compareTo(a[end]) == -1) {
				swap(a, end, end + 1);
				insertInOrderRecursive(a, begin, end - 1);
			}
		}
	}
}
