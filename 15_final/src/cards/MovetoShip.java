package cards;
import entities.Player;
import controller.GUIControl;
/**
 * GUI.moveCar. Find position. Bestem hvilket felt.
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class MovetoShip extends Card {

	public MovetoShip(String name, int money) {
		super(name, money);
	
	}

	@Override
	public void useCards(Player player) {
		
		GUIControl.moveToShipMessage(player);
		if (player.getCurrentPosition()==2 || player.getCurrentPosition()==36) { /* Skal potentielt ændres, alt efter hvordan vi håndterer startbonus */
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
