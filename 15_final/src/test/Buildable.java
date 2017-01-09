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

	private Board theBoard = new Board(theCup);

	ArrayList<Integer> housePrice = new ArrayList<Integer>();
	ArrayList<Integer> hotelPrice = new ArrayList<Integer>();
	int sumHouse;
	int sumHotel;

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

		if (p1.getBuilding() == true) {

			for (int i = 0; i < p1.getOwnedStreet().size(); i++) {

				if (p1.getOwnedStreet().get(i).getNumberOfBuildings() >= 1
						&& p1.getOwnedStreet().get(i).getNumberOfBuildings() < 5) {

					housePrice.add(p1.getOwnedStreet().get(i).getNumberOfBuildings() * 800);

				} else if (p1.getOwnedStreet().get(i).getNumberOfBuildings() == 5) {

					hotelPrice.add(2300);

				}

			}

			for (int j = 0; j < housePrice.size(); j++) {

				sumHouse += housePrice.get(j);

			}

			for (int k = 0; k < hotelPrice.size(); k++) {

				sumHotel += hotelPrice.get(k);

			}

			p1.withdraw(sumHouse + sumHotel);

		}

		String[] buildableList = p1.getBuildableList();

		System.out.println(Arrays.toString(buildableList));
		System.out.println(sumHouse);
		System.out.println(sumHotel);
		System.out.println(p1.getBalance());
	}
}
