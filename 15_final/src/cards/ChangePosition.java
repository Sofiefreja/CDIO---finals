package cards;

import controller.GUIControl;
import entities.Player;

/**
 * Move squares, value xx front/back. skal have fat i GUI.moveCar. Flyt player.
 * @author Sofie Freja Christensen s153932
 *
 */
public class ChangePosition extends Move {
	protected int move;
	
	public ChangePosition(String description, int move){
		super(description);
		this.move=move;
	}
public void useCard(Player player) {
		GUIControl.printMessage("You move 3 spaces");
		GUIControl.changePositionMessage(player);
		player.setPosition(player.getCurrentPosition()+3);
	}
}
