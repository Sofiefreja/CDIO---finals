package cards;

import controller.GUIControl;
import controller.msgL;
import entities.Player;

/**
 * Class IncomeIncrease extends Transaction
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class IncomeIncrease extends Transaction {
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param reward
	 */
	public IncomeIncrease(String description, int amount) {
		super(description, amount);
	}

	/**
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
		GUIControl.printMessage(msgL.msg(118)+ money);
		GUIControl.updateBalance(player);
	}
}
