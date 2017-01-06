package cards;

import controller.GUIControl;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class Busted extends Move{

	public Busted(String name) {
		super(name);
	}

	@Override
	public void useCard(Player player) {		
		GUIControl.printMessage("Go straight to jail");
		player.setJailStatus(true);
		player.setPosition(10);
		
	}
	
	
	
}
