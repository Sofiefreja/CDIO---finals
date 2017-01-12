package board;

import java.util.ArrayList;

import controller.GUIControl;
import controller.msgL;

/**
 * Class Street extends Ownable
 * 
 * @author Mathias Tvaermose Gleerup, s153120
 * @author Simon Lundorf s154008
 *
 */
public class Street extends Ownable {
	int priceOfBuilding;
	int[] rents = new int[6];
	int numberOfBuildings = 0;

	/**
	 * Constructor
	 * @param name
	 * @param id [1:40]
	 * @param price
	 * @param pawn
	 * @param priceOfBuilding
	 * @param rent0
	 * @param rent1
	 * @param rent2
	 * @param rent3
	 * @param rent4
	 * @param rentHotel
	 * @param type [A:H]
	 */
	public Street(String name, int id, int price, int pawn, int priceOfBuilding, int rent0, int rent1, int rent2,
			int rent3, int rent4, int rentHotel, char type) {
		super(name, id, price, pawn, type);
		this.priceOfBuilding = priceOfBuilding;
		rents[0] = rent0;
		rents[1] = rent1;
		rents[2] = rent2;
		rents[3] = rent3;
		rents[4] = rent4;
		rents[5] = rentHotel;
	}

	@Override
	public int getRent() {
		int maxAmount;
		ArrayList<Ownable> arr = owner.getOwned();
		int counter = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getType() == this.type) {
				counter++;
			}
		}
		if (this.type == 'A' || this.type == 'H') {
			maxAmount = 2;
		} else {
			maxAmount = 3;
		}
		if (counter == maxAmount && numberOfBuildings == 0) {
			return rents[0] * 2;
		} else {
			return rents[numberOfBuildings];
		}
	}

	/**
	 * Method for buying an amount buildings on a Street
	 * @param amount of buildings
	 */
	public void buyHouses(int amount) {
		int maxAmount;
		ArrayList<Ownable> arr = owner.getOwned();
		int counter = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getType() == this.type) {
				counter++;
			}
		}
		if (this.type == 'A' || this.type == 'H') {
			maxAmount = 2;
		} else {
			maxAmount = 3;
		}
		if (counter == maxAmount) {
			numberOfBuildings += amount;
			owner.withdraw(amount * priceOfBuilding);
			GUIControl.printMessage(msgL.msg(168) + amount + msgL.msg(169) + (amount * priceOfBuilding));
		}
	}
	
	
	/**
	 * Method for removing an amount of buildings on this instance.
	 * @param amount
	 */
	public void removeHouses(int amount) {
		numberOfBuildings -= amount;
		owner.deposit(amount * priceOfBuilding);
	}
	
	/**
	 * 
	 * @return Number of buildings of this instance
	 */
	public int getNumberOfBuildings() {
		return numberOfBuildings;
	}
	
	/**
	 * 
	 * @return The cost of building a building
	 */
	public int getPriceOfBuilding() {
		return priceOfBuilding;
	}
}
