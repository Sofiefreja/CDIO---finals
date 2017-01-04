package board;
/**
 * Class Street, which has a type, and can have houses and a hotel built on it.
 * @author Mathias Tvaermose Gleerup
 *
 */
public class Street extends Ownable {
	int [] rents;
	char type;
	int i=0;
	
	/**
	 * Constructor which instantiates a Street.
	 * 
	 * @param name
	 * @param id
	 * @param price
	 * @param pawn
	 * @param rents
	 * @param type
	 */
	public Street(String name, int id,int price, int pawn, int[] rents, char type) {
		super(name,id, price, pawn);
		this.rents=rents;
		this.type=type;
	}

	@Override
	public int getRent() {
		
		return 0;
	}
	
	public int buyHouses(){
		
	}
}
