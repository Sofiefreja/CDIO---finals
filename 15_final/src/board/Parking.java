package board;
import entities.Player;
import controller.GUIControl;
import controller.msgL;
/**
 * Class Parking extends Square
 * @author Sofie Freja Christensen s153932
 *
 */
public class Parking extends Square {
	/**
	 * Constructor
	 * @param name
	 * @param id [1:40]
	 */
	public Parking(String name, int id) {
		super(name, id);
	}
	/**
	 * When landing on a Parking square, a message is printet.
	 * @param player
	 */
	public void landOnSquare(Player player){
		GUIControl.printMessage(msgL.msg(58));
	}
}
