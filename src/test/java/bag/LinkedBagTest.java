package bag;

import static org.junit.Assert.*;

//import java.util.Arrays;

import org.junit.Test;

public class LinkedBagTest {

	@Test
	public final void testGetCurrentSize() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		assertTrue(testBag.getCurrentSize()==0);
		testBag.add(new Integer(3));
		assertTrue(testBag.getCurrentSize()==1);
	}

	@Test
	public final void testIsFull() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		testBag.add(new Integer(1));
		assertFalse(testBag.isFull());
	}

	@Test
	public final void testIsEmpty() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		assertTrue(testBag.isEmpty());
	}

	@Test
	public final void testAdd() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		assertTrue(testBag.getCurrentSize() == 1);
	}

	@Test
	public final void testRemove() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		assertTrue(testBag.getCurrentSize() == 1);
		testBag.remove();
		assertTrue(testBag.getCurrentSize() == 0);
	}

	@Test
	public final void testRemove2() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		testBag.add(new Integer(2));
		testBag.add(new Integer(3));
		testBag.remove(one);
		assertTrue(testBag.getCurrentSize() == 2);
	}

	@Test
	public final void testClear() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		testBag.add(new Integer(1));
		testBag.clear();
		assertTrue(testBag.getCurrentSize() == 0);
	}

	@Test
	public final void testGetFrequencyOf() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		Integer one = new Integer(1);
		for(int i = 0; i < 5; i++) {
			testBag.add(one);
		}
		assertTrue(testBag.getFrequencyOf(new Integer(1)) == 5);
	}

	@Test
	public final void testContains() {
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		for(int i = 50; i < 100; i += 5){
			testBag.add(new Integer(i));
		}
		assertTrue(testBag.contains(one));
		assertTrue(testBag.contains(new Integer(65)));
	}

	@Test
	public final void testToArray() {
		Integer zero = new Integer(0);
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer[] testArray = {zero, one, two, three};
		LinkedBag<Integer> testBag = new LinkedBag<Integer>();
		boolean result = true;
		for(Integer i : testArray){
			testBag.add(i);
		}
		for(Object i : testBag.toArray()){
			result = result && testBag.contains((Integer)i);
		}
		assertTrue(result);
	}

}
