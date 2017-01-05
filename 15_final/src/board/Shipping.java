package board;

public class Shipping extends Ownable {

	private final int rent_1 = 500;
	private final int rent_2 = 1000;
	private final int rent_3 = 2000;
	private final int rent_4 = 4000;
	

	public Shipping(String name, int id, int price, int pawn, char type) {
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
				rent = rent_1;
				break;
			case 2:
				rent = rent_2;
				break;
			case 3: 
				rent = rent_3;
				break;
			case 4:
				rent = rent_4;
				break;
			default: return 0;


			}
		}
		
	}

	
	
	
}
