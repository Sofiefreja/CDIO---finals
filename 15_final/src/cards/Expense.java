package cards;

import controller.GUIControl;
import controller.msgL;
import entities.Player;

/**
 * Class Expense extends Transaction
 *
 */
public class Expense extends Transaction {
	/**
	 * Constructor which accepts two parameters name and withdrawal for this
	 * specific instance.
	 * 
	 * @param description of the card
	 * @param money to be withdrawed
	 */
	public Expense(String description, int money) {
		super(description, money);
	}

	/**
	 * Method for retrieving the withdrawal amount.
	 * 
	 * @return reward
	 */
	public int payMoney() {
		return money;
	}

	/**
	 * Player pays the expense, and balance is updated.
	 * 
	 * @param player to use the card
	 */
	public void useCard(Player player) {
		player.withdraw(money);
		GUIControl.printMessage(player+msgL.msg(113)+ money);
	}

}
