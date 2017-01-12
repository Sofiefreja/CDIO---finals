package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Class GoToJail extends Move
 * @author Simon Lundorf s154008
 * @author Emily Skovgaard Rasmussen s153374
 *
 */
public class GoToJail extends Move{
	/**
	 * Constructor for GoToJail card.
	 * 	
	 * @param description of the card
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
