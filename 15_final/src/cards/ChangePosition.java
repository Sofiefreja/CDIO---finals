package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * Move squares, value xx front/back.
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class ChangePosition extends Move {
	
	/**
	 * Constructor for ChangePosition card
	 * @param description
	 * @param moveTo
	 * @param board
	 */
	public ChangePosition(String description, int moveTo, Board board) {
		super(description, moveTo, board);
	}
	@Override
	public void useCard(Player player) {
		GUIControl.printMessage("You move 3 spaces");
		player.moveVehicle(moveTo);
		board.getSquare(player.getCurrentPosition()).landOnSquare(player);

	}
}
