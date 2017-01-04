package board;
import entities.Player;
import controller.GUIControl;
/**
 * 	A player lands on parking.
 * @author Sofie Freja Christensen s153932
 *
 */
public class Parking extends Square {
	public Parking(String name, int id) {
		super(name, id);
	}
	/**
	 * When landing on square, it tells the GUIControl to write out a message.
	 * @param player
	 */
	public void landOnSquare(Player player){
		GUIControl.parkingMessage(player);
	}
}
