package entities;
/**
 * Class for creating an Account, which keeps track of a players balance.
 * 
 * @author Simon Lundorf
 *
 */
public class Account {

	private int balance;

	/**
	 * Constructor the initializes the player's account with a balance of 0
	 */

	public Account() {
		balance = 0;
	}

	/**
	 * Method for depositing money into a player's account
	 * 
	 * @param value
	 */

	public void deposit(int value) {
		if (value > 0) {
			balance += value;
		}
	}

	/**
	 * Method for withdrawing money from a player's account
	 * 
	 * @param value
	 */

	public void withdraw(int value) {
		if (value > 0) {
			balance -= value;
		}
	}

	/**
	 * Method for checking the amount on a player's account balance
	 * 
	 * @return The amount of money on an account, of the type integer
	 */

	public int getBalance() {
		return balance;
	}

}
