package entities;

import java.awt.Color;

import java.util.*;

import board.Ownable;
import board.Street;

/**
 * 
 * @author Simon Lundorf s154008
 *
 */

public class Player {

	private String name;
	private Account balance = new Account();
	private Vehicle vehicle;
	private Assets assets = new Assets();
	private int jailCounter;
	private boolean jailStatus;
	
/**
 * 
 * @param name
 * @param balance
 */
	
	public Player(String name, int balance){
		this.name=name;
		this.balance.deposit(balance);
		vehicle=new Vehicle();
		jailStatus = false;
		jailCounter = 0;	
		
	}
	
	public int[] getOwnedID() {
		return assets.getOwnedID();
	}
	
	public void buySquare(Ownable square) {
		assets.buySquare(square);
	}
	
	public void addToJailCounter() {
		jailCounter++;
	}
	
	public void resetJailCounter() {
		jailCounter=0;
	}
	
	public int getJailCounter() {
		return jailCounter;
	}
	
	/**
	 * Method for 
	 * @return
	 */
	
	public ArrayList <Ownable> getOwned() {
		return assets.getOwned();
	}
	
	/**
	 * Method for setting the jail status of a player
	 * @param jailStatus
	 */
	
	public void setJailStatus(boolean jailStatus) {
		this.jailStatus = jailStatus;
	}
	
	/**
	 * Method for checking the jail status of a player
	 * @return Boolean value true or false depending on the jail status of the player
	 */
	
	public boolean getJailStatus() {
		return jailStatus;
	}
	
	/**
	 * Method that returns whether or not the player has a get out of jail free card
	 * @return Boolean value true or false depending on whether the player has a card
	 */
	
	public boolean getJailCard() {
		return assets.getJailCard();
	}
	
	/**
	 * Method for using a get out of jail free card
	 */
	
	public void useJailCard() {
		assets.useJailCard();
	}
	
	/**
	 * Method for receiving a get out of jail free card
	 */
	
	public void setJailCard() {
		assets.setJailCard();
	}
		
	/**
	 * Method for returning the name of the player
	 * @return Player name of the type string
	 */
	
	public String toString() {
		return name;
	}
	
	/**
	 * Method for depositing an amount from the player account
	 * @param amount
	 */
	
	public void deposit(int amount) {
		balance.deposit(amount);
	}
	
	/**
	 * Method for withdrawing an amount from the player account
	 * @param amount
	 */
	
	public void withdraw(int amount) {
		balance.withdraw(amount);
	}
	
	/**
	 * Method for getting the current account balance of a player
	 * @return Account balance of the type integer
	 */
	
	public int getBalance() {
		return balance.getBalance();
	}
	
	/**
	 * Method for calculating where the player's vehicle lands after rolling the dice
	 * @param roll
	 */
	
	public void moveVehicle(int roll) {
		vehicle.move(roll);
	}
	
	/**
	 * Method for getting the previous position of the player's vehicle
	 * @return Previous player position of the type integer
	 */
	
	public int getPreviousPosition() {
		return vehicle.getPreviousPosition();
	}
	
	/**
	 * Method for getting the current position of the player's vehicle
	 * @return Player position of the type integer
	 */
	
	public int getCurrentPosition() {
		return vehicle.getCurrentPosition();
	}
	
	/**
	 * Method for setting the position of the player's vehicle
	 * @param position
	 */
	
	public void setPosition(int position) {
		vehicle.setPosition(position);
	}
	
	/**
	 * Method for generating a color used by the 
	 * @return A color of the type Color
	 */
	
	public Color getColor() {
		return vehicle.getColor();
	}
	
	public ArrayList<String> getPropertyList() {
		
		return assets.getPropertyList();
		
	}
	
	public String[] getHouseList() {
		
		return assets.getHouseList();
		
	}
	
	public String[] getHotelList() {
		
		return assets.getHotelList();
		
	}
	
	public boolean getBuilding() {
		
		return assets.getBuilding();
		
	}
	
	public boolean getProperty() {
		
		return assets.getProperty();
		
	}
	
	public void buyHouses(Street street, int amount) {
		
		assets.buyHouses(street, amount);
		
	}
	
	public void removeHouses(Street street, int amount) {
		
		assets.removeHouses(street, amount);
		
	}
	
	public boolean getBuildStatus() {
		
		return assets.getBuildStatus();
		
	}
	
}
