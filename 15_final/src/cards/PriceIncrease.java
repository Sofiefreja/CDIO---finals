package cards;

import entities.Board;
import entities.Player;

/**
 * Betal 5000 kr. per hotel. fx. Kig på account. 
 * @author Sofie Freja Christensen s153932
 *
 */
public class PriceIncrease extends Transaction {
	protected int husAfgift;
	protected int hotelAfgift;
	public PriceIncrease(String description, int husAfgift, int hotelAfgift, Board board){
		super(description,board,husAfgift);
		this.husAfgift=husAfgift;
		this.hotelAfgift=hotelAfgift;
	}
	@Override
	public void useCard(Player player) {
		// TODO Auto-generated method stub
		
	}
}
