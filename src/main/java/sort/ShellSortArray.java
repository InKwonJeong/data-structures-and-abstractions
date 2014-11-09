package sort;

/** Shell sort for arrays.
 * @author John Bannister
 *
 */
public abstract class ShellSortArray {
	/* Pseudocode via Wikipedia:
	 * 
	 * # Sort an array a[0...n-1].
	 *	gaps = [701, 301, 132, 57, 23, 10, 4, 1]
	 *
	 *	# Start with the largest gap and work down to a gap of 1 
	 *	foreach (gap in gaps)
	 *	{
     *		# Do a gapped insertion sort for this gap size.
     *		# The first gap elements a[0..gap-1] are already in gapped order
     *		# keep adding one more element until the entire array is gap sorted 
     *		for (i = gap; i < n; i += 1)
     *		{
     *   		# add a[i] to the elements that have been gap sorted
     *  		# save a[i] in temp and make a hole at position i
     *   		temp = a[i]
     *	 		# shift earlier gap-sorted elements up until the correct location for a[i] is found
     *    		for (j = i; j >= gap and a[j - gap] > temp; j -= gap)
     *    		{
     *        		a[j] = a[j - gap]
     *    		}
     *    		# put temp (the original a[i]) in its correct location
     *    		a[j] = temp
     *		}
	 *
	 *	}
	 */
	public static <T extends Comparable<? super T>>
			void shellsort(T[] a, int first, int last) {
		// translation of pseudocode to Java
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		int size = last - first + 1;
		int j;
		
		for(int index = 0; index < gaps.length; index++) {
			int gap = gaps[index];
			if(gap <= size) {
				for(int i = gap; i < a.length; i++) {
					T temp = a[i];
					for(j = i;
							j >= gap && (a[j - gaps[index]].compareTo(temp) == 1);
							j -= gap ) {
						a[j] = a[j - gap];
					}
					a[j] = temp;
				}
			}
		}
	}
	
	/** Given a subarray defined by positions first and last, treat the elements
	 * 			{first + k * space : k in N, k * space <= last}
	 * as a subarray to be sorted by insertion sort.
	 * @param a  the array to work on
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray
	 * @param space  the distance between elements in the subarray to be sorted
	 * */
	public static <T extends Comparable<? super T>>
		void incrementalInsertionSort(T[] a, int first, int last, int space) {
		int unsorted, index;
		
		/* On first iteration, the unsorted portion of the subarray are the
		 * elements that are
		 * 		k * space (k in N)
		 * slots to the right of the first element in the subarray. On the
		 * second iteration, the first and the first + space elements are
		 * ordered and those that are k * space elements away to the right are
		 * the unsorted elements, etc until the last sorted element + space is
		 * beyond the end of the array. 
		 */
		for(unsorted = first + space; unsorted <= last; unsorted += space) {
			T nextToInsert = a[unsorted];
			
			/* The value of index is the position of the last element that has
			 * been sorted, which is the first element of the subarray on the
			 * 1st iteration of the outer loop, the first + space on the 2nd,
			 * the first + (space * 2) on the 3rd, etc.
			 * 
			 * On each iteration of this loop, the first unsorted element is
			 * compared to the index. If it is smaller, then the element at
			 * index is copied to the right space spaces, which on the first
			 * iteration is the position held by unsorted.
			 */
			for(index = unsorted - space; (index >= first) &&
					(nextToInsert.compareTo(a[index]) < 0);
					index -= space) {
				a[index + space] = a[index];
			}
			/* When the loop concludes, all elements that are larger than
			 * unsorted have been moved to the right by space spaces. The
			 * variable index is now at the position of the largest element
			 * that is smaller than unsorted. Then unsorted is placed space
			 * spaces to the right of the index.
			 */
			a[index + space] = nextToInsert;
		}
	}
	
	/** Given an array and two indices that determine a subarray, use shellsort
	 * to sort the subarray. Directly from Carrano with comments added by me.
	 * @param a  the array to work on
	 * @param first  the index of the first element of the subarray
	 * @param last  the index of the last element of the subarray */
	public static <T extends Comparable<? super T>>
			void anotherShellSort(T[] a, int first, int last) {
		int len = last - first + 1;
		// Make the space of the shellsort be 1/2 the size of the array,
		// reducing by half for each iteration until 1.
		for (int space = len/2; space > 0; space /= 2) {
			// on final iteration, when space = 1, this is a plain insertion
			// sort.
			for(int begin = first; begin < first + space; begin++)
				incrementalInsertionSort(a, begin, last, space);
		}
	}
}
