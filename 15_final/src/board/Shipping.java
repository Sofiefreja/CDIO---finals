package board;
/**
 * 
 * @author Mathias Tvaermose Gleerup, s153120
 *
 */
public class Shipping extends Ownable {
	int [] rents={500,1000,2000,4000};
	int numberOfShips;
	/**
	 * Constructor for Shipping
	 * @param name
	 * @param id
	 */
	public Shipping(String name, int id) {
		super(name, id, 4000, 2000, 'J');
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
