package cards;

import controller.GUIControl;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class Busted extends Move{

	public Busted(String name, int money) {
		super(name, money);
		
	}

	@Override
	public void useCards(Player player) {
		
		GUIControl.bustedMessage(player);
		player.setJailStatus(true);
		player.setPosition(10);
		
	}
	
	
	
}
