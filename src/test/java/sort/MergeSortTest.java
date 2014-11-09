package sort;

import java.util.Random;

/**
 * @author John Bannister</a>
 *
 */
public class MergeSortTest {

	public static void main(String[] args) {
		int size = 5;
		int[] array = new int[size];
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(size * 2) + 1;
		}
		
		System.out.println("array is:");
		printArray(array);
		
		array = MergeArray.mergeSort(array);
		
		System.out.println("\nsorted");
		printArray(array);
		
	}

	private static void printArray(int[] a) {
		for(int i : a) {
			System.out.print(i + " ");
		}
	}
}
