package entities;

import java.awt.Color;

import java.util.*;

import board.Ownable;
import board.Street;
import controller.GUIControl;

/**
 * 
 * @author Simon Lundorf s154008
 *
 */

public class Player {

	private String name;
	private Account balance = new Account();
	private Vehicle vehicle;
	private Assets assets = new Assets(this);
	private int jailCounter;
	private boolean jailStatus;
	private boolean firstRound=true;

	/**
	 * Constructor for a Player, that initiates the player with an account balance, a vehicle, a jail status and a jail counter
	 * 
	 * @param name String with the player name
	 * @param balance Int with the player's starting balance
	 */
	public Player(String name, int balance) {
		this.name = name;
		this.balance.deposit(balance);
		vehicle = new Vehicle();
		jailStatus = false;
		jailCounter = 0;

	}

	/**
	 * Method for getting an integer array of the ID of the Ownable Squares this
	 * player owns.
	 * 
	 * @return
	 */
	public int[] getOwnedID() {
		return assets.getOwnedID();
	}

	public ArrayList<Street> getOwnedStreet() {

		return assets.getOwnedStreet();

	}
	
	/**
	 * Method for buying a Ownable Square.
	 * 
	 * @param square
	 */
	public void buySquare(Ownable square) {
		assets.buySquare(square);
	}

	/**
	 * Method for adding to this players jailCounter.
	 */
	public void addToJailCounter() {
		jailCounter++;
	}

	/**
	 * Method for resetting this players jailCounter.
	 */
	public void resetJailCounter() {
		jailCounter = 0;
	}

	/**
	 * getter method for the players jailCounter.
	 * 
	 * @return
	 */
	public int getJailCounter() {
		return jailCounter;
	}
	public void setFirstRound(boolean b){
		firstRound=b;
	}
	public boolean getFirstRound(){
		return firstRound;
	}
	/**
	 * Method for returning and ArrayList of the squares this player owns.
	 * 
	 * @return ArrayList<Ownable>
	 */
	public ArrayList<Ownable> getOwned() {
		return assets.getOwned();
	}

	/**
	 * Method for setting the jail status of a player
	 * 
	 * @param jailStatus
	 */
	public void setJailStatus(boolean jailStatus) {
		this.jailStatus = jailStatus;
	}

	/**
	 * Method for checking the jail status of a player
	 * 
	 * @return Boolean value true or false depending on the jail status of the
	 *         player
	 */
	public boolean getJailStatus() {
		return jailStatus;
	}

	/**
	 * Method that returns whether or not the player has a get out of jail free
	 * card
	 * 
	 * @return Boolean value true or false depending on whether the player has a
	 *         card
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
	 * 
	 * @return Player name of the type string
	 */
	public String toString() {
		return name;
	}

	/**
	 * Method for depositing an amount from the player account
	 * 
	 * @param amount
	 */
	public void deposit(int amount) {
		balance.deposit(amount);
		GUIControl.updateBalance(this);
	}

	/**
	 * Method for withdrawing an amount from the player account
	 * 
	 * @param amount
	 */
	public void withdraw(int amount) {
		balance.withdraw(amount);
		GUIControl.updateBalance(this);;
	}

	/**
	 * Method for getting the current account balance of a player
	 * 
	 * @return Account balance of the type integer
	 */
	public int getBalance() {
		return balance.getBalance();
	}

	/**
	 * Method for calculating where the player's vehicle lands after rolling the
	 * dice
	 * 
	 * @param roll
	 */
	public void moveVehicle(int roll) {
		vehicle.move(roll);
	}

	/**
	 * Method for getting the previous position of the player's vehicle
	 * 
	 * @return Previous player position of the type integer
	 */
	public int getPreviousPosition() {
		return vehicle.getPreviousPosition();
	}

	/**
	 * Method for getting the current position of the player's vehicle
	 * 
	 * @return Player position of the type integer
	 */
	public int getCurrentPosition() {
		return vehicle.getCurrentPosition();
	}

	/**
	 * Method for setting the position of the player's vehicle
	 * 
	 * @param currentPosition Type: int
	 * @param previousPosition Type: int
	 */
	public void setPosition(int currentPosition,int previousPosition) {
		vehicle.setPosition(currentPosition,previousPosition);
	}

	/**
	 * Method for generating a color used by the
	 * 
	 * @return A color of the type Color
	 */
	public Color getColor() {
		return vehicle.getColor();
	}

	/**
	 * Returns a list of the names of the properties owned by this player.
	 * 
	 * @return String ArrayList
	 */
	public ArrayList<String> getPropertyList() {

		return assets.getPropertyList();

	}

	/**
	 * Method for getting a list of the properties with houses built on them.
	 * 
	 * @return String[]
	 */
	public String[] getHouseList() {
		return assets.getHouseList();
	}

	/**
	 * Method for getting a list of the properties with hotels built on them.
	 * 
	 * @return String []
	 */
	public String[] getHotelList() {
		return assets.getHotelList();
	}

	/**
	 * Returns a boolean value of whether the player owns a building
	 * @return boolean
	 */
	public boolean getBuilding() {
		return assets.getBuilding();
	}

	/**
	 * Returns a boolean value of whether the player owns a property or not.
	 * @return
	 */
	public boolean getProperty() {

		return assets.getProperty();

	}
	/**
	 * Method for buying houses on a Street.
	 * @param street
	 * @param amount
	 */
	public void buyHouses(Street street, int amount) {

		assets.buyHouses(street, amount);

	}
	/**
	 * Method for removing houses on a Street
	 * @param street
	 * @param amount
	 */
	public void removeHouses(Street street, int amount) {

		assets.removeHouses(street, amount);

	}
	/**
	 * Method for getting a boolean value of whether the player can build houses
	 * @return
	 */
	public boolean getBuildStatus() {

		return assets.getBuildStatus();

	}
	/**
	 * Returns a string array of streets which can be built on.
	 * @return
	 */
	public String[] getBuildableList() {
		return assets.getBuildableList();
	}

	public String[] getSellableList() {
		
		return assets.getSellableList();
		
	}
	
	public boolean getPawnStatus() {
		
		return assets.getPawnStatus();
		
	}
	
	public String[] getPawnable() {
		
		return assets.getPawnable();
		
	}
	
	public void pawnProperty(Ownable ownable) {
		
		assets.pawnProperty(ownable);
	}
	
	public void liftPawn(Ownable ownable) {
		
		assets.liftPawn(ownable);
		
	}
	
	public String[] getPawned() {
		
		return assets.getPawned();
		
	}
	
	public boolean getHasPawned() {
		
		return assets.getHasPawned();
		
	}
	
}
