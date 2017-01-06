package controller;

import java.util.ArrayList;

import desktop_resources.GUI;
import entities.AllCards;
import entities.Board;
import entities.Cup;
import entities.Player;

public class GameLogic {

	private GUIControl GUIGame;
	private Board theBoard;
	private Cup theCup;
	private boolean firstTurn;
	private int firstRound;
	private int numberOfPlayers;
	private String[] playerNames;
	private ArrayList<Player> thePlayers;
	private int equalEyeCounter;

	/**
	 * @author Jonas Larsen s136335
	 */

	public GameLogic() {
		
		// Initializing the game.
		 

		GUIGame = new GUIControl();
		GUIGame.makeBoard();
		theCup = new Cup();
		theBoard = new Board(theCup);
		// AllCards theCards = new AllCards(thePlayers);
		

		// The players are initialized
		createPlayers();

		// Beginning the game.
		firstTurn = true;
		firstRound = 0;
		numberOfPlayers = playerNames.length;
		equalEyeCounter = 0;
 
		// The game should run until one player remains in the ArrayList.
		while (thePlayers.size() > 1) { 
									
			// The for loop running through all the players.
			for (int i = 0; i < thePlayers.size(); i++) { 

				// If only one player is left, the 'else' runs and breaks the for loop
				if (thePlayers.size() != 1) { 

					// Creating menues for the player based on property or status.
					String[] valg = getMenu(thePlayers.get(i));
					String turn = GUIGame.getUserInputTurn(thePlayers.get(i), valg); 
					
					
					//All the if statements for Player choices on start of turn.
					
					
					if (turn.equals("Rul")) {

						theCup.roll();
						GUIGame.showDice(theCup);
						
						//All the if statements for different scenarios a player can be in when rolling.
						
						
						if (thePlayers.get(i).getJailStatus()) {

							doJail(thePlayers.get(i));

						} else if (equalEyeCounter != 3) {

							doMoveVehicle(thePlayers.get(i));

							// If the dice is equals turn resets
							if (theCup.getEquals() == true) {
								i--;
								equalEyeCounter++;
							}else
								equalEyeCounter = 0;

						} else { // Puts the player in jail if equalEyeCounter hits 3.
							thePlayers.get(i).setJailStatus(true);
							equalEyeCounter = 0;
						}

						
					} else if (turn.equals("Sælg")) {

						System.out.println("Shit");

					} else if (turn.equals("Pantsætning")) {
						System.out.println("Shit");

					} else if (turn.equals("Køb huse eller hotel")) {
						System.out.println("Shit");

					} else if (turn.equals("Sælg huse eller hotel")) {
						System.out.println("Shit");

					}
					
					else if (turn.equals("Giv op")) {
						GUIGame.removePlayer(thePlayers.get(i));
						//missing removePlayer 
						thePlayers.remove(i);
						i--;

					} else { // Breaks the forloop because winner is found.
						break;
					}
				}

			}
			GUIGame.showWinner(thePlayers.get(0)); // Shows the winner.
			GUIGame.endGUI();
		}
	}

	/**
	 *  Asks for number of players, their names and creates an arraylist of players.
	 */
	
	private void createPlayers() {
		// String[] playerNames = GUIGame.numberOfPlayers(); // Ask how many
		// players there are
		// in the game.

		// For testing.
		playerNames = new String[4];
		playerNames[0] = "Morten";
		playerNames[1] = "Jonas";
		playerNames[2] = "Simon";
		playerNames[3] = "Emily";

		/*
		 * Creating the players. By using an array, the names are saved in each
		 * of their own index'es in the array.
		 */
		thePlayers = new ArrayList<Player>();

		// Save all the players in a ArrayList.

		for (int i = 0; i < playerNames.length; i++) {
			thePlayers.add(new Player(playerNames[i])); // Creating player
														// objects for the game
			GUIGame.createPlayer(thePlayers.get(i)); // Creating Player objects
														// for the GUI

		}
	}

	private String[] getMenu(Player theplayer) {
		ArrayList<String> A = new ArrayList<>();

		if (theplayer.getBalance() < 0) {
			if (theplayer.hasHouse == true) {
				A.add("Sælg");
			}
			if (theplayer.hasProperty == true) {
				A.add("Pantsætning");
			}
			A.add("Giv op");
		} else {
			if (theplayer.hasProperty == true) {
				A.add("Køb huse eller hotel");
				A.add("Pantsætning");
				if (theplayer.hasHouse == true) {
					A.add("Sælg huse eller hotel");
				}
			}
			A.add("Rul");
			A.add("Giv op");

		}
		// Converting the Arraylist to an Array.

		return A.toArray(new String[A.size()]);
	}

	private void doMoveVehicle(Player theplayer) {
		if (firstTurn) {
			theplayer.setPosition(theCup.getSum());
			GUIControl.moveVehicle(theplayer);
			firstRound++;

			// First turn
			if (firstRound == numberOfPlayers) {
				firstTurn = false;
			}

		} else { // A normal turn.
			theplayer.moveVehicle(theCup.getSum());
			GUIControl.moveVehicle(theplayer);

		}
		// Call the landOnSquare(Player --- )
		int newPosition = theplayer.getCurrentPosition();
		theBoard.getSquare(newPosition).landOnSquare(theplayer);
	}

	private void doJail(Player theplayer) {
		if (theCup.getEquals()) {
			doMoveVehicle(theplayer);
			theplayer.setJailStatus(false);
		}
		// Print til gui hvad det skal være.
		else if (theplayer.getJailCounter() == 3) {

			theplayer.withdraw(1000);
			theplayer.setJailStatus(false);
			doMoveVehicle(theplayer);
		} else {
			// der sker ikke noget.
		}
		equalEyeCounter = 0;
	}
}
