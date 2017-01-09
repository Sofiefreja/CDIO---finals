package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class GoToJail extends Move{
	/**
	 * Constructor for Busted card.
	 * 	
	 * @param name
	 * @param board
	 */
	 public GoToJail(String description) {
	 super(description,10);
	}

	@Override
	public void useCard(Player player) {		
		GUIControl.printMessage(description);
		player.setJailStatus(true);
		player.setPosition(10,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
	}
	
	
	
}
