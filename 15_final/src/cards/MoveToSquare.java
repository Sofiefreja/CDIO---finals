package cards;

import entities.Player;
import controller.GUIControl;
import entities.Board;

/**
 * Receive position.skal have fat i GUI.moveCar. Flyt player.
 * @author Sofie Freja Christensen s153932
 *
 */
public class MoveToSquare extends Move {
	int moveTo;
	public MoveToSquare(String description, int moveTo){
		super(description);
		this.moveTo=moveTo;
	}
	
	public void useCard(Player player){
		player.setPosition(moveTo);
		GUIControl.moveVehicle(player);
		Board.getSquare(moveTo).landOnSquare(player);
	}
}
