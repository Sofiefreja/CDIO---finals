package cards;

import entities.Player;
import controller.GUIControl;
import entities.Board;

/**
 * Class for moving a Player to a specific Square
 *
 */
public class MoveToSquare extends Move {
	
	Board board;
	/**
	 * Constructor for MoveToSquare
	 * @param description of the card
	 * @param moveTo the square ID the player should move to
	 * @param board in the game
	 */
	public MoveToSquare(String description, int moveTo,Board board){
		super(description,moveTo);
		this.board=board;
	}
	@Override
	public void useCard(Player player){
		GUIControl.printMessage(description);
		player.setPosition(moveTo,player.getCurrentPosition());
		GUIControl.moveVehicle(player);
		board.getSquare(moveTo).landOnSquare(player);
	}
}
