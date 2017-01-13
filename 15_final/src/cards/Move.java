package cards;


/**
 * Abstract class for Card subclasses which changes the position of the player.
 *
 */
public abstract class Move extends Card {
	protected int moveTo;
	
	/**
	 * Constructor
	 * @param description of the cards
	 * @param moveTo a number
	 */
	public Move(String description, int moveTo) {
		super(description);
		this.moveTo = moveTo;
	}
}
