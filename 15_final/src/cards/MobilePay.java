package cards;

import java.util.ArrayList;
import java.util.Random;

import board.Ownable;
import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class MobilePay extends Transaction{

	int number = 0;
	ArrayList<Player> playerList = new ArrayList<Player>();
	
	public MobilePay(String name,Board board ,int money, ArrayList<Player> playerList) {
		super(name,board ,money);
		this.playerList = playerList;
		
	}

	@Override
	public void useCard(Player player) {
		
		Random number = new Random();
		int res = number.nextInt(3);
		int amount = playerList.size();
		
		switch(res) {
		
		case 1:
			GUIControl.printMessage("det er din fødselsdag, de andre giver dig 200");;
			
			for (int i=0; i<=playerList.size();i++) {
				playerList.get(i).withdraw(200);
			}
				
			player.deposit(200*amount);
			
			break;
			
		case 2:
			GUIControl.printMessage("Du har lagt ud for familiefest de andre betaler");
			
			for (int i=0; i<=playerList.size();i++) {
				playerList.get(i).withdraw(500);
			}
				
			player.deposit(500*amount);
			
			break;
		
		case 3:
			GUIControl.printMessage("Sammenskudsgilde, de andre betaler!");
			
			for (int i=0; i<=playerList.size();i++) {
				playerList.get(i).withdraw(500);
			}
				
			player.deposit(500*amount);
			
			break;
		
		}
			
		
	}
	
	
}
