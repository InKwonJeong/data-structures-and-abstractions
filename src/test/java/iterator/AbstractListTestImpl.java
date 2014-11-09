package iterator;

import java.util.List;

import org.apache.commons.collections4.list.AbstractListTest;

/** Use the apache-commons-collections4 unit tests for an abstract list to test
 * MyList 
 * @author John Bannister*/
public class AbstractListTestImpl<E> extends AbstractListTest<E> {

	/** @param testName */
	public AbstractListTestImpl(String testName) {
		super(testName);
		// TODO Auto-generated constructor stub
	}

	/** @see org.apache.commons.collections4.list.AbstractListTest#makeObject() */
	@Override
	public List<E> makeObject() {
		List<E> myList = new MyList<E>();
		return myList;
	}

}
