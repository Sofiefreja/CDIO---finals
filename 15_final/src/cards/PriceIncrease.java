package cards;
/**
 * Betal 5000 kr. per hotel. fx. Kig på account. 
 * @author Sofie Freja Christensen s153932
 *
 */
public class PriceIncrease extends Transaction {
	protected int husAfgift;
	protected int hotelAfgift;
	public PriceIncrease(String description, int husAfgift, int hotelAfgift){
		super(description);
		this.husAfgift=husAfgift;
		this.hotelAfgift=hotelAfgift;
	}
}
