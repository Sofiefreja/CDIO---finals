package cards;
import entities.AllCards;
import entities.Player;

/**
 * Abstract class Card, superclass to all Cards.
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Card{
	protected String description;
	protected int money;
	/**
	 * Super constructor which takes a String name as a parameter.
	 * @param description
	 * @param money
	 */
	public Card(String description){
		this.description=description;
	}
	/**
	 * Returns the name of the Card
	 * @retun description
	 */
	public String toString(){
		return description;
	}
	/**
	 * Method which determines what happens to a player when the specific card is picked.
	 * @param player
	 */
	public abstract void useCard(Player player);
}
