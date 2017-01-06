package cards;

import entities.Player;

/**
 * Skal have en værdi. fx ryk felter.
 * @author Sofie Freja Christensen s153932
 *
 */
public class Move extends Card{

	public Move(String name, int money) {
		super(name, money);
	}

	@Override
	public void useCards(Player player) {
		
	}

}
