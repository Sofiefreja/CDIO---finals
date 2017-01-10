package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Class which awards the Player with a 'get out of jail for free card'.
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class Pardon extends Card {

	/**
	 * Constructor for PrisonBreak card
	 * 
	 * @param description
	 * @param board
	 */
	public Pardon(String description) {
		super(description);

	}

	@Override
	public void useCard(Player player) {
		player.setJailCard();
		GUIControl.printMessage(description);
	}

}