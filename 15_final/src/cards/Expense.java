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
 * @param name
 * @param withdrawal
 */
	public Expense(String name, int withdrawal) {
		this.name= name;
		this.withdrawal= withdrawal;
	}
	/**
	 * Method for retrieving the withdrawal amount.
	 * @return reward
	 */
	public int payWithdrawal() {
		return withdrawal;
	}
	/**
	 * Player pays the expense, and balance is updated.
	 * @param player
	 */
	public void useCard(Player player) {
		player.pay(withdrawal);
		GUIControl.expenseMessage(player, withdrawal);
		GUIControl.updateBalance(player);
}

}
