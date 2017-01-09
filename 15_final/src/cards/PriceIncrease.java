package cards;

import entities.Board;
import entities.Player;

/**
 * Class for card which charges the Player with a fee for houses and hotels.
 * @author Sofie Freja Christensen s153932
 *
 */
public class PriceIncrease extends Transaction {
	protected int husAfgift;
	protected int hotelAfgift;
	
	
	/**
	 * Constructor for a PriceIncrease card
	 * @param description
	 * @param husAfgift
	 * @param hotelAfgift
	 * @param board
	 */
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
