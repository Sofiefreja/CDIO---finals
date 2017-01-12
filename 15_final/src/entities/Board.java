package entities;

import java.util.ArrayList;
import board.*;
import board.Tax;
import board.Parking;

/**
 * Keeps track of all the squares, in an array.
 * 
 * @author Jonas Larsen s136335
 * @author Sofie Freja Christensen s153932
 * 
 */
public class Board {
	Square[] squares = new Square[40];
	private AllCards allTheCards;

	/**
	 * Constructor for a Board
	 * 
	 * @param theCup
	 */
	public Board(Cup theCup, ArrayList<Player> thePlayers, boolean testMode) {

		allTheCards = new AllCards(thePlayers, this);

		if (testMode == false)
			allTheCards.shuffle();

		squares[0] = new Start("Start", 1);
		squares[1] = new Street("Rødovrevej", 2, 1200, 600, 1000, 50, 250, 750, 2250, 4000, 6000, 'A');
		squares[2] = new Chance("Prøv lykken", 3, allTheCards);
		squares[3] = new Street("Hvidovrevej", 4, 1200, 600, 1000, 50, 250, 750, 2250, 4000, 6000, 'A');
		squares[4] = new Tax("Indkomstskat", 5, 4000);
		squares[5] = new Shipping("Scandlines Helsingør-Helsingborg", 6);
		squares[6] = new Street("Roskildevej", 7, 2000, 1000, 1000, 100, 600, 1800, 5400, 8000, 11000, 'B');
		squares[7] = new Chance("Prøv lykken", 8, allTheCards);
		squares[8] = new Street("Valby Langgade", 9, 2000, 1000, 1000, 100, 600, 1800, 5400, 8000, 11000, 'B');
		squares[9] = new Street("Allégade", 10, 2400, 1200, 1000, 150, 800, 2000, 6000, 9000, 1200, 'B');
		squares[10] = new Parking("Fængsel - besøg", 11);
		squares[11] = new Street("Frederiksberg Allé", 12, 2800, 1400, 2000, 200, 1000, 3000, 9000, 12500, 15000, 'C');
		squares[12] = new Brewery("Tuborg", 13, theCup);
		squares[13] = new Street("Bülowsvej", 14, 2800, 1400, 2000, 200, 1000, 3000, 9000, 12500, 15000, 'C');
		squares[14] = new Street("Gl. Kongevej", 15, 3200, 1800, 2000, 250, 1250, 3750, 10000, 14000, 18000, 'C');
		squares[15] = new Shipping("Mols-linien", 16);
		squares[16] = new Street("Bernstorffsvej", 17, 3600, 1800, 2000, 300, 1400, 4000, 11000, 15000, 19000, 'D');
		squares[17] = new Chance("Prøv lykken", 18, allTheCards);
		squares[18] = new Street("Hellerupvej", 19, 3600, 1800, 2000, 300, 1400, 4000, 11000, 15000, 19000, 'D');
		squares[19] = new Street("Strandvejen", 20, 4000, 2000, 2000, 350, 1600, 4400, 12000, 16000, 20000, 'D');
		squares[20] = new Parking("Parkering", 21);
		squares[21] = new Street("Trianglen", 22, 4400, 2200, 3000, 350, 1800, 5000, 14000, 17500, 21000, 'E');
		squares[22] = new Chance("Prøv lykken", 23, allTheCards);
		squares[23] = new Street("Østerbrogade", 24, 4400, 2200, 3000, 350, 1800, 5000, 14000, 17500, 21000, 'E');
		squares[24] = new Street("Grønningen", 25, 4800, 2400, 3000, 400, 2000, 6000, 15000, 18500, 22000, 'E');
		squares[25] = new Shipping("Scandlines Gedser-Rostock", 26);
		squares[26] = new Street("Bredgade", 27, 5200, 2600, 3000, 450, 2200, 6600, 16000, 19500, 23000, 'F');
		squares[27] = new Street("Kgs. Nytorv", 28, 5200, 2600, 3000, 450, 2200, 6600, 16000, 19500, 23000, 'F');
		squares[28] = new Brewery("Carlsberg", 29, theCup);
		squares[29] = new Street("Østergade", 30, 5600, 2800, 3000, 500, 2400, 7200, 17000, 20500, 24000, 'F');
		squares[30] = new Jail("Fængslet", 31);
		squares[31] = new Street("Amagertorv", 32, 6000, 3000, 4000, 550, 2600, 7800, 18000, 22000, 25000, 'G');
		squares[32] = new Street("Vimmelskaftet", 33, 6000, 3000, 4000, 550, 2600, 7800, 18000, 22000, 25000, 'G');
		squares[33] = new Chance("Prøv lykken", 34, allTheCards);
		squares[34] = new Street("Nygade", 35, 6400, 3200, 4000, 600, 3000, 9000, 20000, 24000, 28000, 'G');
		squares[35] = new Shipping("Scandllines Rødby-Puttgaarden", 36);
		squares[36] = new Chance("Prøv lykken", 37, allTheCards);
		squares[37] = new Street("Frederiksberggade", 38, 7000, 3500, 4000, 700, 3500, 10000, 22000, 26000, 30000, 'H');
		squares[38] = new Tax("Ekstraordinær statsskat", 39, 2000);
		squares[39] = new Street("Rådhuspladsen", 40, 8000, 4000, 4000, 1000, 4000, 12000, 28000, 34000, 40000, 'H');

	}

	/**
	 * Method for returning a square from the array in this instance.
	 * 
	 * @param index
	 * @return Square
	 */
	public Square getSquare(int index) {
		return squares[index];
	}

}
