package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.junit.Test;

import board.Street;
import entities.Board;
import entities.Cup;
import entities.Player;

public class TestTax10 {

	private Cup theCup = new Cup();
	private Board theBoard = new Board(theCup, null, false);
	ArrayList<Integer> housePrice = new ArrayList<Integer>();
	ArrayList<Integer> hotelPrice = new ArrayList<Integer>();
	int sumHouse;
	int sumHotel;
	ArrayList<Integer> propertyPrice = new ArrayList<Integer>();
	ArrayList<Integer> buildingPrice = new ArrayList<Integer>();
	int sumProperty = 0;
	int sumBuilding = 0;

	Player p1 = new Player("Test", 100000);

	@Test
	public void test() {

		// The test player buys squares and has the price withdrawn from their account
		
		p1.buySquare((Street) (theBoard.getSquare(1))); // Price 1200
		p1.buySquare((Street) (theBoard.getSquare(3))); // Price 1200
		p1.buySquare((Street) (theBoard.getSquare(6))); // Price 2000
		p1.buySquare((Street) (theBoard.getSquare(8))); // Price 2000
		p1.buySquare((Street) (theBoard.getSquare(11))); // Price 2800
		p1.buySquare((Street) (theBoard.getSquare(13))); // Price 2800
		p1.buySquare((Street) (theBoard.getSquare(14))); // Price 3200
		
		for (int i = 0; i < p1.getOwned().size(); i++) {
			
			p1.withdraw(p1.getOwned().get(i).getPrice());
			p1.getOwned().get(i).setOwner(p1);
			
		}
		
		// A total of 15200 should have been withdrawn from the test player's balance
		
		assertEquals(84800, p1.getBalance());
		
		// 7 pieces of property should be registered as owned by the test player
		
		assertEquals(7, p1.getOwnedStreet().size());
		
		// The test player constructs buildings on some of the streets
		
		((Street) theBoard.getSquare(1)).setBuilding(5);
		((Street) theBoard.getSquare(3)).setBuilding(2);
		((Street) theBoard.getSquare(13)).setBuilding(4);
		((Street) theBoard.getSquare(14)).setBuilding(5);
		
		// Checks the total number of buildings the player now owns
		
		int[] buildings = new int[p1.getOwnedStreet().size()];
		
		for (int i = 0; i < p1.getOwnedStreet().size(); i++) {
			
			buildings[i] = p1.getOwnedStreet().get(i).getNumberOfBuildings();
			
		}
		
		int totalBuildings = IntStream.of(buildings).sum();
		
		// The total amount should be 16
		
		assertEquals(16, totalBuildings);
		
		p1.withdraw(((Street) theBoard.getSquare(1)).getPriceOfBuilding()*5); // Price of 1 building: 1000
		p1.withdraw(((Street) theBoard.getSquare(3)).getPriceOfBuilding()*2); // Price of 1 building: 1000
		p1.withdraw(((Street) theBoard.getSquare(13)).getPriceOfBuilding()*4); // Price of 1 building: 2000
		p1.withdraw(((Street) theBoard.getSquare(14)).getPriceOfBuilding()*5); // Price of 1 building: 2000
		
		// A total of 25000 should have been withdrawn from the player as payment for the buildings
		
		assertEquals(59800, p1.getBalance());

		// Now the code that is supposed to calculate 10% of a players total assets, calculated as 10% of cash, price of buildings and price of property, can be tested
		
		for (int i = 0; i < p1.getOwned().size(); i++) {
			propertyPrice.add(p1.getOwned().get(i).getPrice());
		}
		for (int j = 0; j < p1.getOwnedStreet().size(); j++) {
			buildingPrice.add(p1.getOwnedStreet().get(j).getNumberOfBuildings()
					* p1.getOwnedStreet().get(j).getPriceOfBuilding());
		}
		for (int k = 0; k < propertyPrice.size(); k++) {
			sumProperty += propertyPrice.get(k);
		}
		for (int l = 0; l < buildingPrice.size(); l++) {
			sumBuilding += buildingPrice.get(l);
		}
		
		// The property value should be 15200 and the building value should be 25000
		
		assertEquals(15200, sumProperty);
		assertEquals(25000, sumBuilding);
		
		int taxAmount = (p1.getBalance() + sumProperty + sumBuilding) / 10;
		
		// As the test player started with 100000 in cash and have only bought property and buildings, the tax amount should be 10000
		
		p1.withdraw(taxAmount);
		
		// The test player's remaining funds should now be 49800
		
		assertEquals(49800, p1.getBalance());

	}
}
