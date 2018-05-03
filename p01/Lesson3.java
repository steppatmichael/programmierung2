package p01;
/**
 * Lesson 3 - Performance measurement
 * A simple research on the time consumption of different array types 
 * @author steppat
 *
 */

public class Lesson3 {

	/** 
	 * exercise 1:
	 * Copy the Account class from Lesson 2, create an instance and fill it with 1000 transactions
	 * The transactions need not to be different. Just create one and add it in a loop to the account.
	 * Create one test-method which calls System.nanotime to save the actual value, then call remove of the 
	 * second element in the transaction list and call System.nanotime again to measure how long the 
	 * remove had take. Print it out to the console.   
	 */
	
	void exercise1() {
		 /* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 2: 
	 * Make a copy of the Account class. Remove the type parameter of the transaction ArrayList to make
	 * it raw type. Measure it again.
	 */
		
	void exercise2() {
		 /* YOUR CODE HERE */
	}
	
	
	/** 
	 * exercise 3:
	 * Minimize the number of transactions to 100 and measure in the loop how long the adding of each
	 * transaction takes. Test it for generic and for raw type. 
	 */
	
	void exercise3() {
		 /* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 4:
	 * Make another copy of the Account class. Now replace the transaction list using a simple array. For 
	 * removing elements you need to implement an own remove-method. Let the remove take place by a loop
	 * which renumbers the indices of the array. Fill the array with data (1000 elements) and measure the 
	 * removal of the second element (like in exercise 1) 
	 */
	
	void exercise4() {
		/* YOUR CODE HERE */
	}
	
	
	/** 
	 * exercise 5:
	 * Measure the adding of each element(like in exercise 3)
	 */
	
	void exercise5() {
		/* YOUR CODE HERE */
	}
	
		
	private void runExercises() {
		exercise1();
		exercise2();
		exercise3();
		exercise4();
		exercise5();	
	}
		
	
	public static void main(String[] args) {
		 Lesson3 lesson3 = new Lesson3();
		 lesson3.runExercises();

	}
}
