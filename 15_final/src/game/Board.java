package game;
import board.*;
public class Board {
	Square[] squares = new Square[40];
	public Board(){
	
	squares[0] = new Territory("Tribe Encampment", 1, 1000, 100);
	squares[1] = new Fleet("Second Sail", 2, 4000);
	squares[2] = new Territory("Crater", 3,  1500, 300);
	squares[3] = new Refuge("Walled city", 4, 5000);
	squares[4] = new LaborCamp("Huts in the mountain", 5, 2500);
	squares[5] = new Territory("Mountain", 6, 2000, 500);
	squares[6] = new Fleet("Sea Grover", 7, 4000);
	squares[7] = new Territory("Cold Desert", 8, 3000, 700);
	squares[8] = new Territory("Black Cave", 9, 4000, 1000);
	squares[9] = new Tax("Goldmine", 10, 2000);
	squares[10] = new Territory("Werewall", 11, 4300, 1300);
	squares[11] = new Territory("Mountain Village", 12, 4750, 1600);
	squares[12] = new Fleet("Buccaneers", 13, 4000);
	squares[13] = new Territory("South Citadel", 14, 5000, 2000);
	squares[14] = new Refuge("Monastery", 15, 500);
	squares[15] = new LaborCamp("The pit", 16, 2500);
	squares[16] = new Territory("Palace Gates", 17, 5500, 2600);
	squares[17] = new Fleet("Privateer armada", 18, 4000);
	squares[18] = new Tax("Caravan", 19, 4000);
	squares[19] = new Territory("Tower", 20, 6000, 3200);
	squares[20] = new Territory("Castle", 21, 8000, 4000);
	squares[21] = new Fleet("Second Sail", 2, 4000);
	squares[22] = new Territory("Crater", 3,  1500, 300);
	squares[23] = new Refuge("Walled city", 4, 5000);
	squares[24] = new LaborCamp("Huts in the mountain", 5, 2500);
	squares[25] = new Territory("Mountain", 6, 2000, 500);
	squares[26] = new Fleet("Sea Grover", 7, 4000);
	squares[27] = new Territory("Cold Desert", 8, 3000, 700);
	squares[28] = new Territory("Black Cave", 9, 4000, 1000);
	squares[29] = new Tax("Goldmine", 10, 2000);
	squares[30] = new Territory("Werewall", 11, 4300, 1300);
	squares[31] = new Territory("Mountain Village", 12, 4750, 1600);
	squares[32] = new Fleet("Buccaneers", 13, 4000);
	squares[33] = new Territory("South Citadel", 14, 5000, 2000);
	squares[34] = new Refuge("Monastery", 15, 500);
	squares[35] = new LaborCamp("The pit", 16, 2500);
	squares[36] = new Territory("Palace Gates", 17, 5500, 2600);
	squares[37] = new Fleet("Privateer armada", 18, 4000);
	squares[38] = new Tax("Caravan", 19, 4000);
	squares[39] = new Territory("Tower", 20, 6000, 3200);
	}
	/*
	 * Method to retrieve information, from one specific square.
	 */
	public Square getSquare(int ren) {
		return squares[ren];
	}
}
