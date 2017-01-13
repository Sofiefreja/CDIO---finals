package cards;

import entities.Player;

/**
 * Abstract class Card, superclass to all Cards.
 *
 */
public abstract class Card {
	protected String description;


	/**
	 * Super constructor which takes a String name as a parameter.
	 * 
	 * @param description of the card
	 */
	public Card(String description) {
		this.description = description;
	}

	/**
	 * Returns the name of the Card
	 * @return description
	 */
	@Override
	public String toString() {
		return description;
	}

	/**
	 * Method which determines what happens to a player when the specific card
	 * is picked.
	 * @param player to use the card
	 */
	public abstract void useCard(Player player);
}
