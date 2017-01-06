package board;

import entities.Player;
import controller.GUIControl;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */

public class Jail extends Square {

	public Jail(String name, int id) {
		super(name, id);

	}

	@Override
	public void landOnSquare(Player player) {
		GUIControl.jailMessage(player);
		player.setJailStatus(true);
		player.setPosition(10);

	}

}
