package controller;

import java.util.ArrayList;

import desktop_resources.GUI;
import entities.AllCards;
import entities.Board;
import entities.Cup;
import entities.Player;
import test.FakeCup;

public class GameLogic {

	private GUIControl GUIGame;
	private Board theBoard;
	private Cup theCup;
	private ArrayList<Player> thePlayers;
	private int equalEyeCounter;
	private int i;

	/**
	 * GameLogic controls the gameflow
	 * 
	 * @author Jonas Larsen s136335
	 * @author Morten Velin s147300
	 * @author Sofie Freja Christensen s153932
	 */

	public GameLogic() {

		// Initializing the game.

		GUIGame = new GUIControl();
		GUIGame.makeBoard();
		theCup = new FakeCup(0);
		theBoard = new Board(theCup);
		// AllCards theCards = new AllCards(thePlayers);

		// The players are initialized
		thePlayers = createPlayers();

		// Beginning the game.
		equalEyeCounter = 0;

		// The game should run until one player remains in the ArrayList.
		while (thePlayers.size() > 1) {

			// The for loop running through all the players.
			for ( i = 0; i < thePlayers.size(); i++) {

				// If only one player is left, the 'else' runs and breaks the
				// for loop
				if (thePlayers.size() != 1) {

					// Creating menues for the player based on property or
					// status.
					String[] valg = getMenu(thePlayers.get(i));
					String turn = GUIGame.getUserInputTurn(thePlayers.get(i), valg);

					// All the if statements for Player choices on start of
					// turn.
					if (thePlayers.get(i).getBalance() > 0) {
						if (turn.equals(msgL.msg(1))) {

							theCup.roll();
							GUIGame.showDice(theCup);
							// All the if statements for different scenarios a
							// player can be in when rolling.

							if (thePlayers.get(i).getJailStatus()) {

								doJail(thePlayers.get(i));

							} else if (equalEyeCounter != 3) {

								doMoveVehicle(thePlayers.get(i));

								// If the dice is equals turn resets
								if (theCup.getEquals() == true) {
									i--;
									equalEyeCounter++;
								} else
									equalEyeCounter = 0;

							} else { // Puts the player in jail if
										// equalEyeCounter
										// hits 3.
								thePlayers.get(i).setJailStatus(true);
								thePlayers.get(i).setPosition(10, thePlayers.get(i).getCurrentPosition());
								doMoveVehicle(thePlayers.get(i));
								equalEyeCounter = 0;
							}
						} else if (turn.equals(msgL.msg(2))) {
							System.out.println("Shit");
							i--;// han skal have en tur mere
						} else if (turn.equals(msgL.msg(4))) {
							System.out.println("Shit");
							i--;
						} else if (turn.equals(msgL.msg(6))) {//køb hus
							
							String StreetName= GUIControl.makeLists("Hvilken grund vil du gerne bygge et hus på", thePlayers.get(i).getBuildableList());
							
							int i, antal, position;
							for(int q=0;q<thePlayers.get(i).getOwnedStreet().size();q++){
								if(thePlayers.get(i).getOwnedStreet().get(q).toString().equals(StreetName))
									position =thePlayers.get(i).getOwnedStreet().get(q).getID();
							}
							GUIGame.setBuilding(building, fieldNumber);
						
							
							}
							System.out.println("Shit");
							i--;
						} else if (turn.equals(msgL.msg(8))) {
							System.out.println("Shit");
							i--;
						} else if (turn.equals(msgL.msg(10))) {
							GUIGame.removePlayer(thePlayers.get(i));
							// missing removePlayer
							thePlayers.remove(i);
							i--; // fordi arrayet bliver mindre
						}else if (turn.equals(msgL.msg(166))) {
							GUIControl.printMessage(msgL.msg(167));
							thePlayers.get(i).withdraw(1000);
							thePlayers.get(i).setJailStatus(false);
							i--;
						}
					} else if (thePlayers.get(i).getBalance() < 0) {
						GUIGame.removePlayer(thePlayers.get(i));
						// missing removePlayer
						thePlayers.remove(i);
						i--; // fordi arrayet bliver mindre
					} 
				} else { // Breaks the forloop because winner is found.
					break;
				}
			}
		}GUIGame.showWinner(thePlayers.get(0)); // Shows the winner.
	GUIGame.endGUI();

	}

	/**
	 * Asks for number of players, their names and creates an arraylist of
	 * players.
	 */

	private ArrayList<Player> createPlayers() {
		String[] playerNames;
		// playerNames=GUIGame.numberOfPlayers(); // Ask how many
		// players there are
		// in the game.

		// For testing.
		playerNames = new String[2];
		playerNames[0] = "Morten";
		playerNames[1] = "Jonas";

		/*
		 * Creating the players. By using an array, the names are saved in each
		 * of their own index'es in the array.
		 */
		thePlayers = new ArrayList<Player>();

		// Save all the players in a ArrayList.

		for (int i = 0; i < playerNames.length; i++) {
			thePlayers.add(new Player(playerNames[i], 30000)); // Creating
																// player
			// objects for the game
			GUIGame.createPlayer(thePlayers.get(i)); // Creating Player objects
														// for the GUI

		}
		return thePlayers;
	}

	/**
	 * Menues for the player based on what assets he currently holds and
	 * balance.
	 * 
	 * @param theplayer
	 *            Type: Player
	 * @return Type: String[] with player options.
	 */
	private String[] getMenu(Player theplayer) {
		ArrayList<String> choices = new ArrayList<>();

		if (theplayer.getBalance() < 0) { // menu if is balance under 0 (forced
											// to sell houses)
			if (theplayer.getBuilding()) {
				choices.add(msgL.msg(2));
			}
			if (theplayer.getProperty()) { // menu if is balance under 0 (forced
											// to pawn)
				choices.add(msgL.msg(3));
			}
			choices.add(msgL.msg(10));
		} else { // menu options for owning property, a house or 3 streets of
					// same type.
			if (theplayer.getJailStatus() == true) {
				choices.add(msgL.msg(166));
			}
			choices.add(msgL.msg(1));
			choices.add(msgL.msg(10));
			if (theplayer.getProperty()) {
				choices.add(msgL.msg(4));
				if (theplayer.getBuilding()) {
					choices.add(msgL.msg(8));
				}
				if (theplayer.getBuildStatus()) {
					choices.add(msgL.msg(6));
				}
			}
		}

		return choices.toArray(new String[choices.size()]); // Converting the
															// Arraylist to
		// an Array.

	}

	/**
	 * Moving vehicle.
	 * 
	 * @param theplayer
	 *            type: Player
	 */

	private void doMoveVehicle(Player theplayer) {
		theplayer.moveVehicle(theCup.getSum());
		GUIControl.moveVehicle(theplayer);
		int newPosition = theplayer.getCurrentPosition();
		theBoard.getSquare(newPosition).landOnSquare(theplayer);
	}

	/**
	 * Method for a turn while in prison.
	 * 
	 * @param theplayer
	 *            type: Player.
	 */
	private void doJail(Player theplayer) {
		if (theCup.getEquals()) {
			GUIControl.printMessage("Du slog 2 ens og er hermed løsladt");
			doMoveVehicle(theplayer);
			theplayer.setJailStatus(false);
			i--;
		} else if (theplayer.getJailCounter() == 2) {
			GUIControl.printMessage("Du har ikke slået 2 ens i tre ture, du skal betale kaution (1000 kr.)");
			theplayer.withdraw(1000);
			theplayer.setJailStatus(false);
			doMoveVehicle(theplayer);
		} else {
			GUIControl.printMessage("Du slog ikke 2 ens og er stadig fanget");
			theplayer.addToJailCounter();
			// der sker ikke noget.
		}
		equalEyeCounter = 0;
	}
}
