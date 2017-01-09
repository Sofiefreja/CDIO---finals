package entities;

import java.util.ArrayList;

import board.Ownable;
import board.Street;

/**
 * Class which keeps track of a Player's assets (Squares, buildings and
 * jailCards).
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
	private boolean buildStatus;

	/**
	 * Constructor for Assets
	 */
	public Assets() {
		jailCard = 0;
		propertyOwner = false;
		buildingOwner = false;
		buildStatus = false;
	}

	/**
	 * Method for adding a get out of jail free card to the player
	 * 
	 * @param jailCard
	 */

	public void setJailCard() {
		jailCard++;
	}

	/**
	 * Method for checking if the player has a get out of jail free card
	 * 
	 * @return Boolean value true or false depending on whether or not the
	 *         player has a card
	 */

	public boolean getJailCard() {
		if (jailCard >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method for removing a get out of jail free card after it is used by the
	 * player
	 * 
	 * @param jailCard
	 */

	public void useJailCard() {
		jailCard--;
	}

	/**
	 * Method for adding a bought square to list of squares a player owns
	 * 
	 * @param square
	 */

	public void buySquare(Ownable square) {
		owned.add(square);
		property.add(square.toString());
		propertyOwner = true;

		if (square instanceof Street) {

			Street isStreet = (Street) square;
			ownedStreet.add(isStreet);

		}

	}

	/**
	 * Method for determining the square IDs of the squares a player owns
	 * 
	 * @return An integer array with the square IDs
	 */
	public int[] getOwnedID() {

		int[] squareID = new int[owned.size()];

		for (int i = 0; i < owned.size(); i++) {

			squareID[i] = owned.get(i).getID();
		}

		return squareID;

	}

	/**
	 * Method for getting an ArrayList of owned squares
	 * 
	 * @return ArrayList<Ownable>
	 */
	public ArrayList<Ownable> getOwned() {
		return owned;
	}

	/**
	 * Returns a list of the names of the properties owned by this player.
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getPropertyList() {
		return property;
	}

	/**
	 * Method for getting an array of the names of properties with houses built
	 * on them
	 * 
	 * @return String[]
	 */
	public String[] getHouseList() {

		String[] houseList = new String[owned.size()];

		for (int i = 0; i < ownedStreet.size(); i++) {

			if (ownedStreet.get(i).getNumberOfBuildings() >= 1 && ownedStreet.get(i).getNumberOfBuildings() < 5) {

				houseList[i] = ownedStreet.get(i).toString();

			}

		}

		return houseList;
	}

	/**
	 * Method for getting an array of the names of properties with hotels built
	 * on them
	 * 
	 * @return String[]
	 */
	public String[] getHotelList() {

		String[] hotelList = new String[owned.size()];

		for (int i = 0; i < ownedStreet.size(); i++) {

			if (ownedStreet.get(i).getNumberOfBuildings() == 5) {

				hotelList[i] = ownedStreet.get(i).toString();

			}

		}

		return hotelList;
	}

	/**
	 * Method for returning a boolean value of whether the player owns a
	 * building.
	 * 
	 * @return boolean hasBuilding
	 */
	public boolean getBuilding() {
		return buildingOwner;
	}

	/**
	 * Method for returning a boolean value of whether the player owns a a
	 * property.
	 * 
	 * @return boolean hasProperty
	 */
	public boolean getProperty() {

		return propertyOwner;

	}

	/**
	 * Method for buying an amount of buildings on a specific Street.
	 * 
	 * @param street
	 * @param amount
	 */
	public void buyHouses(Street street, int amount) {

		street.buyHouses(amount);
		buildingOwner = true;

	}

	/**
	 * Method for removing an amount of houses from a specific Street.
	 * 
	 * @param street
	 * @param amount
	 */
	public void removeHouses(Street street, int amount) {

		boolean noBuilding = true;
		buildingOwner = false;

		street.removeHouses(amount);

		for (int i = 0; i < ownedStreet.size(); i++) {

			if (ownedStreet.get(i).getNumberOfBuildings() >= 1) {

				noBuilding = false;

			}

			if (noBuilding == false) {

				buildingOwner = true;

			}

		}
	}

	/**
	 * Method for returning a boolean value of whether the player can build a
	 * house.
	 * 
	 * @return
	 */
	public boolean getBuildStatus() {

		int counterA = 0;
		int counterB = 0;
		int counterC = 0;
		int counterD = 0;
		int counterE = 0;
		int counterF = 0;
		int counterG = 0;
		int counterH = 0;

		if (ownedStreet.size() == 0) {
			buildStatus = false;
			return buildStatus;
		} else {
			for (int i = 0; i < ownedStreet.size(); i++) {

				if (ownedStreet.get(i).getType() == 'A') {
					counterA++;

				} else if (ownedStreet.get(i).getType() == 'B') {
					counterB++;

				} else if (ownedStreet.get(i).getType() == 'C') {
					counterC++;

				} else if (ownedStreet.get(i).getType() == 'D') {
					counterD++;

				} else if (ownedStreet.get(i).getType() == 'E') {
					counterE++;

				} else if (ownedStreet.get(i).getType() == 'F') {
					counterF++;

				} else if (ownedStreet.get(i).getType() == 'G') {
					counterG++;

				} else if (ownedStreet.get(i).getType() == 'H') {
					counterH++;
				}

			}

			for (int i = 0; i < ownedStreet.size(); i++) {

				if (counterA == 2 || counterH == 2 || counterB == 3 || counterC == 3 || counterD == 3 || counterE == 3
						|| counterF == 3 || counterG == 3 && ownedStreet.get(i).getNumberOfBuildings() < 5) {
					buildStatus = true;
				} else {
					buildStatus = false;
				}

			}

			return buildStatus;

		}
	}

	/**
	 * Method for getting a String array of streets which there can be built
	 * buildings on.
	 * 
	 * @return String[]
	 */
	public String[] getBuildableList() {

		String[] buildableList = new String[ownedStreet.size()];
		int counterA = 0;
		int counterB = 0;
		int counterC = 0;
		int counterD = 0;
		int counterE = 0;
		int counterF = 0;
		int counterG = 0;
		int counterH = 0;

		for (int i = 0; i < ownedStreet.size(); i++) {

			if (ownedStreet.get(i).getType() == 'A') {
				counterA++;

			} else if (ownedStreet.get(i).getType() == 'B') {
				counterB++;

			} else if (ownedStreet.get(i).getType() == 'C') {
				counterC++;

			} else if (ownedStreet.get(i).getType() == 'D') {
				counterD++;

			} else if (ownedStreet.get(i).getType() == 'E') {
				counterE++;

			} else if (ownedStreet.get(i).getType() == 'F') {
				counterF++;

			} else if (ownedStreet.get(i).getType() == 'G') {
				counterG++;

			} else if (ownedStreet.get(i).getType() == 'H') {
				counterH++;
			}

		}
		for (int i = 0; i < ownedStreet.size(); i++) {

			if (counterA == 2 && ownedStreet.get(i).getType() == 'A'
					|| counterB == 3 && ownedStreet.get(i).getType() == 'B'
					|| counterC == 3 && ownedStreet.get(i).getType() == 'C'
					|| counterD == 3 && ownedStreet.get(i).getType() == 'D'
					|| counterE == 3 && ownedStreet.get(i).getType() == 'E'
					|| counterF == 3 && ownedStreet.get(i).getType() == 'F'
					|| counterG == 3 && ownedStreet.get(i).getType() == 'G' || counterH == 2
							&& ownedStreet.get(i).getType() == 'H' && ownedStreet.get(i).getNumberOfBuildings() < 5) {
				buildableList[i] = ownedStreet.get(i).toString();
			}

		}
		return buildableList;
	}
}
