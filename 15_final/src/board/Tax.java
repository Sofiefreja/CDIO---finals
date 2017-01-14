package board;

import entities.Player;

import java.util.ArrayList;

import controller.GUIControl;
import controller.msgL;

public class Tax extends Square {
	private int taxAmount; // amount defined in constructor

	/**
	 * Constructor
	 * 
	 *@param name of this instance
	 *@param id [1:40]
	 *@param taxAmount to be withdrawed if chosen.
	 */
	public Tax(String name, int id, int taxAmount) {
		super(name, id);
		this.taxAmount = taxAmount;
	}

	@Override
	public void landOnSquare(Player player) {
		ArrayList<Integer> propertyPrice = new ArrayList<Integer>();
		ArrayList<Integer> buildingPrice = new ArrayList<Integer>();
		int sumProperty = 0;
		int sumBuilding = 0;

		if (id == 5) {
			Boolean choice = GUIControl.getTaxChoice(name, player);
			if (choice == true) {
				player.withdraw(taxAmount);
			} else {
				for (int i = 0; i < player.getOwned().size(); i++) {
					propertyPrice.add(player.getOwned().get(i).getPrice());
				}
				for (int j = 0; j < player.getOwnedStreet().size(); j++) {
					buildingPrice.add(player.getOwnedStreet().get(j).getNumberOfBuildings()
							* player.getOwnedStreet().get(j).getPriceOfBuilding());
				}
				for (int k = 0; k < propertyPrice.size(); k++) {
					sumProperty += propertyPrice.get(k);
				}
				for (int l = 0; l < buildingPrice.size(); l++) {
					sumBuilding += buildingPrice.get(l);
				}
				int taxAmount = (player.getBalance() + sumProperty + sumBuilding) / 10;
				GUIControl.printMessage(msgL.msg(165) + taxAmount + msgL.msg(119));
				player.withdraw(taxAmount);
			}
		} else {
			GUIControl.printMessage(player.toString() + msgL.msg(116) + taxAmount + msgL.msg(119)+msgL.msg(212));
			player.withdraw(taxAmount);
		}
	}
	/**
	 * Method for getting taxAmount.
	 * 
	 * @return taxAmount
	 */
	public int getTaxAmount() {
		return taxAmount;
	}

}