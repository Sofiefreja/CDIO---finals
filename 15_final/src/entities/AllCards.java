package entities;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import cards.Card;
import cards.ChangePosition;
import cards.Expense;
import cards.GoToJail;
import cards.Grant;
import cards.IncomeIncrease;
import cards.MoveToSquare;
import cards.MovetoShip;
import cards.Pardon;
import cards.PlayerTransaction;
import cards.PriceIncrease;
/**
 * Class for holding all Cards
 * 
 * @author Sofie Freja Christensen s153932
 *
 */
public class AllCards { 
	Card theCards[];
	
	/**
	 * Creating an AllCards instance
	 * @param thePlayers
	 */
	public AllCards(List<Player> thePlayers, Board theBoard) { // 
		theCards = new Card[44];
		
		
		theCards[0] = new PriceIncrease("Ejendomsskatterne er steget. Ekstraudgifterne er: 800 kr. pr. hus, 2.300 kr. pr. hotel", 800, 2300);
		theCards[1] = new ChangePosition("Ryk frem til Frederiksberg Allé. Hvis de passerer 'START', indkassér da 4.000 kr.", 37, theBoard);//Kig lige
		theCards[2] = new PlayerTransaction("Det er deres fødselsdag. Modtag af hver medspiller", 200, thePlayers);
		theCards[3] = new ChangePosition("Ryk tre felter frem", 3, theBoard);
		theCards[4] = new IncomeIncrease("De modtager deres aktieudbytte. Modtag 1.000 kr. af banken.",1000);
		theCards[5] = new IncomeIncrease("Grundet dyrtiden har De fået gageforhøjelse. Modtag 1.000 kr.", 1000);
		theCards[6] = new Expense("Betal for vognvask og smøring", 300);
		theCards[7] = new IncomeIncrease("Deres præmieobligation er udtrukket. De modtager 1.000 kr. af banken.", 1000);
		theCards[8] = new IncomeIncrease("Deres præmieobligation er udtrukket. De modtager 1.000 kr. af banken.", 1000);
		theCards[9] = new Grant("De modtager 'Matador-legatet for værdigt trængende' på 40.000. Ved værdigt trængende forstås, at deres formue, dvs. deres kontante penge + skøder + bygninger ikke overstiger 15.000 kr.", 40000);
		theCards[10] = new MoveToSquare("Ryk frem til 'START'", 0, theBoard);//Kig lige
		theCards[11] = new MoveToSquare("Ryk frem til 'START'", 0, theBoard);//Kig lige
		theCards[12] = new PlayerTransaction("De skal holde familiefest og har fået et tilskud fra hver medspiller på 500 kr.", 500, thePlayers);
		theCards[13] = new MoveToSquare("Tag ind på Rådhuspladsen", 0,theBoard);//Kige lige
		theCards[14] = new MovetoShip("Tag med Mols-Linien. Flyt brikken frem, og hvis de passerer 'START', indkassér da 4.000 kr.",theBoard);
		theCards[15] = new Expense("De har købt 4 nye dæk til Deres vogn. Betal 1.000 kr.", 1000);
		theCards[16] = new Expense("De har fået en parkeringsbøde. Betal 200 kr. i bøde.", 200);
		theCards[17] = new Expense("Betal 200 kr. for levering af 2 kasser øl.", 200);
		theCards[18] = new MovetoShip("Tag med den nærmeste færge. Flyt brikken frem, og hvis de passerer 'START', indkassér da 4.000 kr.",theBoard);
		theCards[19] = new GoToJail("Gå i fængsel. Ryk direkte til fængslet. Selvom de passerer 'START', indkasserer de ikke 4.000 kr.");
		theCards[20] = new GoToJail("Gå i fængsel. Ryk direkte til fængslet. Selvom de passerer 'START', indkasserer de ikke 4.000 kr.");
		theCards[21] = new PriceIncrease("Oliepriserne er steget, og de skal betale: 500 kr. pr. hus, 2.000 kr. pr. hotel", 500, 2000);
		theCards[22] = new IncomeIncrease("Modtag udbytte af deres aktier - 1.000 kr.", 1000);
		theCards[23] = new IncomeIncrease("Modtag udbytte af deres aktier - 1.000 kr.", 1000);
		theCards[24] = new MovetoShip("Ryk brikken frem til det nærmeste rederi og betal lejern to gane leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan du købe det af banken.",theBoard);
		theCards[25] = new MovetoShip("Ryk brikken frem til det nærmeste rederi og betal lejeren to gange leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan du købe det af banken.", theBoard);
		theCards[26] = new MoveToSquare("Ryk frem til Strandvejen. Hvis du passerer start, indkassér 4.000 kr.", 0,theBoard);// Kig lige
		theCards[27] = new Expense("Betal deres bilforsikring - 1.000 kr.", 1000);
		theCards[28] = new IncomeIncrease("De havde en række med elleve rigtige i tipning. Modtag 4.000 kr.", 4000);
		theCards[29] = new IncomeIncrease("De har vundet i klasselotteriet. Modtag 500 kr.", 500);
		theCards[30] = new IncomeIncrease("De har vundet i klasselotteriet. Modtag 500 kr.", 500);
		theCards[31] = new MoveToSquare("Ryk frem til Vimmelskaftet. Hvis de passerer start, indkassér da 4.000 kr.", 0,theBoard);// Kig lige
		theCards[32] = new ChangePosition("Ryk tre felter tilbage", 0,theBoard);//Kige lige
		theCards[33] = new ChangePosition("Ryk tre felter tilbage", 0,theBoard);//Kig lige
		theCards[34] = new Pardon("I andledningen af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det.");
		theCards[35] = new Pardon("I andledningen af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det.");
		theCards[36] = new Expense("Betal 3.000 kr. for reparation af deres vogn.", 3000);
		theCards[37] = new Expense("Betal 3.000 kr. for reparation af deres vogn.", 3000);
		theCards[38] = new IncomeIncrease("De har solgt nogle gamle møbler på aukion. Modtag 1.000 kr. af banken.", 1000);
		theCards[39] = new Expense("De har været en tur i udlandet og haft mange cigaretter med hjem. Betal 200 kr. i told.", 200);
		theCards[40] = new MoveToSquare("Ryk frem til Grønningen. Hvis de passerer start indkassér da 4000 kr.", 0,theBoard);// Kig lige
		theCards[41] = new IncomeIncrease("Kommunen har eftergivet et kvartals skat. Hæv i banken 3.000 kr.", 3000);
		theCards[42] = new PlayerTransaction("De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag 500 kr. fra hver spiller", 500, thePlayers);
		theCards[43] = new Expense("De har kørt frem for 'Fuldt stop'. Betal 1.000 kr. i bøde.", 1000);
	}
	/**
	 * Method which takes an int as a parameter 
	 * and returns that index from the 'theCards' array of this instance 
	 * @param index
	 * @return Card
	 */
	public Card getCard(int index) {
		return theCards[index];
	}
	
	public void shuffle(){
		Random r = new Random();
		
		for(int last = theCards.length-1; last > 0; last--){
			int i = r.nextInt(last+1);
			
			// Swap
			Card tmp = theCards[last];
			theCards[last] = theCards[i];
			theCards[i] = tmp;
		}
	}
	
//	public static void main(String[] args) {
//		AllCards a = new AllCards(null, null);
//		for(Card c : a.theCards){
//			System.out.println(c);
//		}
//		
//		a.shuffle();
//		System.out.println("=====================================================");
//		
//		for(Card c : a.theCards){
//			System.out.println(c);
//		}
//	}
}































