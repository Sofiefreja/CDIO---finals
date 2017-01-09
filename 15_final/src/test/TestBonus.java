package test;

import entities.Cup;
import entities.Player;
import org.junit.Test;

public class TestBonus {

	Player p1 = new Player("Simon", 100000);

	@Test
	public void test() {

		int currentPosition = 39;

		int value = 1;

		int previousPosition = currentPosition;

		System.out.print((currentPosition + value) % 40);

		int newPos = (currentPosition + value) % 40;

		if ((currentPosition + value) % 40 <= 11 && (currentPosition + value) % 40 > 0
				|| previousPosition == 0) {

			System.out.println("Derp");

		}

	}

}
