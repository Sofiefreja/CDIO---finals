package entities;

import java.util.ArrayList;

import board.Ownable;
import board.Street;

/**
 * 
 * @author Simon Lundorf s154008
 *
 */

public class Assets {
	
	ArrayList<Ownable> owned = new ArrayList<Ownable>();
	ArrayList<Street> ownedStreet = new ArrayList<Street>();
	ArrayList<String> property = new ArrayList<String>();
	private int jailCard;
	private boolean propertyOwner;
	private boolean buildingOwner;
	
	public Assets() {
		jailCard = 0;
		propertyOwner = false;
		buildingOwner = false;
	}
	
	/**
	 * Method for adding a get out of jail free card to the player
	 * @param jailCard 
	 */
	
	public void setJailCard() {
		jailCard++;
	}
	
	/**
	 * Method for checking if the player has a get out of jail free card
	 * @return Boolean value true or false depending on whether or not the player has a card
	 */
	
	public boolean getJailCard() {
		if (jailCard>=1) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Method for removing a get out of jail free card after it is used by the player
	 * @param jailCard 
	 */
	
	public void useJailCard() {
		jailCard--;
	}
	
	/**
	 * Method for adding a bought square to list of squares a player owns
	 * @param square
	 */
	
	public void buySquare(Ownable square) {
		owned.add(square);
		property.add(square.toString());
		propertyOwner = true;
		
		if (square instanceof Street) {
			
			Street isStreet = (Street)square;
			ownedStreet.add(isStreet);
			
		}
			
		}


	/**
	 * Method for determining the square IDs of the squares a player owns
	 * @return An integer array with the square IDs
	 */
	
	public int[] getOwnedID() {
		
		int[] squareID = new int[owned.size()];
		
		for (int i=0; i < owned.size(); i++) {
			
			squareID[i] = owned.get(i).getID();
		}
		
		return squareID;
		
	}
	
	public ArrayList <Ownable> getOwned(){
		return owned;
	}
	
	public ArrayList<String> getPropertyList() {
		return property;
	}
	
	public String[] getHouseList() {
		
		String[] houseList = new String[owned.size()];
		
		for (int i=0; i < ownedStreet.size(); i++) {
			
			if (ownedStreet.get(i).getNumberOfBuildings() >= 1 && ownedStreet.get(i).getNumberOfBuildings() < 5) {
			
			houseList[i] = ownedStreet.get(i).toString();
				
			}
			
		}
		
		return houseList;
	}
	
	public String[] getHotelList() {
		
		String[] hotelList = new String[owned.size()];
		
		for (int i=0; i < ownedStreet.size(); i++) {
			
			if (ownedStreet.get(i).getNumberOfBuildings() == 5) {
			
			hotelList[i] = ownedStreet.get(i).toString();
				
			}
			
		}
		
		return hotelList;
	}
	
	public boolean getBuilding() {
		
		return buildingOwner;
		
	}
	
	public boolean getProperty() {
		
		return propertyOwner;
		
	}
	
	public void buyHouses(Street street, int amount) {
		
		street.buyHouses(amount);
		buildingOwner = true;
		
	}
	
	public void removeHouses(Street street, int amount) {
		
		street.removeHouses(amount);
	}
	
}
