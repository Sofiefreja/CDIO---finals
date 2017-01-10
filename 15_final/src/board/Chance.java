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

public class Chance extends Square{
	
	AllCards allTheCards;

	public Chance(String name, int id, AllCards allTheCards){
			super(name, id);
			this.allTheCards = allTheCards;
		}
		/**
		 * When landing on square, it tells the GUIControl to write out a message.
		 * @param player
		 */
		public void landOnSquare(Player player){
			GUIControl.printMessage(name);
			
			String description = allTheCards.getCard(1).toString();
			GUIControl.displayChanceCard(description);
			
			
			
			
	}
}
