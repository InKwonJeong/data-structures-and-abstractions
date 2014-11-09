package sort;

/** Group of subroutines that implement insertion sort on arrays.
 * @author John Bannister */
public abstract class InsertionArray {
	/* Pseudocode for insertion sort via Wikipedia:
	 * for i = 1 to length(a)
	 *     j = i
	 *     while j > 0 and A[j - 1] > A[j]
	 *         swap A[j] and A[j - 1]
	 *         j = j - 1
	 */

	/** Sort a subarray determined by indices first and last using
	 * iterative insertion sort.
	 * 
	 * @param a  the array to work on
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray */
	public static <T extends Comparable<? super T>>
			void insertionSortArrayIterative(T[] a, int first, int last) {
		for(int nextToInsert = first + 1; nextToInsert <= last; nextToInsert++) {
			int index = nextToInsert;
			while(index > 0 && a[index].compareTo(a[index - 1]) == -1) {
				ArrayHelpers.swap(a, index, index - 1);
				index--;
			}
		}
	}
	
	/** Sort a subarray determined by indices first and last using
	 * recursive insertion sort.
	 * 
	 * @param a  the array to work on
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray */
	public static <T extends Comparable<? super T>>
	void insertionSortArrayRecursive(T[] a, int first, int last) {
		/* when first == last, the subarray is one element and is therefore
		 * sorted */
		if(first < last) {
			insertionSortArrayRecursive(a, first, last - 1);
			ArrayHelpers.insertInOrderRecursive(a, first, last - 1);
		}
	}

}
