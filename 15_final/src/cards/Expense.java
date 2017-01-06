package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Withdraw xx from the player
 * @author Sofie Freja Christesen s153932
 *
 */
public class Expense extends Transaction{
	private int withdrawal;
/**
 * Constructor which accepts two parameters name and withdrawal for this
 * specific instance.
 * @param description
 * @param withdrawal
 */
	public Expense(String description, int money) {
		super(description,money);
	}
	/**
	 * Method for retrieving the withdrawal amount.
	 * @return reward
	 */
	public int payMoney() {
		return money;
	}
	/**
	 * Player pays the expense, and balance is updated.
	 * @param player
	 */
	public void useCard(Player player) {
		player.withdraw(money);
		GUIControl.expenseMessage(player, money);
		GUIControl.updateBalance(player);
}

}
