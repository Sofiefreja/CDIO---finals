package cards;

import java.util.ArrayList;
import java.util.List;

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
	List<Player> playerList = new ArrayList<Player>();
	
	/**
	 * Constructor for MobilePay Card
	 * @param description
	 * @param board
	 * @param money
	 * @param playerList
	 */
	public PlayerTransaction(String description, int money, List<Player> playerList) {
		super(description,money);
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