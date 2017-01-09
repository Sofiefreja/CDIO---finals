package cards;

import entities.Board;
import entities.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import board.Ownable;
import board.Street;
import controller.GUIControl;

/**
 * Class for card which charges the Player with a fee for houses and hotels.
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class PriceIncrease extends Transaction {
	protected int houseTax;
	protected int hotelTax;

	/**
	 * Constructor for a PriceIncrease card
	 * 
	 * @param description
	 * @param houseTax
	 * @param hotelTax
	 * @param board
	 */
	public PriceIncrease(String description, int houseTax, int hotelTax, Board board) {
		super(description, board, houseTax);
		this.houseTax = houseTax;
		this.hotelTax = hotelTax;
	}

	@Override
	public void useCard(Player player) {

		ArrayList<Integer> housePrice = new ArrayList<Integer>();
		ArrayList<Integer> hotelPrice = new ArrayList<Integer>();
		int sumHouse = 0;
		int sumHotel = 0;
			
		GUIControl.printMessage(description);
		
			if (player.getBuilding() == true) {

				for (int i = 0; i < player.getOwnedStreet().size(); i++) {

					if (player.getOwnedStreet().get(i).getNumberOfBuildings() >= 1
							&& player.getOwnedStreet().get(i).getNumberOfBuildings() < 5) {

						housePrice.add(player.getOwnedStreet().get(i).getNumberOfBuildings() * houseTax);

					} else if (player.getOwnedStreet().get(i).getNumberOfBuildings() == 5) {

						hotelPrice.add(hotelTax);

					}

				}

				for (int j = 0; j < housePrice.size(); j++) {

					sumHouse += housePrice.get(j);

				}

				for (int k = 0; k < hotelPrice.size(); k++) {

					sumHotel += hotelPrice.get(k);

				}

				player.withdraw(sumHouse + sumHotel);

			} else {

				GUIControl.printMessage("Du ejer ingen huse eller hoteller, og skal derfor ikke betale afgift.");
				
			}

	}
}
