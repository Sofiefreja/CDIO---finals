package board;
/**
 * Class Shipping extends Ownable
 *
 */
public class Shipping extends Ownable {
	int [] rents={500,1000,2000,4000};
	int numberOfShips;
	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 */
	public Shipping(String name, int id) {
		super(name, id, 4000, 2000, 'J'); 	// the price, pawn-price and type for a Shipping field
											// is always the same.
	}
	@Override
	public int getRent() {
		numberOfShips=-1;
		for(int i=0; i<owner.getOwned().size();i++){
			if(owner.getOwned().get(i).getType()==this.getType()){
				numberOfShips++;
			}
		}
		return rents[numberOfShips];
	}
}
