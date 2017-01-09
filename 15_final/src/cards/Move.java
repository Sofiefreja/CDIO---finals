package cards;


/**
 * Abstract class for Card subclasses which changes the position of the player.
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Move extends Card {
	protected int moveTo;
	public Move(String description, int moveTo) {
		super(description);
		this.moveTo = moveTo;
	}
}
