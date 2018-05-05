package p01;
/**
 * Lesson 2 - A simple bookkeeping program
 * Use of ArrayList, one to many associations, FileIO, organizing data storage 
 * @author steppat
 *
 */

public class Lesson2 {

	/**
	 * exercise 1:
	 * Create a class with the name "Transaction". The class contains the following properties:
	 * 
	 * int nr;    		// number of transaction
	 * Date date; 		// transaction date
	 
	   int debit;
	   int credit;
	 
	 * String text;		// transaction text
	 * double amount; 	// amount of the transaction
	 * 
	 * Implement a constructor to set all the properties at instantiation.
	 * Create getters to recall the values.
	 * Overwrite the toString-method to print out the property values
	 * Instantiate a couple of objects and test them by calling toString.
	 * Make the declaration of the objects outside the method. We need them in further exercises.
	 * Print the results on the console. 
	 * 
	 */
	
	void exercise1() {
		 /* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 2:
	 * Create a second class with name "Account". This class contains:
	 * 
	 * int nr; 								// account nr
	 * String id;							// identifier of the account
	 * HashMap<Integer, Integer> transaction;	// list with all transactions due to the account
	 * 
	 * There also some methods we need:
	 * 
	 * 1. a constructor which takes nr and id
	 * 2. the method "addTransaction" which takes a Transaction object as a parameter
	 * 3. getters for nr, identifier, specific transaction and one to return the balance
	 * 
	 * Create three Account objects  e.g. cash, sales, supplies (reference them also as members)
	 * "Feed" them with some transactions
	 * Choose one object and test all the getters
	 * Test the amount of all three accounts  
	 */
		
	void exercise2() {
		 /* YOUR CODE HERE */
	}
	
	
	
		
	/** 
	 * exercise 3:
	 * Let's create a third class (definitely the last :) called "Journal"
	 * A journal has a list of accounts. The user can add and delete accounts and making
	 * transactions with the method doTransaction. This method takes the following parameters:
	 * 
	 * int nr;
	 * Date date;
	 * int debit;
	 * int credit;
	 * String text;
	 * double amount;
	 * 
	 * We  also need a getter for specific transactions which takes the transaction number as a parameter.
	 * 
	 * Instantiate the class, do some transactions and print out the results on the console.
	 *   
	 */
	
	void exercise3() {
		 /* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 4:
	 * Add a method to save the journal in a file. Use a hard-coded value for the file path first. We will
	 * fix it in the next exercise. The format should be table like, columns separated by tabs and each entry 
	 * in a new line. This format is similar to the csv file format.
	 */
	
	void exercise4() {
		/* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 5:
	 * Add a console based dialog to the save method, which enables the user to choose a filename and the path 
	 */
	
	void exercise5() {
		/* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 6:
	 * At last allow the user to load a journal and print the entries on the console.
	 */
	
	void exercise6() {
		/* YOUR CODE HERE */
	}
	
	private void runExercises() {
		exercise1();
		exercise2();
		exercise3();
		exercise4();
		exercise5();
		exercise6();
	}
		
	
	public static void main(String[] args) {
		 Lesson2 lesson2 = new Lesson2();
		 lesson2.runExercises();

	}
}
