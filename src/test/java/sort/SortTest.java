package sort;

import java.util.Random;

import bag.LinkedGroup;

/** Informally tests the sorting routines including the one in the LinkedGroup. 
 * @author John Bannister */
public class SortTest {

	public static void main(String[] args) {
		int size = 20;
		MyComparableInteger[] array = new MyComparableInteger[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++){
			int num = rand.nextInt(size * 2) + 1;
			array[i] = new MyComparableInteger(num);
		}
		System.out.println("array is ");
		printArray(array);
		//SelectionArray.selectionSortArrayRecursive(array, size - 1);
		//InsertionArray.insertionSortArrayIterative(array, 0, size - 1);
		InsertionArray.insertionSortArrayRecursive(array, 0, size - 1);
		//BubbleArray.bubbleSortArray(array, 0, size - 1);
		//BubbleArray.bubbleSortArrayRecursive(array, 0, size - 1);
		//ShellSortArray.shellsort(array, 0, size - 1);
		
		System.out.println("\nsorted ");
		printArray(array);
		
		LinkedGroup<MyComparableInteger> linkedGroup =
				new LinkedGroup<MyComparableInteger>();
		for(int i = 0; i < size; i++) {
			int num = rand.nextInt(size * 2) + 1;
			linkedGroup.add(new MyComparableInteger(num));
		}
		System.out.println("\nthe linkedGroup: ");
		Object[] theArray = linkedGroup.toArray();
		printArray(theArray);
		linkedGroup.sort();
		System.out.println("\nsorted: ");
		theArray = linkedGroup.toArray();
		printArray(theArray);
		
		size = 30;
		array = new MyComparableInteger[size];
		for(int i = 0; i < size; i++){
			int num = rand.nextInt(size * 2) + 1;
			array[i] = new MyComparableInteger(num);
		}
		System.out.println("\n\narray:");
		printArray(array);
		System.out.println();
		ShellSortArray.anotherShellSort(array, 2, array.length - 3);
		System.out.println("\nshellsorted:");
		printArray(array);
		ShellSortArray.anotherShellSort(array, 0, array.length - 1);
		System.out.println("\nshellsorted more:");
		printArray(array);
	}
	
	private static <T> void printArray(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
