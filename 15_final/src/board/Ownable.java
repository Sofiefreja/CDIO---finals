package board;

import entities.Player;
import controller.GUIControl;

/**
 * Abstract class Ownable, extended from Square. Superclass to all ownable types
 * of Square.
 * 
 * @author Mathias Tvaermose Gleerup, s153120
 *
 */
public abstract class Ownable extends Square {
	protected int price;
	protected int pawn;
	protected char type;
	protected Player owner;
	protected boolean pawnStatus;

	/**
	 * Constructor to create an ownable Square
	 * 
	 * @param name
	 * @param id
	 * @param price
	 * @param pawn
	 * @param type
	 */
	public Ownable(String name, int id, int price, int pawn, char type) {
		super(name, id);
		this.price = price;
		this.pawn = pawn;
		this.type = type;
		this.pawnStatus = false;
	}

	// Implements the inherited method landOnSquare, to be overridden for each
	// type with a different getRent() method.
	@Override
	public void landOnSquare(Player player) {
		if (owner != null) {// if the square is owned, the following happens.
			if (player.toString().equals(owner.toString()) == false) {// if the player is not the owner of
																		// this field, the following happens
				if(owner.getJailStatus()==true){
					GUIControl.printMessage(msgL.msg(127));
				} else if (this.pawnStatus == true) {
					
					GUIControl.printMessage("Denne grund er pantsat. Du skal ikke betale leje");
					
				}else{
					int amount = getRent();// the rent is calculated, depending on the subclass.
					GUIControl.ownedMessage(this, player, owner, amount);// a message is printed to the player about the sequence.
					player.withdraw(amount);
					owner.deposit(amount);
					GUIControl.updateBalance(player);
					GUIControl.updateBalance(owner);
				}
			} else { //if the player is the owner of this square
				GUIControl.printMessage(msgL.msg(120));
			}
		} else if (player.getBalance() >= this.price) {// if the field is'nt owned and the player
														// has enough money, he has the choice of buying it.
			if (GUIControl.getBuyChoice(this, player) == true) {// if player chooses to buy it, the following happens
				player.buySquare(this);
				player.withdraw(this.price);
				owner = player;
				GUIControl.updateBalance(player);
				GUIControl.setOwned(this.getID(), player);
				GUIControl.buyMessage(this, player);
			}
		} else {// if the square is not owned but the player can't afford it, a
				// message is printed.
			GUIControl.notEnoughMoney(this);
		}
	}

	/**
	 * Method for getting the rent of this instance.
	 * 
	 * @return rent.
	 */
	public abstract int getRent();

	/**
	 * Method for returning the price of this instance.
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Method for returning the pawn amount.
	 * 
	 * @return pawn
	 */
	
	public int getPawn() {
		return pawn;
	}
	
	public void pawnProperty() {
		
		owner.deposit(pawn);
		this.pawnStatus = true;
		GUIControl.updateBalance(owner);
		
	}
	
	public void liftPawn() {
		
		int amount = pawn+(pawn/10);
		owner.withdraw(amount);
		this.pawnStatus = false;
		GUIControl.updateBalance(owner);
		
	}
	
	public boolean getPropertyPawnStatus() {
		
		return pawnStatus;
		
	}
	
	/**
	 * Method for returning the type of this square, as a char
	 * @return type
	 */
	public char getType() {
		return type;
	}

	/**
	 * Method for clearing the owner field of this instance.
	 */
	public void clearOwner() {
		this.owner = null;
	}

}
