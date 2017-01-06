package cards;

import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class PrisonBreak extends Card{

	public PrisonBreak(String name) {
		super(name);
		
	}

	@Override
	public void useCards(Player player) {
		player.setJailCard();
		
	}

}
