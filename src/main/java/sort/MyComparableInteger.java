package sort;

/** Toy class for an object that is like an Integer but has no more functionality
 * than holding an int, implementing Comparable and overriding toString().
 * @author John Bannister */
public class MyComparableInteger implements Comparable<MyComparableInteger> {
	private int val;
	
	MyComparableInteger(int val){
		super();
		this.val = val;
	}
	
	public int getValue(){
		return val;
	}
	
	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	public int compareTo(MyComparableInteger o) {
		int result = o.getValue();
		if(val == result)
			return 0;
		else if(val < result)
			return -1;
		else
			return 1;
	}

	/** @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return String.valueOf(val);
	}
	
	
}
