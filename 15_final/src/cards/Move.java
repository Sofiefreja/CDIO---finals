package cards;

import entities.Board;
import entities.Player;

/**
 * Skal have en værdi. fx ryk felter.
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Move extends Card{
	protected int moveTo;
	public Move(String description, int moveTo , Board board) {
		super(description,board);
		this.moveTo=moveTo;
	}

	@Override
	public abstract void useCard(Player player);
	
}
