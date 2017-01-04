package board;

public class Shipping extends Ownable {


	private final int rent_1 = 500;
	private final int rent_2 = 1000;
	private final int rent_3 = 2000;
	private final int rent_4 = 4000;
	
	public Shipping(String name, int id, int price, int pawn) {
		super(name, id, price, pawn);
		
	}

	@Override
	public int getRent() {
	
		return 0;
	}

}
