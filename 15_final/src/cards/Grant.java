package cards;

import board.Street;
import controller.GUIControl;
import entities.Board;
import entities.Player;

/**
 * Receive 40.000 if the player does not have over 15.000 kr.
 * @author Sofie Freja Christensen s153932
 *
 */
public class Grant extends Transaction{
	public Grant(String description, int money,Board board){
		super(description,board,money);
	}

	@Override
	public void useCard(Player player) {
		Street a;
		int total=player.getBalance();
		for(int i=0;i<=player.getOwned().size();i++){
			total+=player.getOwned().get(i).getPrice();
			if(player.getOwned().get(i) instanceof Street){
				a=(Street) player.getOwned().get(i);
				total+=a.getNumberOfBuildings()*a.getPriceOfBuilding();
			}
		}
		if(total<=15000){
			GUIControl.printMessage("You get a grant of 40000");
			player.deposit(40000);
		}else{
			GUIControl.printMessage("YOU GET NOTHING");
		}
	}
}
