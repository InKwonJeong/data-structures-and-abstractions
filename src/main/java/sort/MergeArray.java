package sort;

//import java.util.ArrayList;

/** Merge sort for arrays.
 * @author John Bannister */
public final class MergeArray {

	public static int[] mergeSort(int[] a) {
		int len = a.length;
		
		if(len == 1)  // base case
			return a;
		
		int[] left = new int[len / 2]; 
		for(int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}
		left = mergeSort(left);
		
		int[] right = new int[len - len / 2];
		for(int i = 0; i < right.length; i++) {
			right[i] = a[i + left.length];
		}
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	/** Merge two arrays into one where the elements are in order.
	 * @param left  one of the arrays to merge
	 * @param right  the other array to merge
	 * @return  the merged array */
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int current = 0;
		
		// populate result while there are still elements in one array
		while(leftIndex < left.length && rightIndex < right.length) {
			if(left[leftIndex] <= right[rightIndex]) {
				result[current++] = left[leftIndex++];
			}
			else {
				result[current++] = right[rightIndex++];
			}
		}
		// deal with leftovers
		if(current < result.length) {
			while(leftIndex < left.length) {
				result[current++] = left[leftIndex++];
			}
			while(rightIndex < right.length) {
				result[current++] = right[rightIndex++];
			}
		}
		
		return result;
	}
}
