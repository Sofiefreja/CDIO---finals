package cards;
import entities.Player;
import controller.GUIControl;
/**
 * GUI.moveCar. Find position. Bestem hvilket felt.
 * @author Sofie Freja Christensen s153932
 *
 */
public class MovetoShip extends Card{
	private int shipNr;
	
	public MovetoShip(String name, int shipNr){
		this.name = name;
		this.shipNr = shipNr;
	}
	public void useCard(Player player){
		if(Player.getCurrentPosition(player)<5 && Player.getCurrentPosition(player)>35){
			Player.setPosition();
		}else if(Player.getCurrentPosition(player)>5 && Player.getCurrentPosition(player)<15){
			
		}else if(Player.getCurrentPosition(player)>15 && Player.getCurrentPosition(player)<25){
			
		}else if(Player.getCurrentPosition(player)>25 && Player.getCurrentPosition(player)<35){
			
		}
	}
}
