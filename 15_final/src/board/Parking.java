package board;
import entities.Player;
import controller.GUIControl;
/**
 * Class Parking extends Square
 *
 */
public class Parking extends Square {
	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 */
	public Parking(String name, int id) {
		super(name, id);
	}
	/**
	 * When landing on a Parking square, a message is printet.
	 * @param player who landed on this square
	 */
	public void landOnSquare(Player player){
		GUIControl.printMessage(name);
	}
}
