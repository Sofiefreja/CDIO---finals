package cards;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import board.Ownable;
import controller.GUIControl;
import controller.GameLogic;
import entities.Board;
import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class PlayerTransaction extends Transaction{
	ArrayList<Player> playerList;

	int number = 0;
	
	/**
	 * Constructor for MobilePay Card
	 * @param description
	 * @param board
	 * @param money
	 * @param playerList
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
			
			
		GUIControl.updateBalance(player);
		
		}
			
		
	}