package cards;
import entities.Player;
import controller.GUIControl;
import entities.Board;

/**
 * Class for cards which moves a player to nearest Shipping square
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class MovetoShip extends Card {
	
	/**
	 * Constructor for MoveToShip card
	 * @param name
	 * @param board
	 */
	public MovetoShip(String name, Board board) {
		super(name,board);
	}

	@Override
	public void useCard(Player player) {
		GUIControl.printMessage("You will now move to the ship");
		if (player.getCurrentPosition()==2 || player.getCurrentPosition()==36) { /* Skal potentielt �ndres, alt efter hvordan vi h�ndterer startbonus */
			player.setPosition(5);
			board.getSquare(5).landOnSquare(player);
		}else if (player.getCurrentPosition()==7) {
			player.setPosition(15);
			board.getSquare(15).landOnSquare(player);
		}else if (player.getCurrentPosition()==17 || (player.getCurrentPosition()==22)) {
			player.setPosition(25);
			board.getSquare(25).landOnSquare(player);
		}else if (player.getCurrentPosition()==33) {
			player.setPosition(35);
			board.getSquare(35).landOnSquare(player);
	}
	
	}
}
