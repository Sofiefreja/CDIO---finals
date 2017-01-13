package cards;

import controller.GUIControl;
import controller.msgL;
import entities.Player;

/**
 * Class IncomeIncrease extends Transaction
 *
 */
public class IncomeIncrease extends Transaction {
	/**
	 * Constructor
	 * 
	 * @param description of the card
	 * @param amount to be rewarded.
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
	 * @param player to use the card
	 */
	public void useCard(Player player) {
		player.deposit(money);
		GUIControl.printMessage(msgL.msg(118)+ money);
		GUIControl.updateBalance(player);
	}
}
