package cards;

import java.util.Random;

import entities.Player;

/**
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class MobilePay extends Transaction{

	int number = 0;
	
	public MobilePay(String name, int money) {
		super(name, money);
		
	}

	@Override
	public void useCards(Player player) {
		
		Random number = new Random();
		int res = number.nextInt(3);
		
		switch(res) {
		
		case 1:
			GUIControl.pay200Message();
			
			player.deposit(200*GameLogic.numberOfPlayers());
			
		
		}
			
		
	}
	
	
}
