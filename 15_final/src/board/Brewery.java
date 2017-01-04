package board;

public class Brewery extends Ownable {

	private final int rent_1 = 1;
	private final int rent_2 = 1;

	public Brewery(String name, int id, int price, int pawn, char type) {
		super(name, id, price, pawn, type);
	
	}

	@Override
	public int getRent() {

		return 0;
	}

}
