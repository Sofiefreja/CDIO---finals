package board;

import controller.GUIControl;
import desktop_resources.GUI;
import entities.Player;
import entities.AllCards;

/**
 * 
 * @author Jonas Larsen s136335
 * @author Sofie Freja Christensen s153932
 * @author Morten Velin Christensen s147300
 *
 */

public class Chance extends Square {

	AllCards allTheCards;
	static int index = 0;

	public Chance(String name, int id, AllCards allTheCards) {
		super(name, id);
		this.allTheCards = allTheCards;
	}

	/**
	 * When landing on square, it tells the GUIControl to write out a message.
	 * 
	 * @param player
	 */
	public void landOnSquare(Player player) {

		GUIControl.printMessage(name); // Prøv lykken tekst

		String description = allTheCards.getCard(index).toString();
		GUIControl.displayChanceCard(description);
		GUIControl.updateBalance(player);
		
		allTheCards.getCard(index).useCard(player);
		
		if (index == 43) {
			index = 0;
			allTheCards.shuffle();
		} else {
			index++;
		}

		

	}
}
