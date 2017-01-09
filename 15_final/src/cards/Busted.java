package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class Busted extends Move{
	/**
	 * Constructor for Busted card.
	 * 	
	 * @param name
	 * @param board
	 */
	 public Busted(String description ,Board board) {
	 super(description,10,board);
	}

	@Override
	public void useCard(Player player) {		
		GUIControl.printMessage(description);
		player.setJailStatus(true);
		player.setPosition(moveTo);
		GUIControl.moveVehicle(player);
	}
	
	
	
}
