package board;

import entities.Player;
import controller.GUIControl;
import controller.msgL;

/**
 * Class Jail extends Square
 *
 */

public class Jail extends Square {
	
	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 */
	public Jail(String name, int id) {
		super(name, id);
	}
	
	@Override
	public void landOnSquare(Player player) {
		if(player.getJailCard()== false){
		GUIControl.printMessage(msgL.msg(164));
		player.setJailStatus(true);
		player.setPosition(10,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
		} else {
			GUIControl.printMessage(msgL.msg(187));
			player.setPosition(10,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			player.useJailCard();
		}
	}
}
