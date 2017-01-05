package entities;

import java.util.ArrayList;

import board.Ownable;

/**
 * 
 * @author Simon Lundorf s154008
 *
 */

public class Assets {
	
	ArrayList<Ownable> owned = new ArrayList<Ownable>();
	private int jailCard = 0;
	
	/**
	 * Method for adding a get out of jail free card to the player
	 */
	
	public void setJailCard() {
		jailCard=++jailCard;
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
	 */
	
	public void useJailCard() {
		jailCard=--jailCard;
	}
	
	/**
	 * Method for adding a bought square to list of squares a player owns
	 * @param square
	 */
	
	public void buySquare(Ownable square) {
		owned.add(square);

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
}
