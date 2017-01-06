package cards;
import entities.Player;
import controller.GUIControl;
/**
 * GUI.moveCar. Find position. Bestem hvilket felt.
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class MovetoShip extends Card {

	public MovetoShip(String name) {
		super(name);
	}

	@Override
	public void useCard(Player player) {
		
		GUIControl.printMessage("You will now move to the ship");
		if (player.getCurrentPosition()==2 || player.getCurrentPosition()==36) { /* Skal potentielt �ndres, alt efter hvordan vi h�ndterer startbonus */
			player.setPosition(5);
		}else if (player.getCurrentPosition()==7) {
			player.setPosition(15);
		}else if (player.getCurrentPosition()==17 || (player.getCurrentPosition()==22)) {
			player.setPosition(25);
		}else if (player.getCurrentPosition()==33) {
			player.setPosition(35);
		
	}
	
	}
}
