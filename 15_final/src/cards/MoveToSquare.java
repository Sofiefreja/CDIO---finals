package cards;

import entities.Player;
import controller.GUIControl;
import entities.Board;

/**
 * Class for moving a Player to a specific Square
 * @author Sofie Freja Christensen s153932
 *
 */
public class MoveToSquare extends Move {
	
	
	/**
	 * Constructor for MoveToSquare
	 * @param description
	 * @param moveTo
	 * @param board
	 */
	public MoveToSquare(String description, int moveTo,Board board){
		super(description,moveTo,board);
	}
	@Override
	public void useCard(Player player){
		player.setPosition(moveTo);
		GUIControl.moveVehicle(player);
		board.getSquare(moveTo).landOnSquare(player);
	}
}
