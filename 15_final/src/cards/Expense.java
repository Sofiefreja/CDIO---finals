package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * Class for creating a card which withdraws a spicific amount from the players account.
 * 
 * @author Sofie Freja Christesen s153932
 *
 */
public class Expense extends Transaction {
	/**
	 * Constructor which accepts two parameters name and withdrawal for this
	 * specific instance.
	 * 
	 * @param description
	 * @param withdrawal
	 */
	public Expense(String description, int money, Board board) {
		super(description, board, money);
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
	 * @param player
	 */
	public void useCard(Player player) {
		player.withdraw(money);
		GUIControl.printMessage("you pay " + money);
		GUIControl.updateBalance(player);
	}

}
