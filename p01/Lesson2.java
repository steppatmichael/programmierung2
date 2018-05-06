package p01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	 * int debit;		// debit account number
	 * int credit;		// credit account number
	 * String text;		// transaction text
	 * double amount; 	// amount of the transaction
	 * 
	 * Implement a constructor to set all the properties at instantiation.
	 * Create getters to recall the values.
	 * Overwrite the toString-method to print out the property values in the csv format
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
	 * int nr; 							// account nr
	 * String id;						// identifier of the account
	 * double balance					// balance of the account
	 * 
	 * There also some methods we need:
	 * 
	 * 1. a constructor which takes nr and id
	 * 2. the methods "add" and "subract" to increase or decrease the balance
	 * 3. getters for nr, identifier and one to return the balance
	 * 
	 * Create three Account objects: cash (2880), bank (2800) and supplies (2200) 
	 * reference them also as members
	 * "Feed" them with some transactions like the following:
	 * A shop owner takes 300 $ from his bank account, buys goods for 200 $ and sells some
	 * goods for 100 $. Before he took the money from the bank account there was a balance of
	 * 1000 $. (You can set the star balance in the account using the add method.)
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
	 * The method adds the transaction to an Array. Use the following:
	 * 	 ArrayList<Transaction> transaction = new ArrayList<>();
	 * and do the addition like:
	 *   Transaction transaction = new Transaction(nr, date, debit, credit, text, amount);
	 *   this.transaction.add(transaction);
	 * Further it is increasing the debit account:	
	 *	 account.get(debit).add(amount);	
	 * and decreasing the credit account:	
	 *	 account.get(credit).subtract(amount);
	 *
	 * To store the account we declare a HashMap: 
	 *   Map<Integer, Account> account = new HashMap<Integer, Account>();   
	 * We  also need a getter for the transaction Array 
	 * 
	 * Instantiate the class, do some transactions and print out the results on the console.
	 * Transaction
	 *   
	 */
	
	void exercise3() {
		 /* YOUR CODE HERE */
	}
	
	
	/**
	 * exercise 4:
	 * Add a method to save the journal in a file. Use a hard-coded value for the file path first. We will
	 * fix it in the next exercise. The format should be table like, columns separated by tabs and each entry 
	 * in a new line. This format is similar to the csv file format. Save only the transactions. The
	 * balances of accounts will be recalculated, when the file is loaded again. Take the toString method
	 * from Transaction to save each line.
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
	 * At last allow the user to load a journal and print the entries on the console. Add an
	 * overloaded constructor to Transaction with following signature:
	 *   Transaction(String csvLine)
	 * The parameter is a line of a csv file. Use the split method to separate the columns:
	 *   String[] split_s = csvLine.split("\t");
	 * The calculation of the account balances will be discussed and implemented in the next unit.
	 * So you need not to implement them yet.  
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
