package iterator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import static iterator.TestConstants.*;

/** Beginnings of a series of junit tests for MyList before I discovered the
 * tests included by apache in their collections package.
 * @author John Bannister
 *
 */
public class MyListTest {
	private Integer one = new Integer(1);
	private Integer two = new Integer(2);
	private Integer three= new Integer(3);
	private Integer four= new Integer(4);
	private Integer five= new Integer(5);
	private MyList<Integer> testIntList;
	private MyList<String> testStrList;
	
	/** @throws java.lang.Exception */
	@Before
	public void setUp() throws Exception {
		testIntList = new MyList<Integer>();
		testStrList = new MyList<String>();
	}

	/** @throws java.lang.Exception */
	@After
	public void tearDown() throws Exception {
		testIntList = null;
	}

	/** Test method for {@link iterator.MyList#MyList()}. */
	@Test
	public final void testMyList() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#size()}. */
	@Test
	public final void testSize() {
		assertEquals("Empty list has zero entries", 0, testIntList.size());
		testIntList.add(one);
		assertEquals("List has 1 entry", 1, testIntList.size());
		
		testIntList.clear();
		for(int i = 0; i < 1000000; i++)
			testIntList.add(one);
		assertEquals("List has one million entries", 1000000, testIntList.size());
		
		for (int i = 0; i < TEST_QTY; i++) {
		      assertEquals(i, testStrList.size());
		      testStrList.add("testStr");
		      assertEquals(i + 1, testStrList.size());
		    }

		    for (int i = TestConstants.TEST_QTY; i >= 0; i--) {
		      assertEquals(i, testStrList.size());
		      if (i != 0) {
		    	  testStrList.remove(0);
		      }
		    }
		
	}

	/** Test method for {@link iterator.MyList#isEmpty()}. */
	@Test
	public final void testIsEmpty() {
		assertTrue(testStrList.isEmpty());
		testStrList.add("String 1");
	    assertFalse(testStrList.isEmpty());
	    testStrList.add("String 2");
	    assertFalse(testStrList.isEmpty());
	    testStrList.remove(0);
	    assertFalse(testStrList.isEmpty());
	    testStrList.remove(0);
	    assertTrue(testStrList.isEmpty());
	}
	
	/** Test method for {@link iterator.MyList#add(java.lang.Object)}
	 * when adding null */
	@Test
	public final void testAddNull() {
	    assertFalse(testIntList.add(null));
	  }

	/** Test method for {@link iterator.MyList#contains(java.lang.Object)}. */
	@Test
	public final void testContains() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#iterator()}. */
	@Test
	public final void testIterator() {
		assertTrue(testIntList.iterator().getClass().getName() == "iterator.MyIterator");
		
		MyList<String> comparisionList = new MyList<String>();
		for (int i = 0; i < TEST_QTY; i++) {
		      String str = Integer.toString(i);
		      comparisionList.add(str);
		      testStrList.add(str);
		    }
		
		Iterator<String> clIt = comparisionList.iterator();
	    Iterator<String> testIt = testStrList.iterator();
	    while (clIt.hasNext()) {
	      assertTrue(testIt.hasNext());
	      assertEquals(clIt.next(), testIt.next());
	    }
	    
	    boolean flip = false;
	    clIt = comparisionList.iterator();
	    testIt = testStrList.iterator();
	    while (clIt.hasNext()) {
	    	clIt.next();
	    	testIt.next();
	    	if (flip) {
	    		clIt.remove();
	    		testIt.remove();
	    		flip = false;
	    	}
	    	else {
	    		flip = true;
	    		}
	    }
	}

	/** Test method for {@link iterator.MyList#toArray()}. */
	@Test
	public final void testToArray() {
		Integer[] array = new Integer[] {one, two, three, four, five};
		for(Integer i : array)
			testIntList.add(i);
		assertTrue(Arrays.deepEquals(array, testIntList.toArray()));
		
		int testSize = 1000000;
		array = new Integer[testSize];
		for(int i = 0; i < testSize; i++) {
			array[i] = one;
		}
		testIntList.clear();
		
	}

	/** Test method for {@link iterator.MyList#toArray(T[])}. */
	@Test
	public final void testToArrayTArray() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#add(java.lang.Object)}. */
	@Test
	public final void testAddE() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#remove(java.lang.Object)}. */
	@Test
	public final void testRemoveObject() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#containsAll(java.util.Collection)}. */
	@Test
	public final void testContainsAll() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#addAll(java.util.Collection)}. */
	@Test
	public final void testAddAllCollectionOfQextendsE() {
		ArrayList<String> toAddList = new ArrayList<String>();
		
		// verify with empty list first
		assertFalse(testStrList.addAll(toAddList));
		
		populateIntStrings(toAddList, TEST_QTY);
		testStrList.addAll(toAddList);
		
		assertEquals(TEST_QTY, testStrList.size());
	    assertTrue(testStrList.containsAll(toAddList));
	    
	    Iterator<String> it = toAddList.iterator();
	    Iterator<String> testIt = testStrList.iterator();
	    while (it.hasNext() && testIt.hasNext()) {
	      assertTrue(it.next() == testIt.next());
	    }
	}

	/** Test method for {@link iterator.MyList#addAll(int, java.util.Collection)}. */
	@Test
	public final void testAddAllIntCollectionOfQextendsE() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#removeAll(java.util.Collection)}. */
	@Test
	public final void testRemoveAll() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#retainAll(java.util.Collection)}. */
	@Test
	public final void testRetainAll() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#clear()}. */
	@Test
	public final void testClear() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#get(int)}. */
	@Test
	public final void testGet() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#set(int, java.lang.Object)}. */
	@Test
	public final void testSet() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#add(int, java.lang.Object)}. */
	@Test
	public final void testAddIntE() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#remove(int)}. */
	@Test
	public final void testRemoveInt() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#indexOf(java.lang.Object)}. */
	@Test
	public final void testIndexOf() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#lastIndexOf(java.lang.Object)}. */
	@Test
	public final void testLastIndexOf() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#listIterator()}. */
	@Test
	public final void testListIterator() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#listIterator(int)}. */
	@Test
	public final void testListIteratorInt() {
		fail("Not yet implemented"); // TODO
	}

	/** Test method for {@link iterator.MyList#subList(int, int)}. */
	@Test
	public final void testSubList() {
		fail("Not yet implemented"); // TODO
	}
	
	private void populateIntStrings(List<String> testList, int qty) {
	    for (int i = 0; i < qty; i++) {
	      String str = Integer.toString(i);
	      testList.add(str);
	    }
	}

}
