package test;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	
	Player p1 = new Player("Simon", 30000);
	
	@Test
	public void test() {
		
		p1.buySquare((Ownable) theBoard.getSquare(1));
		p1.buySquare((Ownable) theBoard.getSquare(3));
		p1.buySquare((Ownable) theBoard.getSquare(6));
		p1.buySquare((Ownable) theBoard.getSquare(8));
		p1.buySquare((Ownable) theBoard.getSquare(11));
		p1.buySquare((Ownable) theBoard.getSquare(13));
		p1.buySquare((Ownable) theBoard.getSquare(14));
		
		String[] buildableList = p1.getBuildableList();
		
		System.out.println(Arrays.toString(buildableList));
		
	}
}

