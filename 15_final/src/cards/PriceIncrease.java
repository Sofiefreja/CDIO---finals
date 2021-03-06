package cards;


import entities.Player;
import java.util.ArrayList;
import controller.GUIControl;
import controller.msgL;

/**
 * Class for card which charges the Player with a fee for houses and hotels.
 *
 */
public class PriceIncrease extends Transaction {
	protected int houseTax;
	protected int hotelTax;

	/**
	 * Constructor for a PriceIncrease card
	 * 
	 * @param description of the card
	 * @param houseTax increase
	 * @param hotelTax increase
	 */
	public PriceIncrease(String description, int houseTax, int hotelTax) {
		super(description, houseTax);
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

				GUIControl.printMessage(msgL.msg(126));
				
			}
	}
}
