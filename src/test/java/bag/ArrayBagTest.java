package bag;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ArrayBagTest {
	@Before
	public void setUp() {
		
	}
	@Test
	public final void testGetCurrentSize() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		assertTrue(testBag.getCurrentSize()==0);
		testBag.add(new Integer(3));
		assertTrue(testBag.getCurrentSize()==1);
	}

	@Test
	public final void testIsFull() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>(1);
		testBag.add(new Integer(1));
		assertTrue(testBag.isFull());
	}

	@Test
	public final void testIsEmpty() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		assertTrue(testBag.isEmpty());
	}

	@Test
	public final void testAdd() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		assertTrue(testBag.getCurrentSize() == 1);
	}

	@Test
	public final void testRemove() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		assertTrue(testBag.getCurrentSize() == 1);
		testBag.remove();
		assertTrue(testBag.getCurrentSize() == 0);
	}

	@Test
	public final void testRemove2() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		Integer one = new Integer(1);
		testBag.add(one);
		testBag.add(new Integer(2));
		testBag.add(new Integer(3));
		testBag.remove(one);
		assertTrue(testBag.getCurrentSize() == 2);
	}

	@Test
	public final void testClear() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		testBag.add(new Integer(1));
		testBag.clear();
		assertTrue(testBag.getCurrentSize() == 0);
	}

	@Test
	public final void testGetFrequencyOf() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		Integer one = new Integer(1);
		for(int i = 0; i < 5; i++) {
			testBag.add(one);
		}
		assertTrue(testBag.getFrequencyOf(new Integer(1)) == 5);
	}

	@Test
	public final void testContains() {
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
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
		ArrayBag<Integer> testBag = new ArrayBag<Integer>();
		for(Integer i : testArray){
			testBag.add(i);
		}
		assertTrue(Arrays.equals(testArray, testBag.toArray()));
	}
	

}
