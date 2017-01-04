package board;
import entities.Player;
/**
 * Class Territory extended from Ownable.
 * @author Mathias Tværmose Gleerup
 *
 */
public class Territory extends Ownable {
	int rent;
	/**
	 * Constructor for Territory which accepts name, price and rent when owned for this instance.
	 * @param name
	 * @param id
	 * @param price
	 * @param rent
	 */
	public Territory(String name,int id, int price, int rent) {
		super(name, id ,price);
		this.rent = rent;
	}

	@Override
	public int getRent() {//Implements the inherited getRent() for Territory.
		return rent;
	}

	@Override
	public void landOnSquare(Player player) {//Implements the inherited landOnSquare() for Territory.
		super.landOnSquare(player);
	}

}
