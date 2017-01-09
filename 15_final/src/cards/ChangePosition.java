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
	Board board;
	/**
	 * Constructor for ChangePosition card
	 * @param description
	 * @param moveTo
	 * @param board
	 */
	public ChangePosition(String description, int moveTo, Board board) {
		super(description, moveTo);
		this.board=board;
	}
	@Override
	public void useCard(Player player) {
		GUIControl.printMessage(description);
		player.setPosition(moveTo,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
		board.getSquare(player.getCurrentPosition()).landOnSquare(player);

	}
}
