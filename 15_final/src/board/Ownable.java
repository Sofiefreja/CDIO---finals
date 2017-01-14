package board;

import entities.Player;
import controller.GUIControl;
import controller.msgL;

/**
 * Abstract class Ownable, extended from Square.
 * Superclass to all ownable subclasses of Square.
 *
 */
public abstract class Ownable extends Square {
	protected int price;
	protected int pawn;
	protected char type;
	protected Player owner;
	protected boolean pawnStatus;

	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 * @param price of this instance
	 * @param pawn price
	 * @param type [A:J]
	 */
	public Ownable(String name, int id, int price, int pawn, char type) {
		super(name, id);
		this.price = price;
		this.pawn = pawn;
		this.type = type;
		this.pawnStatus = false;
	}
	
	@Override
	public void landOnSquare(Player player) {
		if (owner != null) {// if the square is owned, the following happens.
			if (player.toString().equals(owner.toString()) == false) {// if the player is not the owner of
																		// this field, the following happens
				if(owner.getJailStatus()==true){
					GUIControl.printMessage(msgL.msg(127));
				} else if (this.pawnStatus == true) {
					
					GUIControl.printMessage(msgL.msg(188));
					
				}else{
					int amount = getRent();// the rent is calculated, depending on the subclass.
					GUIControl.printMessage(player.toString() + msgL.msg(111) + this.toString() + msgL.msg(112) + owner.toString() 
							+msgL.msg(113) + amount + msgL.msg(119) + msgL.msg(114) + owner.toString());
					player.withdraw(amount);
					owner.deposit(amount);
				}
			} else { //if the player is the owner of this square
				GUIControl.printMessage(msgL.msg(120));
			}
		} else if (player.getBalance() >= this.price) {// if the field is'nt owned and the player
														// has enough money, he has the choice of buying it.
			if (GUIControl.getBuyChoice(this, player) == true) {// if player chooses to buy it, the following happens
				GUIControl.printMessage(msgL.msg(115) + this.toString() + msgL.msg(184) + this.getPrice() + msgL.msg(119));
				player.buySquare(this);
				player.withdraw(this.price);
				owner = player;
				GUIControl.setOwned(this.getID(), player);
			}
		} else {// if the square is not owned but the player can't afford it, a
				// message is printed.
			GUIControl.printMessage(msgL.msg(121) + this.toString());
		}
	}

	/**
	 * Method for getting the rent of the instance this method is called upon.
	 * 
	 * @return rent
	 */
	public abstract int getRent();
	
	/**
	 * Sets pawn status to false and withdraws an amount to the owners Account.
	 */
	public void liftPawn() {
		int amount = pawn+(pawn/10);
		owner.withdraw(amount);
		this.pawnStatus = false;
	}
	
	/**
	 *Sets pawn status to true and deposits the pawn price to the owners Account.
	 */
	public void pawnProperty() {
		owner.deposit(pawn);
		this.pawnStatus = true;
	}
	
	/**
	 * Sets owner to null.
	 */
	public void clearOwner() {
		this.owner = null;
	}
	/**
	 * 
	 * @return boolean value of the pawn status.
	 */
	public boolean getPropertyPawnStatus() {
		return pawnStatus;
	}
	
	/**
	 * 
	 * @return price of this instance
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return the type of this instance.
	 */
	public char getType() {
		return type;
	}
	
	/**
	 * 
	 * @return pawn amount.
	 */
	public int getPawn() {
		return pawn;
	}
	
	/**
	 * Test method for setting the owner
	 * @param player
	 */
	
	public void setOwner(Player player) {
		
		owner = player;
		
	}
	
	/**
	 * Test method for getting the owner
	 * @return Owner of the square of the type Player
	 */
	
	public Player getOwner() {
		
		return owner;
		
	}


}
