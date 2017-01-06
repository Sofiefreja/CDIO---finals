package board;

import entities.Player;
import controller.GUIControl;
/**
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class Tax extends Square {
	private int taxAmount; // amount defined in constructor
	/**
	 * Constructor which accepts two parameters name and taxAmount for this
	 * specific instance.
	 * 
	 * @param name
	 * @param id
	 * @param taxAmount
	 */
	public Tax(String name, int id, int taxAmount) {
		super(name, id);
		this.taxAmount = taxAmount;
	}

	/**
	 * method for getting taxAmount.
	 * 
	 * @return taxAmount
	 */
	public int getTaxAmount() {
		return taxAmount;
	}

	@Override
	public void landOnSquare(Player player) {
				player.withdraw(taxAmount);
				GUIControl.taxMessage(player, taxAmount);
				GUIControl.updateBalance(player);
	}
}
