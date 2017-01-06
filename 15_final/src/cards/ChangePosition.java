package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Move squares, value xx front/back. skal have fat i GUI.moveCar. Flyt player.
 * @author Sofie Freja Christensen s153932
 *
 */
public class ChangePosition extends Move {
	int moveTo;
	public ChangePosition(String description, int moveTo){
		super(description);
		this.moveTo=moveTo;
	}
public void useCard(Player player) {
		GUIControl.printMessage("You move 3 spaces");
		player.setPosition(moveTo);
		
	}
}
