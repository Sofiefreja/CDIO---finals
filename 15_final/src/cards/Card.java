package cards;
import entities.AllCards;
import entities.Player;

/**
 * Abstract class Card, superclass to all Cards.
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Card extends AllCards{
	protected String name;
	protected int money;
	/**
	 * Super constructor which takes a String name as a parameter.
	 * @param name
	 * @param money
	 */
	public Card(String name, int money){
		this.name=name;
		this.money=money;
	}
	/**
	 * Returns the name of the Card
	 * @retun name
	 */
	public String toString(){
		return name;
	}
	/**
	 * Returns money change of the Card
	 * @return
	 */
	public int getMoney(){
		return this.money;
	}
	/**
	 * Method which determines what happens to a player when the specific card is picked.
	 * @param player
	 */
	public abstract void landOnSquare(Player player);
}
