package board;

import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */

public class Start extends Square {

	public Start(String name, int id) {
		super(name, id);
		
	}

	@Override
	public void landOnSquare(Player player) {
		/* GUIControl.startMessage(player); */
	}

}
