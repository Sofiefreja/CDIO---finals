package board;
import entities.Player;
import controller.GUIControl;
/**
 * 
 * @author Sofie Freja Christensen
 *
 */
public class Parking {
	/**
	 * 
	 * @param player
	 */
	public void landOnSquare(Player player){
		GUIControl.parkingMessage(player);
	}
}
