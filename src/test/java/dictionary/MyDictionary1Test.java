package dictionary;

import static org.junit.Assert.*;

import java.util.Enumeration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyDictionary1Test {
	private MyDictionary1<String, String> dictString;
	private String key1 = "Key 1";
	private String val1 = "Value 1";
	private String key2 = "Key 2";
	private String val2 = "Value 2";
	private String key3 = "Key 3";
	private String val3 = "Value 3";
	private String[] keys = {key1, key2, key3};
	private String[] vals = {val1, val2, val3};
	
	private void addStrings() {
		dictString.put(key1, val1);
		dictString.put(key2, val2);
		dictString.put(key3, val3);
	}
	
	@Before
	public void setUp() throws Exception {
		dictString = new MyDictionary1<String, String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSize() {
		// empty
		assertTrue(dictString.size() == 0);
		
		addStrings();
		
		assertTrue(dictString.size() == 3);
	}

	@Test
	public final void testIsEmpty() {
		//empty
		assertTrue(dictString.isEmpty());
		
		addStrings();
		
		assertFalse(dictString.isEmpty());
	}

	@Test
	public final void testKeys() {
		// not empty
		addStrings();
		
		Enumeration<String> theEnum = dictString.keys();
		boolean same = false;
		
		for (int i = 0; i < keys.length; i++) {
			String result = null;
			if(theEnum.hasMoreElements())
				result = theEnum.nextElement();
			if(i == 0)
				same = same || keys[i].equals(result);
			else
				same = same && keys[i].equals(result);
		}
		
		assertTrue(same);
	}

	@Test
	public final void testElements() {
		// not empty
		addStrings();

		Enumeration<String> theEnum = dictString.elements();
		boolean same = false;

		for (int i = 0; i < vals.length; i++) {
			String result = null;
			if(theEnum.hasMoreElements())
				result = theEnum.nextElement();
			if(i == 0)
				same = same || vals[i].equals(result);
			else
				same = same && vals[i].equals(result);
		}

		assertTrue(same);
	}

	@Test
	public final void testGetObject() {
		// not empty
		addStrings();
		
		boolean same = false;
		
		for (int i = 0; i < keys.length; i++) {
			String result = dictString.get(keys[i]);
			
			if(i == 0)
				same = same || vals[i].equals(result);
			else
				same = same && vals[i].equals(result);
		}
		
		assertTrue(same);
	}

	@Test
	public final void testPutKV() {
		dictString.put(key1, val1);
		
		assertTrue(dictString.get(key1).equals(val1));
	}

	@Test
	public final void testRemoveObject() {
		addStrings();
		
		dictString.remove(key1);
		
		assertTrue(dictString.get(key1) == null);
	}

}
