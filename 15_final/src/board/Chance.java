package board;

import controller.GUIControl;
import entities.Player;
import entities.AllCards;

/**
 * 
 * Class Chance extends Squar
 *
 */

public class Chance extends Square {

	AllCards allTheCards;
	static int index = 0;
	
	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 * @param allTheCards of the game
	 */
	public Chance(String name, int id, AllCards allTheCards) {
		super(name, id);
		this.allTheCards = allTheCards;
	}

	@Override
	public void landOnSquare(Player player) {
		GUIControl.printMessage(name); // Text "Prøv lykken" is printet.
		String description = allTheCards.getCard(index).toString();
		GUIControl.displayChanceCard(description);
		allTheCards.getCard(index).useCard(player);
		
		if (index == 43) {
			index = 0;
			allTheCards.shuffle();
		} else {
			index++;
		}
	}
}
