package cards;
import entities.Player;
import controller.GUIControl;
import entities.Board;

/**
 * Class for cards which moves a player to nearest Shipping square
 * 
 * @author Simon Lundorf s154008
 * @author Emily Skovgaard Rasmussen s153374
 *
 */
public class MovetoShip extends Card {
	Board board;
	/**
	 * Constructor for MoveToShip card
	 * @param description
	 * @param board
	 */
	public MovetoShip(String description, Board board) {
		super(description);
		this.board=board;
	}

	@Override
	public void useCard(Player player) {
		GUIControl.printMessage(description);
		if (player.getCurrentPosition()==2 || player.getCurrentPosition()==36) {
			player.setPosition(5,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			board.getSquare(5).landOnSquare(player);
			
		}else if (player.getCurrentPosition()==7) {
			player.setPosition(15,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			board.getSquare(15).landOnSquare(player);
			
		}else if (player.getCurrentPosition()==17 || (player.getCurrentPosition()==22)) {
			player.setPosition(25,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			board.getSquare(25).landOnSquare(player);
			
		}else if (player.getCurrentPosition()==33) {
			player.setPosition(35,player.getCurrentPosition());
			GUIControl.moveVehicle(player);
			board.getSquare(35).landOnSquare(player);
	}
	
	}
}
