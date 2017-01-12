package board;

import controller.GUIControl;
import entities.Player;
import entities.AllCards;

/**
 * 
 * Class Chance extends Square
 * @author Jonas Larsen s136335
 * @author Sofie Freja Christensen s153932
 * @author Morten Velin Christensen s147300
 *
 */

public class Chance extends Square {

	AllCards allTheCards;
	static int index = 0;
	
	/**
	 * Constructor
	 * @param Name of this instance
	 * @param id [1:40]
	 * @param Instance of AllCards
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
