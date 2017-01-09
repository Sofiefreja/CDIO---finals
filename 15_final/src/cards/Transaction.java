package cards;

import entities.Board;
import entities.Player;

/**
 * abstract. amount
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Transaction extends Card {
	int money;

	/**
	 * Constructor for a Transaction card
	 * 
	 * @param description
	 * @param board
	 * @param money
	 */
	public Transaction(String description, int money) {
		super(description);
		this.money = money;

	}

	@Override
	public abstract void useCard(Player player);

}
