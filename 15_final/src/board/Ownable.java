package board;

import entities.Player;
import controller.GUIControl;

/**
 * Abstract class Ownable, extended from Square. Superclass to all ownable types
 * of Square.
 * 
 * @author Mathias Tværmose Gleerup
 *
 */
public abstract class Ownable extends Square {
	/**
	 * Adds a field Player and int for all ownable squares.
	 */
	protected int price;
	protected int pawn;
	protected Player owner;
	

	/**
	 * Constructor which takes a name and a price of the square as parameters.
	 * 
	 * @param name
	 * @param id
	 * @param price
	 * @param pawn
	 */
	public Ownable(String name, int id, int price, int pawn) {
		super(name, id);
		this.price = price;
		this.pawn = pawn;
	}

	/**
	 * Method for getting the rent of this instance.
	 * 
	 * @return rent.
	 */
	public abstract int getRent();
	
	/**
	 * Method for returning the price of this instance.
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Method for returning the pawn amount.
	 * @return pawn
	 */
	public int getPawn(){
		return pawn;
	}

	/**
	 * Method for clearing the owner field of this instance.
	 */
	public void clearOwner() {
		this.owner = null;
	}

	
	//Implements the inherited method landOnSquare, to be overridden for each type with a different getRent() method.
	@Override
	public void landOnSquare(Player player) {
		if (owner != null) {//if the square is owned, the following happens.
			if(player.toString().equals(owner.toString())==false){//if the player is not the owner of this field, the following happens
			int amount = getRent();//the rent is calculated, depending on the subclass.
			GUIControl.ownedMessage(this, player, owner, amount);//a message is printed to the player about the sequence.
			player.pay(amount);
			owner.deposit(amount);
			GUIControl.updateBalance(player);
			GUIControl.updateBalance(owner);
			}else{//if the 
				GUIControl.selfOwned(); // prints "You are the owner of this square!"
			}
		}else if(player.getBalance()>=this.price){// if the field isnt owned and the player has enough money, he has the choice of buying it.
			if (GUIControl.getBuyChoice(this,player) == true) {//if player chooses to buy it, the following happens
				GUIControl.buyMessage(this, player);
				player.bought(this);
				player.pay(this.price);
				owner = player;
				GUIControl.updateBalance(player);
				GUIControl.setOwned(this.getID(),player);
				}
		}else{//if the square is not owned but the player can't afford it, a message is printed.
			GUIControl.notEnoughMoney(this);
		}
	}
}
