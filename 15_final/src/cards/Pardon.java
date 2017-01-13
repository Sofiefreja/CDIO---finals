package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Class which awards the Player with a 'get out of jail for free card'.
 *
 */
public class Pardon extends Card {

	/**
	 * Constructor for PrisonBreak card
	 * 
	 * @param description of the card
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
