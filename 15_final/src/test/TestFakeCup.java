package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Cup;

public class TestFakeCup {
	Cup cup = new FakeCup(0);
	@Test
	public void test() {
		cup.roll();
		assertEquals(cup.getD1(),cup.getD2());
	}
}
