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
public class PlayerTransaction extends Transaction{

	int number = 0;
	ArrayList<Player> playerList = new ArrayList<Player>();
	
	/**
	 * Constructor for MobilePay Card
	 * @param name
	 * @param board
	 * @param money
	 * @param playerList
	 */
	public PlayerTransaction(String name, int money, ArrayList<Player> playerList) {
		super(name,money);
		this.playerList = playerList;
		
	}

	@Override
	public void useCard(Player player) {
		
		int amount = playerList.size();
		

			GUIControl.printMessage(description);;
			
			for (int i=0; i<=playerList.size();i++) {
				playerList.get(i).withdraw(money);
			}
				
			player.deposit(money*amount);
			
		
		
		}
			
		
	}