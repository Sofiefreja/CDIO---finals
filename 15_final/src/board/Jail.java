package board;

import entities.Player;
import controller.GUIControl;
import controller.msgL;

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
		GUIControl.printMessage(msgL.msg(164));
		player.setJailStatus(true);
		player.setPosition(10,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
	}
}
