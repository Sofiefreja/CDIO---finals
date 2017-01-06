package entities;
import board.*;
import board.Tax;
import board.Parking;
/**
 * Keeps track of all the squares, in an array.
 * @author Jonas Larsen s136335
 * @author Sofie Freja Christensen s153932
 */
public class Board {
	Square[] squares = new Square[40];
	/**
	 * An array of the type square. In these indexes, It's defined which type
	 * of square it is, and prices and rents of the different squares. 
	 */
	
	public Board(){
		squares[0] = new Start ("Start", 1);
		squares[1] = new Street("Rødovrevej", 2, 1200, 600, 1000, 'A');
		squares[2] = new Territory("Prøv lykken", 3,  1500, 300);
		squares[3] = new Territory("Hvidovrevej", 4, 5000,234);
		squares[4] = new Tax("Indkomstskat",5, 2000);
		squares[5] = new Territory("Scandlines Helsingør-Helsingborg", 6, 2000, 500);
		squares[6] = new Territory("Roskildevej", 7, 4000,234);
		squares[7] = new Territory("Prøv lykken", 8, 3000, 700);
		squares[8] = new Territory("Valby Langgade", 9, 4000, 1000);
		squares[9] = new Territory("Allégade", 10, 2000,234);
		squares[10] = new Territory("Fængsel - besøg", 11, 4300, 1300);
		squares[11] = new Territory("Frederiksberg Allé", 12, 4750, 1600);
		squares[12] = new Territory("Tuborg", 13, 4000,312);
		squares[13] = new Territory("Bülowsvej", 14, 5000, 2000);
		squares[14] = new Territory("Gl. Kongevej", 15, 500,324);
		squares[15] = new Territory("Mols-linien", 16, 2500,234);
		squares[16] = new Territory("Bernstorffsvej", 17, 5500, 2600);
		squares[17] = new Territory("Prøv lykken", 18, 4000,234);
		squares[18] = new Territory("Hellerupvej", 19, 4000,213);
		squares[19] = new Territory("Strandvejen", 20, 6000, 3200);
		squares[20] = new Parking("Parkering", 21);
		squares[21] = new Territory("Trianglen", 2, 4000,124);
		squares[22] = new Territory("Prøv Lykken", 3,  1500, 300);
		squares[23] = new Territory("Østerbrogade", 4, 5000,234);
		squares[24] = new Territory("Grønningen", 5, 2500,634);
		squares[25] = new Territory("Scandlines Gedser-Rostock", 6, 2000, 500);
		squares[26] = new Territory("Bredgade", 7, 4000,2321);
		squares[27] = new Territory("Kgs. Nytorv", 8, 3000, 700);
		squares[28] = new Territory("Carlsberg", 9, 4000, 1000);
		squares[29] = new Territory("Østerbrogade", 10, 2000,245);
		squares[30] = new Territory("Fængslet", 11, 4300, 1300);
		squares[31] = new Territory("Amagertorv", 12, 4750, 1600);
		squares[32] = new Territory("Vimmelskaftet", 13, 4000,2131);
		squares[33] = new Territory("Prøv lykken", 14, 5000, 2000);
		squares[34] = new Territory("Nygade", 15, 500,234);
		squares[35] = new Territory("Scandllines Rødby-Puttgaarden", 16, 2500,464);
		squares[36] = new Territory("Prøv lykken", 17, 5500, 2600);
		squares[37] = new Territory("Frederiksberggade", 18, 4000,234);
		squares[38] = new Tax("Ekstraordinær statsskat", 19,2000 );
		squares[39] = new Territory("Rådhuspladsen", 20, 6000, 3200);
		
	}
	/**
	 * 
	 * @param ren
	 * @return squares
	 */
	public Square getSquare(int ren) {
		return squares[ren];
	}
}
