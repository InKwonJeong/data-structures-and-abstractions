package bag;

import java.util.Random;

/**
 * @author John Bannister</a>
 *
 */
public class LinkedBagTestDriver {
	LinkedBag<Float> floatBag;
	Random randomGenerator;
	
	public LinkedBagTestDriver() {
		floatBag = new LinkedBag<Float>();
		randomGenerator = new Random();
		setup();
	}
	
	private void setup() {
		for(int i = 1; i <=5; i++){
			floatBag.add(new Float((float) i * randomGenerator.nextFloat()));
		}
		System.out.print("Initial size is " + floatBag.getCurrentSize() + ": ");
		Object[] floatArray = floatBag.toArray();
		for(Object i : floatArray){
			System.out.print(i + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			System.out.print("\t" + floatBag.remove() + " removed");;
		}
		print();
		
		Float mypi = new Float(Math.PI);
		System.out.println("Adding " + mypi);
		floatBag.add(mypi);
		System.out.print("Adding two Floats: ");
		for(int i = 1; i <=2; i++){
			Float tmpFloat = new Float((float) i * randomGenerator.nextFloat());
			System.out.print(tmpFloat + " ");
			floatBag.add(tmpFloat);
		}
		print();
		System.out.println("Bag containes " + mypi + " is " 
				+ floatBag.contains(mypi));
		
		System.out.println("\nPrinting array: ");
		floatArray = floatBag.toArray();
		for(Object i : floatArray){
			System.out.print(i + ", ");
		}
		print();
		System.out.println("Removing " + mypi);
		floatBag.remove(mypi);
		print();
		
		System.out.println("Clearing bag.");
		floatBag.clear();
		print();
		
		System.out.println("Result of removing item: " + floatBag.remove());
		System.out.print("Adding one million entries takes ");
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			floatBag.add(new Float((float)i));
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + " milliseconds");
		System.out.print("Clearing one million entries takes ");
		startTime = System.currentTimeMillis();
		floatBag.clear();
		endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + " milliseconds");
	}

	private void print() {
		System.out.println("\nCurrent size is " + floatBag.getCurrentSize() + "\n");
	}

	public static void main(String[] args) {
		new LinkedBagTestDriver();

	}

}
