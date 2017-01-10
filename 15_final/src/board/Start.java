package board;

import controller.GUIControl;
import controller.msgL;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */

public class Start extends Square {
	/**
	 * Constructor for a Start square
	 * @param name
	 * @param id
	 */
	public Start(String name, int id) {
		super(name, id);
		
	}

	@Override
	public void landOnSquare(Player player) {
		GUIControl.printMessage(msgL.msg(12));
	}

}
