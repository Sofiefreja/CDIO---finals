package board;

import java.util.ArrayList;

/**
 * Class Street, which has a type, and can have houses and a hotel built on it.
 * @author Mathias Tvaermose Gleerup, s153120
 *
 */
public class Street extends Ownable {
	int priceOfBuilding;
	int [] rents=new int[6];
	int numberOfBuildings=0;
	
	/**
	 * Constructor for Street
	 * @param name
	 * @param id
	 * @param price
	 * @param pawn
	 * @param priceOfBuilding
	 * @param rent0
	 * @param rent1
	 * @param rent2
	 * @param rent3
	 * @param rent4
	 * @param rentHotel
	 * @param type
	 */
	public Street(String name, int id,int price, int pawn,int priceOfBuilding,int rent0, int rent1, int rent2, int rent3, int rent4, int rentHotel, char type) {
		super(name,id, price, pawn,type);
		this.priceOfBuilding=priceOfBuilding;
		rents[0]=rent0;
		rents[1]=rent1;
		rents[2]=rent2;
		rents[3]=rent3;
		rents[4]=rent4;
		rents[5]=rentHotel;
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
	 * Method for returning number of houses built on this instance.
	 * @return numberOfBuildings
	 */
	public int getNumberOfBuildings(){
		return numberOfBuildings;
	}
	/**
	 * Returns the price of this instance
	 * @return
	 */
	public int getPriceOfBuilding(){
		return priceOfBuilding;
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
