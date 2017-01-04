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
	/**
	 * Method for returning number of houses built on this instance.
	 * @return numberOfBuildings
	 */
	public int getNumberOfBuildings(){
		return numberOfBuildings;
	}
	@Override
	public int getRent() {
		return rents[numberOfBuildings];
	}
	/**
	 * Method for buying houses on a street.
	 * @param amount
	 */
	public void buyHouses(int amount){
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
			numberOfBuildings+=amount;
			owner.withdraw(amount*priceOfBuilding);
			//GUIControl.housesBought(this, amount, priceOfBuilding);
		}
	}
	/**
	 * Method for removing an amount of buildings on this instance.
	 * @param amount
	 */
	public void removeHouses(int amount){
		numberOfBuildings-=amount;
		owner.deposit(amount*priceOfBuilding);
	}
}
