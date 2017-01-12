package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import board.Brewery;
import board.Jail;
import board.Ownable;
import board.Parking;
import board.Shipping;
import board.Square;
import board.Start;
import board.Street;
import board.Tax;
import entities.Board;
import entities.Cup;
import entities.Player;

public class Buildable {

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

	Player p1 = new Player("Simon", 100000);

	@Test
	public void test() {

		theBoard.getSquare(1).landOnSquare(p1);
		theBoard.getSquare(3).landOnSquare(p1);
		theBoard.getSquare(6).landOnSquare(p1);
		theBoard.getSquare(8).landOnSquare(p1);
		theBoard.getSquare(11).landOnSquare(p1);
		theBoard.getSquare(13).landOnSquare(p1);
		theBoard.getSquare(14).landOnSquare(p1);

		System.out.println(p1.getBalance());

		p1.buyHouses((Street) (theBoard.getSquare(3)), 2);
		p1.buyHouses((Street) (theBoard.getSquare(13)), 4);
		p1.buyHouses((Street) (theBoard.getSquare(14)), 5);
		p1.buyHouses((Street) (theBoard.getSquare(1)), 5);

		System.out.println(p1.getBalance());

		System.out.println(p1.getBuilding());

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

		p1.withdraw((p1.getBalance() + sumProperty + sumBuilding) / 10);

		String[] buildableList = p1.getBuildableList();

		System.out.println(Arrays.toString(buildableList));
		System.out.println(sumBuilding);
		System.out.println(sumProperty);
		System.out.println(p1.getBalance());
	}
}
