package controller;
import controller.*;
import java.util.ArrayList;
import desktop_resources.GUI;
import board.*;
import entities.Player;
import board.Square;
import entities.Cup;
import entities.Board;

public class Game {
	public Game() {
		/*
		 * Initializing the game.
		 */
		GUIControl GUIGame = new GUIControl();
		GUIGame.makeBoard();
		Board theBoard = new Board();
		Cup theCup = new Cup();
		/*
		 * The players are initialized
		 */
		String[] playerNames = GUIGame.numberOfPlayers(); // Ask how many
															// players there are
															// in the game.
		/*
		 * Creating the players. By using an array, the names are saved in each
		 * of their own index'es in the array.
		 */
		ArrayList<Player> thePlayers = new ArrayList<Player>(); // Save all the
																// players in a
																// ArrayList.

		for (int i = 0; i < playerNames.length; i++) {
			thePlayers.add(new Player(playerNames[i])); //Creating player objects for the game
			GUIGame.createPlayer(thePlayers.get(i)); // Creating Player objects for the GUI
			

		}
		
		/*
		 * Beginning the game.
		 */
		boolean firstTurn = true;
		int firstRound = 0;
		int numberOfPlayers = playerNames.length;

		while (thePlayers.size() > 1) { // The game should run until one player
										// remains in the ArrayList.

			for (int i = 0; i < thePlayers.size(); i++) { // The // for loop
															// running through
															// all the players.

				if (thePlayers.size() != 1) { // If only one player are left,
												// then 'else' runs and breaks
												// the for loop.

					String turn = GUIGame.getUserInputTurn(thePlayers.get(i)); // Ask
					// what the player what to do.

					if (turn.equals("Roll")) {
						theCup.roll();
						GUIGame.showDice(theCup);

						// Move the Vehicle on board.
						if (firstTurn == true) {
							thePlayers.get(i).setPosition(theCup.getSum());
							GUIGame.moveVehicle(thePlayers.get(i));
							firstRound++;

							// First turn
							if (firstRound == numberOfPlayers) {
								firstTurn = false;
							}

						} else { // A normal turn.
							thePlayers.get(i).moveCar(theCup.getSum());
							GUIGame.moveVehicle(thePlayers.get(i));

						}
						// Call the landOnSquare(Player --- )
						int newPosition = thePlayers.get(i).getCurrentPosition();
						theBoard.getSquare(newPosition).landOnSquare(thePlayers.get(i));
						if (thePlayers.get(i).getBalance() < 0) {
							GUIGame.removePlayer(thePlayers.get(i));
							thePlayers.remove(i);
							i--;

						}
						// The player Surrenders.
					} else if (turn.equals("Surrender")) {
						GUIGame.removePlayer(thePlayers.get(i));
						thePlayers.remove(i);
						i--;

					}
				} else { // Breaks the forloop.
					break;
				}
			}

		}
		GUIGame.showWinner(thePlayers.get(0)); // Shows the winner.
		GUIGame.endGUI();
	}
}
