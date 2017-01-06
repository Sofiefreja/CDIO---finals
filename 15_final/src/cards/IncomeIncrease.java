package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Bank gives money, receive a player in all
 * @author Sofie Freja Christensen s153932
 *
 */
public class IncomeIncrease extends Transaction {
	private int reward;
	/**
	 * Constructor which accepts two parameters name and reward for this
	 * specific instance.
	 * @param name
	 * @param reward
	 */
	public IncomeIncrease(String name, int reward) {
		this.name= name;
		this.reward= reward;
	}
	/**
	 * Method for retrieving the reward.
	 * @return reward
	 */
	public int getReward() {
		return reward;
	}
	/**
	 * Player receives award, and balance is updated.
	 * @param player
	 */
	public void useCard(Player player) {
		player.deposit(reward);
		GUIControl.incomeIncreaseMessage(player, reward);
		GUIControl.updateBalance(player);
}
}
