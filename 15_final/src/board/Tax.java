package board;

import entities.Player;

import java.util.ArrayList;

import controller.GUIControl;
import controller.msgL;

/**
 * 
 * @author Sofie Freja Christensen s153932
 * @author Mathias Tvaermose Gleerup, s153120
 * @author Simon Lundorf s154008
 * @author Emily Skovgaard Rasmussen s153374
 *
 */
public class Tax extends Square {
	private int taxAmount; // amount defined in constructor

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param id [1:40]
	 * @param taxAmount
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
					propertyPrice.add(player.getOwned().get(i).price);
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
				player.withdraw(taxAmount);
				GUIControl.printMessage(msgL.msg(165) + taxAmount + msgL.msg(119));
			}
		} else {
			GUIControl.printMessage(player.toString() + msgL.msg(116) + taxAmount + msgL.msg(119));
			player.withdraw(taxAmount);
			//GUIControl.taxMessage(player, taxAmount);
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