package entities;
import java.util.ArrayList;

import board.Parking;
import board.Square;
import board.Tax;
import board.Territory;
import cards.Card;
/**
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class AllCards { 
	Card theCards[] = new Card[40];
			
	public AllCards(ArrayList<Player> thePlayers) { // 
		theCards[0] = new Territory("Start", 1, 1000, 100);
		theCards[1] = new Territory("Rødovrevej", 2, 4000, 324);
		theCards[2] = new Territory("Prøv lykken", 3,  1500, 300);
		theCards[3] = new Territory("Hvidovrevej", 4, 5000,234);
		theCards[4] = new Tax("Indkomstskat",5, 2000);
		theCards[5] = new Territory("Scandlines Helsingør-Helsingborg", 6, 2000, 500);
		theCards[6] = new Territory("Roskildevej", 7, 4000,234);
		theCards[7] = new Territory("Prøv lykken", 8, 3000, 700);
		theCards[8] = new Territory("Valby Langgade", 9, 4000, 1000);
		theCards[9] = new Territory("Allégade", 10, 2000,234);
		theCards[10] = new Territory("Fængsel - besøg", 11, 4300, 1300);
		theCards[11] = new Territory("Frederiksberg Allé", 12, 4750, 1600);
		theCards[12] = new Territory("Tuborg Squash", 13, 4000,312);
		theCards[13] = new Territory("Bülowsvej", 14, 5000, 2000);
		theCards[14] = new Territory("Gl. Kongevej", 15, 500,324);
		theCards[15] = new Territory("Mols-linien", 16, 2500,234);
		theCards[16] = new Territory("Bernstorffsvej", 17, 5500, 2600);
		theCards[17] = new Territory("Prøv lykken", 18, 4000,234);
		theCards[18] = new Territory("Hellerupvej", 19, 4000,213);
		theCards[19] = new Territory("Strandvejen", 20, 6000, 3200);
		theCards[20] = new Parking("Parkering", 21);
		theCards[21] = new Territory("Trianglen", 2, 4000,124);
		theCards[22] = new Territory("Prøv Lykken", 3,  1500, 300);
		theCards[23] = new Territory("Østerbrogade", 4, 5000,234);
		theCards[24] = new Territory("Grønningen", 5, 2500,634);
		theCards[25] = new Territory("Scandlines Gedser-Rostock", 6, 2000, 500);
		theCards[26] = new Territory("Bredgade", 7, 4000,2321);
		theCards[27] = new Territory("Kgs. Nytorv", 8, 3000, 700);
		theCards[28] = new Territory("Coca Cola", 9, 4000, 1000);
		theCards[29] = new Territory("Østerbrogade", 10, 2000,245);
		theCards[30] = new Territory("Fængslet", 11, 4300, 1300);
		theCards[31] = new Territory("Amagertorv", 12, 4750, 1600);
		theCards[32] = new Territory("Vimmelskaftet", 13, 4000,2131);
		theCards[33] = new Territory("Prøv lykken", 14, 5000, 2000);
		theCards[34] = new Territory("Nygade", 15, 500,234);
		theCards[35] = new Territory("Scandllines Rødby-Puttgaarden", 16, 2500,464);
		theCards[36] = new Territory("Prøv lykken", 17, 5500, 2600);
		theCards[37] = new Territory("Frederiksberggade", 18, 4000,234);
		theCards[38] = new Tax("Ekstraordinær statsskat", 19,2000 );
		theCards[39] = new Territory("Rådhuspladsen", 20, 6000, 3200);
		theCards[39] = new Territory("Rådhuspladsen", 20, 6000, 3200);
	}
		public Card getCard(int cho) {
			return theCards[cho];
		}
}
