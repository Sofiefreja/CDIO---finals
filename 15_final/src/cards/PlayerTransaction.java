package cards;

import java.util.ArrayList;
import controller.GUIControl;
import entities.Player;


public class PlayerTransaction extends Transaction{
	ArrayList<Player> playerList;

	int number = 0;
	
	/**
	 * Constructor for MobilePay Card
	 * @param description of the card
	 * @param money to be payed
	 * @param playerList a list of the players
	 */
	public PlayerTransaction(String description, int money, ArrayList<Player> playerList) {
		super(description, money);
		this.playerList = playerList;	
	}

	@Override
	public void useCard(Player player) {
		
	
	int amount = playerList.size();
		
			GUIControl.printMessage(description);
			
			for (int i=0; i<playerList.size();i++) {
				playerList.get(i).withdraw(money);
			}
		player.deposit(money*amount);	
		}
	}