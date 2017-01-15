package test;


import entities.Player;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestBonus {

	Player p1;
	String name="Simon";
	int initBalance=0;
	int orgCurrentPosition=33;
	int orgPreviousPosition=27;
	
	@Before
	public void setUp(){
		p1= new Player(name, initBalance);
		p1.setPosition(orgCurrentPosition, orgPreviousPosition);
		assertTrue(p1.toString().equals(name));
		assertFalse(p1.getJailStatus());
		assertEquals(p1.getBalance(),initBalance);
		assertEquals(p1.getCurrentPosition(),orgCurrentPosition);
		assertEquals(p1.getPreviousPosition(),orgPreviousPosition);
	}
	@After
	public void tearDown(){
		p1 = new Player(name,initBalance);
		p1.setPosition(orgCurrentPosition, orgPreviousPosition);
	}
	@Test
	public void conditions1() {
		int rollValue = 4;
		p1.setFirstRound(false);
		p1.setPosition(p1.getCurrentPosition()+rollValue, p1.getCurrentPosition());
		//uses the same algorithm as in GUIControl.moveVehicle()
		for (int i = 0; i < rollValue; i++) {//Sets the player on one spot after another to simulate a piece moving on the board
			if ((p1.getPreviousPosition() + i + 1) % 40 + 1 == 2) {//if the player has passed the Start field
				if (p1.getFirstRound() == false && p1.getCurrentPosition() != 10) {
					p1.deposit(4000);
				} else {
					p1.setFirstRound(false);
				}
			}
		}
		assertFalse(p1.getBalance()>initBalance);
	}
	@Test
	public void conditions2(){
		int rollValue=7;
		p1.setFirstRound(false);
		p1.setPosition(p1.getCurrentPosition()+rollValue,p1.getCurrentPosition());
		for (int i = 0; i < rollValue; i++) {//Sets the player on one spot after another to simulate a piece moving on the board
			if ((p1.getPreviousPosition() + i + 1) % 40 + 1 == 2) {//if the player has passed the Start field
				if (p1.getFirstRound() == false && p1.getCurrentPosition() != 10) {
					p1.deposit(4000);
				} else {
					p1.setFirstRound(false);
				}
			}
		}
		assertFalse(p1.getBalance()>initBalance);
	}
	@Test
	public void conditions3(){
		int rollValue=10;
		p1.setFirstRound(false);
		p1.setPosition(p1.getCurrentPosition()+rollValue,p1.getCurrentPosition());
		for (int i = 0; i < rollValue; i++) {//Sets the player on one spot after another to simulate a piece moving on the board
			if ((p1.getPreviousPosition() + i + 1) % 40 + 1 == 2) {//if the player has passed the Start field
				if (p1.getFirstRound() == false && p1.getCurrentPosition() != 10) {
					p1.deposit(4000);
				} else {
					p1.setFirstRound(false);
				}
			}
		}
		assertTrue(p1.getBalance()>initBalance);
	}
	@Test
	public void conditions4(){
		p1.setPosition(0, 0);
		int rollValue=10;
		p1.setPosition(10, 0);
		p1.setPosition(p1.getCurrentPosition()+rollValue,p1.getCurrentPosition());
		for (int i = 0; i < rollValue; i++) {//Sets the player on one spot after another to simulate a piece moving on the board
			if ((p1.getPreviousPosition() + i + 1) % 40 + 1 == 2) {//if the player has passed the Start field
				if (p1.getFirstRound() == false && p1.getCurrentPosition() != 10) {
					p1.deposit(4000);
				} else {
					p1.setFirstRound(false);
				}
			}
		}
		assertFalse(p1.getBalance()>initBalance);
	}
}