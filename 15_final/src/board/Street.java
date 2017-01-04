package board;

import java.util.ArrayList;

/**
 * Class Street, which has a type, and can have houses and a hotel built on it.
 * @author Mathias Tvaermose Gleerup
 *
 */
public class Street extends Ownable {
	int priceOfBuilding;
	int [] rents;
	int numberOfBuildings=0;
	
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
		super(name,id, price, pawn,type);
		this.rents=rents;
	}

	@Override
	public int getRent() {
		
		return 0;
	}
	
	public int buyHouses(int amount){
		boolean permission =false;
		int maxAmount;
		ArrayList<Ownable> arr = owner.getOwned();
		int counter=0;
		for(int i =0; i<=arr.size();i++){
			if(arr.get(i).getType()==this.type){
				counter++;
			}
		}
		if(this.type=='A'||this.type=='H'){
			maxAmount=2;
		}else{
			maxAmount =3;
		}
		if(counter==maxAmount){
			permission=true;
		}
		if(permission=true){
			numberOfBuildings+=amount;
			owner.pay(amount*priceOfBuilding);
			return amount*priceOfBuilding;
		}else{
			return 0;
		}
	}
}
