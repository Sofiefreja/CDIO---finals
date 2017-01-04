package entities;

import java.awt.Color;

public class Vehicle {

	Color carColor = null;
	static int counter = 0;
	private int currentPosition = 1;
	private int previousPosition = 1;

	/**
	 * Constructor that initializes a vehicle with a counter for a player
	 */

	public Vehicle() {

		counter++;
		setColor();

	}

	/**
	 * Method for calculating and returning the new position of a player's
	 * vehicle while also saving the previous position
	 * 
	 * @param value
	 * @return The new position of the player's vehicle of the type integer
	 */

	public int move(int value) {

		previousPosition = currentPosition;

		currentPosition = (currentPosition + value) % 21;

		return currentPosition;

	}

	/**
	 * Method for setting a new position of the player's vehicle
	 * 
	 * @param value
	 */

	public void setPosition(int value) {
		currentPosition = value;
		previousPosition = value;

	}

	/**
	 * Method for getting the previous position of a player's vehicle
	 * 
	 * @return The previous position of the player vehicle, of the type integer
	 */

	public int getPreviousPosition() {
		return previousPosition;
	}

	/**
	 * Method for getting the current position of a player's vehicle
	 * 
	 * @return The current position of the player vehicle, of the type integer
	 */

	public int getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Method for deciding the color of a player's vehicle, depending on number
	 * of players
	 * 
	 * @return The color of a player's vehicle of the type color
	 */
	private void setColor() {
		switch (counter) {
		case 1:
			carColor = Color.orange;
			break;

		case 2:
			carColor = Color.magenta;
			break;

		case 3:
			carColor = Color.pink;
			break;

		case 4:
			carColor = Color.cyan;
			break;

		case 5:
			carColor = Color.black;
			break;

		case 6:
			carColor = Color.GRAY;
			break;

		}

	}

	public Color getColor() {
		return carColor;
	}
}
