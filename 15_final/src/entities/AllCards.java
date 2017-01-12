package entities;
import java.util.ArrayList;

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
import controller.msgL;
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
	 * @param thePlayers of the game
	 * @param theBoard of the game
	 */
	public AllCards(ArrayList<Player> thePlayers, Board theBoard) { 
		theCards = new Card[44];
		
		theCards[0] = new Pardon(msgL.msg(156));
		theCards[1] = new GoToJail(msgL.msg(147));
		theCards[2] = new PlayerTransaction(msgL.msg(132), 200, thePlayers);
		theCards[3] = new ChangePosition(msgL.msg(133), 3, theBoard);
		theCards[4] = new IncomeIncrease(msgL.msg(134),1000);
		theCards[5] = new IncomeIncrease(msgL.msg(135), 1000);
		theCards[6] = new Expense(msgL.msg(136), 300);
		theCards[7] = new IncomeIncrease(msgL.msg(137), 1000);
		theCards[8] = new IncomeIncrease(msgL.msg(137), 1000);
		theCards[9] = new Grant(msgL.msg(138), 40000);
		theCards[10] = new MoveToSquare(msgL.msg(139), 0, theBoard);
		theCards[11] = new MoveToSquare(msgL.msg(139), 0, theBoard);
		theCards[12] = new PlayerTransaction(msgL.msg(140), 500, thePlayers);
		theCards[13] = new MoveToSquare(msgL.msg(141), 39 ,theBoard);
		theCards[14] = new MovetoShip(msgL.msg(142),theBoard);
		theCards[15] = new Expense(msgL.msg(143), 1000);
		theCards[16] = new Expense(msgL.msg(144), 200);
		theCards[17] = new Expense(msgL.msg(145), 200);
		theCards[18] = new MovetoShip(msgL.msg(146),theBoard);
		theCards[19] = new MoveToSquare(msgL.msg(131), 11, theBoard);
		theCards[20] = new GoToJail(msgL.msg(147));
		theCards[21] = new PriceIncrease(msgL.msg(148), 500, 2000);
		theCards[22] = new IncomeIncrease(msgL.msg(149), 1000);
		theCards[23] = new IncomeIncrease(msgL.msg(149), 1000);
		theCards[24] = new MovetoShip(msgL.msg(150),theBoard);
		theCards[25] = new MovetoShip(msgL.msg(150), theBoard);
		theCards[26] = new MoveToSquare(msgL.msg(186), 19 ,theBoard);
		theCards[27] = new Expense(msgL.msg(151), 1000);
		theCards[28] = new IncomeIncrease(msgL.msg(152), 4000);
		theCards[29] = new IncomeIncrease(msgL.msg(153), 500);
		theCards[30] = new IncomeIncrease(msgL.msg(153), 500);
		theCards[31] = new MoveToSquare(msgL.msg(154), 32,theBoard);
		theCards[32] = new ChangePosition(msgL.msg(155), 3,theBoard);
		theCards[33] = new ChangePosition(msgL.msg(155), 3,theBoard);
		theCards[34] = new PriceIncrease(msgL.msg(130), 800, 2300);
		theCards[35] = new Pardon(msgL.msg(156));
		theCards[36] = new Expense(msgL.msg(157), 3000);
		theCards[37] = new Expense(msgL.msg(157), 3000);
		theCards[38] = new IncomeIncrease(msgL.msg(158), 1000);
		theCards[39] = new Expense(msgL.msg(159), 200);
		theCards[40] = new MoveToSquare(msgL.msg(160), 24,theBoard);
		theCards[41] = new IncomeIncrease(msgL.msg(161), 3000);
		theCards[42] = new PlayerTransaction(msgL.msg(162), 500, thePlayers);
		theCards[43] = new Expense(msgL.msg(163), 1000);
	}
	/**
	 * Method which takes an int as a parameter 
	 * and returns that index from the 'theCards' array of this instance 
	 * @param index [0:43]
	 * @return Card
	 */
	public Card getCard(int index) {
		return theCards[index];
	}
	/**
	 * Shuffles the cards
	 */
	public void shuffle(){
		Random r = new Random();
		
		for(int last = theCards.length-1; last > 0; last--){
			int i = r.nextInt(last+1);
			Card tmp = theCards[last];
			theCards[last] = theCards[i];
			theCards[i] = tmp;
		}
	}
}































