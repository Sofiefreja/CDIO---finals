package cards;

import controller.GUIControl;
import controller.msgL;
import entities.Board;
import entities.Player;

/**
 * Bank gives money, receive a player in all
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class IncomeIncrease extends Transaction {
	/**
	 * Constructor which accepts two parameters name and reward for this
	 * specific instance.
	 * 
	 * @param name
	 * @param reward
	 */
	public IncomeIncrease(String description, int amount) {
		super(description, amount);
	}

	/**
	 * Method for calculating amount
	 * 
	 * @return pay amount
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Player receives award, and balance is updated.
	 * 
	 * @param player
	 */
	public void useCard(Player player) {
		player.deposit(money);
		GUIControl.printMessage(msgL.msg(112)+ money);
		GUIControl.updateBalance(player);
	}
}
