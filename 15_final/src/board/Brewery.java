package board;

public class Brewery extends Ownable {

	public Brewery(String name, int id, int price, int pawn) {
		super(name, id, price, pawn);
		
	}

	@Override
	public int getRent() {

		return 0;
	}

}
