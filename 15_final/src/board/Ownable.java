package board;

import entities.Player;
import controller.GUIControl;
import controller.msgL;

/**
 * Abstract class Ownable, extended from Square.
 * Superclass to all ownable subclasses of Square.
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
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 * @param price of this instance
	 * @param pawn price of this instance
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
				GUIControl.setOwned(this.getID(), player);
				GUIControl.buyMessage(this, player);
				GUIControl.updateBalance(player);
			}
		} else {// if the square is not owned but the player can't afford it, a
				// message is printed.
			GUIControl.notEnoughMoney(this);
		}
	}

	/**
	 * Method for getting the rent of the instance this method is called upon.
	 * 
	 * @return rent
	 */
	public abstract int getRent();
	
	public void clearOwner() {
		this.owner = null;
	}
	
	public void pawnProperty() {
		owner.deposit(pawn);
		this.pawnStatus = true;
	}
	
	public void liftPawn() {
		int amount = pawn+(pawn/10);
		owner.withdraw(amount);
		this.pawnStatus = false;
	}
	
	public boolean getPropertyPawnStatus() {
		return pawnStatus;
	}

	public int getPrice() {
		return price;
	}
	
	public char getType() {
		return type;
	}
	
	public int getPawn() {
		return pawn;
	}


}
