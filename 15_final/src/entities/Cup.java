package entities;

/**
 * Class Cup, for operating two Die at once.
 * 
 * @author Mathias Tværmose Gleerup
 *
 */
public class Cup {
	private Dice d1 = new Dice(); // initiating dices to use in the cup.
	private Dice d2 = new Dice();

	/**
	 * Method for rolling the dices
	 * 
	 * @return sum of the two dices
	 */
	public int roll() {
		return d1.roll() + d2.roll();

	}

	/**
	 * Method for getting the result of the roll.
	 * 
	 * @return sum of the two dices.
	 */
	public int getSum() {
		return d1.getValue() + d2.getValue();
	}

	/**
	 * Method for identifying if the two die show the same value.
	 * 
	 * @return true if the two dices shows the same eyes.
	 */
	public boolean getEquals() {
		boolean res = false;
		if (d1.getValue() == d2.getValue()) {
			res = true;
		}
		return res;
	}

	/**
	 * Method for getting the value of dice 1.
	 * 
	 * @return value of dice 1.
	 */
	public int getD1() {
		return d1.getValue();
	}

	/**
	 * Method for getting the value of dice 2.
	 * 
	 * @return value of dice 2.
	 */
	public int getD2() {
		return d2.getValue();
	}
}
