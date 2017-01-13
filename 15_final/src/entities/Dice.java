package entities;
import java.util.Random;
/**
 * Class Dice, for getting random value between 1 and 6.
 *
 */
public class Dice {
	protected int value;
	protected int eyes;
	
	/*
	 * A constructor with a defualt of 6 sides.
	 */
	public Dice(){
		this.eyes=6;
	}
	
	/*
	 * A constructor which makes a dice with n sides.
	 */
	public Dice(int eyes) {
		if (eyes > 0) {
			this.eyes = eyes;
		}
		else{
			this.eyes=6;
		}
	}
	
	/**
	 * Method for rolling the die.
	 * @return value of dice (from 1 to eyes).
	 */
	public int roll() {
		Random dice = new Random();
		int res = dice.nextInt(eyes) + 1;
		value = res;
		return res;
	}
	/**
	 * Method for getting the current value of the dice.
	 * @return value of the dice.
	 */
	public int getValue() {
		return value;
	}
}

