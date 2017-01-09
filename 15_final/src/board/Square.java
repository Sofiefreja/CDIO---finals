package board;
import entities.Player;
/**
 * Abstract class Square, superclass to all Squares.
 * @author Mathias Tvaermose Gleerup
 *
 */
public abstract class Square {
	protected String name;
	protected int id;
	/**
	 * Constructor which takes a String name as a parameter.
	 * @param name
	 * @param id
	 */
	public Square( String name, int id){
		this.name=name;
		this.id=id;
	}
	/**
	 * Method which determines what happens to a player when he lands on this instance.
	 * @param player
	 */
	public abstract void landOnSquare(Player player);
	/**
	 * Returns the name of the Square
	 * @return name
	 */
	public String toString(){
		return name;
	}
	/**
	 * Returns the id (int) of the square.
	 * @return id [1-40]
	 */
	public int getID(){
		return this.id;
	}

}
