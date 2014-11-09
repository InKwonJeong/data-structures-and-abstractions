package stack;

import java.util.Vector;

/** Stack using java.util.Vector
 * @author John Bannister */
public class VectorStack<T> implements StackInterface<T>{
	private Vector<T> stack;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	public VectorStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public VectorStack(int initialCapacity){
		super();
		stack = new Vector<T>(initialCapacity);
	}

	/** @see stack.StackInterface#push(java.lang.Object) */
	public void push(T newEntry) {
		stack.add(newEntry);
	}

	/** @see stack.StackInterface#pop() */
	public T pop() {
		T result = null;
		if(!isEmpty())
			result = stack.remove(stack.size() - 1);
		return result;
	}

	/** @see stack.StackInterface#peek() */
	public T peek() {
		T result = null;
		if(!isEmpty())
			result = stack.lastElement();
		return result;
	}

	/** @see stack.StackInterface#isEmpty() */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/** @see stack.StackInterface#clear() */
	public void clear() {
		stack.clear();
	}

}
