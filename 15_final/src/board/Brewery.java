package board;

public class Brewery extends Ownable {

	private final int rent_1 = 1;
	private final int rent_2 = 1;

	public Brewery(String name, int id, int price, int pawn, char type) {
		super(name, id, price, pawn, type);

	}

	@Override
	public int getRent() {
		int rent; 

		if(get()){
			rent = 0;

		}
		else { 
			switch (()) {
			case 1: 
				rent = 100 * player.getDiceSum();
				break;
			case 2:
				rent = 200 * player.getDiceSum();
				break;
			default: return 0;


			}
		}
		
		return rent;

	}

}
