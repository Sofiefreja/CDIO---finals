package cards;

import entities.Board;
import entities.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import board.Ownable;
import board.Street;

/**
 * Class for card which charges the Player with a fee for houses and hotels.
 * 
 * @author Simon Lundorf s154008 & Emily Skovgaard Rasmussen s153374
 *
 */
public class PriceIncrease extends Transaction {
	protected int husAfgift;
	protected int hotelAfgift;

	/**
	 * Constructor for a PriceIncrease card
	 * 
	 * @param description
	 * @param husAfgift
	 * @param hotelAfgift
	 * @param board
	 */
	public PriceIncrease(String description, int husAfgift, int hotelAfgift, Board board) {
		super(description, board, husAfgift);
		this.husAfgift = husAfgift;
		this.hotelAfgift = hotelAfgift;
	}

	@Override
	public void useCard(Player player) {

		ArrayList<Integer> housePrice = new ArrayList<Integer>();
		ArrayList<Integer> hotelPrice = new ArrayList<Integer>();
		int sumHouse = 0;
		int sumHotel = 0;

		Random number = new Random();
		int res = number.nextInt(2);

		switch (res) {

		case 1:

			if (player.getBuilding() == true) {

				for (int i = 0; i < player.getOwnedStreet().size(); i++) {

					if (player.getOwnedStreet().get(i).getNumberOfBuildings() >= 1
							&& player.getOwnedStreet().get(i).getNumberOfBuildings() < 5) {

						housePrice.add(player.getOwnedStreet().get(i).getNumberOfBuildings() * 800);

					} else if (player.getOwnedStreet().get(i).getNumberOfBuildings() == 5) {

						hotelPrice.add(2300);

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

				/*
				 * Skal printe en GUI besked om, at spilleren ikke ejer huse, og
				 * at der derfor intet sker
				 */

			}
			break;

		case 2:

			if (player.getBuilding() == true) {

				for (int i = 0; i < player.getOwnedStreet().size(); i++) {

					if (player.getOwnedStreet().get(i).getNumberOfBuildings() >= 1
							&& player.getOwnedStreet().get(i).getNumberOfBuildings() < 5) {

						housePrice.add(player.getOwnedStreet().get(i).getNumberOfBuildings() * 500);

					} else if (player.getOwnedStreet().get(i).getNumberOfBuildings() == 5) {

						hotelPrice.add(2000);

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

				/*
				 * Skal printe en GUI besked om, at spilleren ikke ejer huse, og
				 * at der derfor intet sker
				 */

			}

		}
	}
}
