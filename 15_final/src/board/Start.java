package board;

import controller.GUIControl;
import controller.msgL;
import entities.Player;

/**
 * Class Start extends Square
 * @author Simon Lundorf s154008
 * @author Emily Skovgaard Rasmussen s153374
 *
 */

public class Start extends Square {
	/**
	 * Constructor
	 * @param name
	 * @param id [1:40]
	 */
	public Start(String name, int id) {
		super(name, id);
		
	}

	@Override
	public void landOnSquare(Player player) {
		GUIControl.printMessage(msgL.msg(185));
	}

}
