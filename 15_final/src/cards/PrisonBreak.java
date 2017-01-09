package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Class which awards the Player with a 'get out of jail for free card'.
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class PrisonBreak extends Card {

	/**
	 * Constructor for PrisonBreak card
	 * 
	 * @param name
	 * @param board
	 */
	public PrisonBreak(String name) {
		super(name);

	}

	@Override
	public void useCard(Player player) {
		player.setJailCard();
		GUIControl.printMessage("You got a card for getting out of jail");
	}

}
