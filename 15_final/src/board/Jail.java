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
		if(player.getJailCard()== false){
		GUIControl.printMessage(msgL.msg(164));
		player.setJailStatus(true);
		player.setPosition(10,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
		} else {
			GUIControl.printMessage("Du rykker til fængslet, men du havde et benådelseskort, så du er bare på besøg.");
			player.setPosition(10,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			player.useJailCard();
		}
	}
}
