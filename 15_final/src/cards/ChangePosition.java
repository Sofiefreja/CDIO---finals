package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * Move squares, value xx front/back. skal have fat i GUI.moveCar. Flyt player.
 * @author Sofie Freja Christensen s153932
 *
 */
public class ChangePosition extends Move {
	public ChangePosition(String description, int moveTo, Board board){
		super(description, moveTo, board);
	}
public void useCard(Player player) {
		GUIControl.printMessage("You move 3 spaces");
		player.moveVehicle(moveTo);
		board.getSquare(player.getCurrentPosition()).landOnSquare(player);
		
	}
}
