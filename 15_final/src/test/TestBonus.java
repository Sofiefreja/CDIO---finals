package test;

import entities.Cup;
import entities.Player;
import org.junit.Test;

public class TestBonus {

	Player p1 = new Player("Simon", 100000);

	@Test
	public void test() {

		boolean jailStatus = false;

		int penultimatePosition = 17;

		int currentPosition = 29;

		int value = 12;

		int previousPosition = currentPosition;

		System.out.print((currentPosition + value) % 40);

		currentPosition = (currentPosition + value) % 40;

		if (penultimatePosition >= 16 && previousPosition >= 28 && currentPosition <= 12 && jailStatus == false) {

			System.out.println("Derp");

		}

		value = 8;

		if (penultimatePosition >= 16 && previousPosition >= 28 && currentPosition <= 12 && jailStatus == false) {

			System.out.println("Derp2");

		}

	}
}