package cards;


/**
 * abstract. amount
 *
 */
public abstract class Transaction extends Card {
	int money;

	/**
	 * Constructor for a Transaction card
	 * 
	 * @param description of the card
	 * @param money to be transferred
	 */
	public Transaction(String description, int money) {
		super(description);
		this.money = money;
	}
}
