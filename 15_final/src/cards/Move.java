package cards;

import entities.Player;

/**
 * Skal have en værdi. fx ryk felter.
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Move extends Card{

	public Move(String description) {
		super(description);
	}

	@Override
	public abstract void useCard(Player player);
}
