package entities;

import java.awt.Color;

/**
 * Class which keeps track of the player's position on the board and creates a
 * piece that the player moves with
 * 
 * @author Simon Lundorf s154008
 *
 */

public class Vehicle {

	Color vehicleColor = null;
	static int counter = 0;
	private int currentPosition = 0;
	private int previousPosition = 0;

	/**
	 * Constructor that initializes a vehicle with a counter and a color for a
	 * player
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

		currentPosition = (currentPosition + value) % 40;

		return currentPosition;

	}

	/**
	 * Method for setting a new position of the player's vehicle
	 * 
	 * @param value [0-39]
	 */

	public void setPosition(int value) {
		currentPosition = value;

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
			vehicleColor = Color.orange;
			break;

		case 2:
			vehicleColor = Color.magenta;
			break;

		case 3:
			vehicleColor = Color.pink;
			break;

		case 4:
			vehicleColor = Color.cyan;
			break;

		case 5:
			vehicleColor = Color.black;
			break;

		case 6:
			vehicleColor = Color.GRAY;
			break;

		}

	}

	/**
	 * Method for returning the color of the player's vehicle
	 * 
	 * @return Color of the type Color
	 */

	public Color getColor() {
		return vehicleColor;
	}
}
