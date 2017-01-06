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
	public MoveToSquare(String description, int moveTo,Board board){
		super(description,moveTo,board);
	}
	
	public void useCard(Player player){
		player.setPosition(moveTo);
		GUIControl.moveVehicle(player);
		board.getSquare(moveTo).landOnSquare(player);
	}
}
