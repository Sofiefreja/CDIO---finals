package cards;

import entities.Board;
import entities.Player;

/**
 * Abstract class for Card subclasses which changes the position of the player.
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Move extends Card {
	protected int moveTo;
	protected Board board;
	public Move(String description, int moveTo, Board board) {
		super(description);
		this.moveTo = moveTo;
		this.board=board;
	}

	@Override
	public abstract void useCard(Player player);

}
