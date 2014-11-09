package stack;

public class StackTest {

	public static void main(String[] args) {
		VectorStack<String> theStack = new VectorStack<String>();
		for(int i = 1; i <= 10; i++)
			theStack.push("test " + i);
		while(!theStack.isEmpty())
			System.out.println(theStack.pop());
	}

}
