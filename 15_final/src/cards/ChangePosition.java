package cards;

import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * Class ChangePosition extends Move
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class ChangePosition extends Move {
	Board board;
	/**
	 * Constructor
	 * @param description of the card.
	 * @param moveTo the position the player shall be moved by.
	 * @param board of the game
	 */
	public ChangePosition(String description, int moveTo, Board board) {
		super(description, moveTo);
		this.board=board;
	}
	@Override
	public void useCard(Player player) {
		GUIControl.printMessage(description);
		player.setPosition(moveTo+player.getCurrentPosition(),player.getCurrentPosition());
	if(player.getCurrentPosition() < 0){
		player.setPosition(39,player.getPreviousPosition());
	} 
	GUIControl.moveVehicle(player);
	board.getSquare(player.getCurrentPosition()).landOnSquare(player);
	}
}
