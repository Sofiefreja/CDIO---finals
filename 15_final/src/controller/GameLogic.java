package controller;

import java.util.ArrayList;

import desktop_resources.GUI;
import entities.AllCards;
import entities.Board;
import entities.Cup;
import entities.Player;
import test.FakeCup;
import board.Ownable;
import board.Street;
import board.Ownable;

public class GameLogic {

	private GUIControl GUIGame;
	private Board theBoard;
	private Cup theCup;
	public ArrayList<Player> thePlayers;
	private int equalEyeCounter;
	private int i;

	/**
	 * GameLogic controls the gameflow
	 * 
	 * @author Jonas Larsen s136335
	 * @author Morten Velin s147300
	 * @author Sofie Freja Christensen s153932
	 * @author Simon Lundorf s154008
	 */

	public GameLogic() {

		// Initializing the game.

		GUIGame = new GUIControl();
		GUIGame.makeBoard();
		theCup = new FakeCup(0);

		// The players are initialized
		thePlayers = createPlayers();

		theBoard = new Board(theCup, thePlayers);

		// Beginning the game.
		equalEyeCounter = 0;

		// The game should run until one player remains in the ArrayList.
		while (thePlayers.size() > 1) {

			// The for loop running through all the players.
			for (i = 0; i < thePlayers.size(); i++) {

				// If only one player is left, the 'else' runs and breaks the
				// for loop
				if (thePlayers.size() != 1) {

					// Creating menues for the player based on property or
					// status.
					String[] availableChoices = getMenu(thePlayers.get(i));
					String turn = GUIGame.getUserInputTurn(thePlayers.get(i), availableChoices);

					// All the if statements for Player choices on start of
					// turn.
					if (thePlayers.get(i).getBalance() >= 0) {
						if (turn.equals(msgL.msg(1))) {

							theCup.roll();
							GUIGame.showDice(theCup);
							// All the if statements for different scenarios a
							// player can be in when rolling.

							if (thePlayers.get(i).getJailStatus()) {

								doJail(thePlayers.get(i));

							} else {

								// If the dice is equals turn resets
								if (theCup.getEquals() == true && equalEyeCounter != 2) {
									doMoveVehicle(thePlayers.get(i));

									if (thePlayers.get(i).getJailStatus() == false) {
										i--;
										equalEyeCounter++;
									}
								} else if (theCup.getEquals() && equalEyeCounter == 2) { // Puts
																							// the
									// player in
									// jail if
									// equalEyeCounter
									// hits 3.
									GUIControl.printMessage(
											"Du slog 2 ens for tredie gang, du ryger i fængsel for snyd!");
									thePlayers.get(i).setPosition(10, thePlayers.get(i).getCurrentPosition());
									GUIControl.moveVehicle(thePlayers.get(i));
									thePlayers.get(i).setJailStatus(true);
									equalEyeCounter = 0;
								} else {
									equalEyeCounter = 0;
									doMoveVehicle(thePlayers.get(i));
									if (thePlayers.get(i).getBalance() < 0) {
										i--;
									}

								}
							}
						} else if (turn.equals(msgL.msg(2))) {
							System.out.println("Shit");
							i--;// han skal have en tur mere
						} else if (turn.equals(msgL.msg(4))) {
							Ownable pawned = null;
							String pawnName = GUIControl.makeLists(msgL.msg(5), thePlayers.get(i).getPawnable());
							for (int j = 0; j < thePlayers.get(i).getOwned().size(); j++) {

								if (thePlayers.get(i).getOwned().get(j).toString().equals(pawnName)) {

									pawned = thePlayers.get(i).getOwned().get(j);

								}

							}

							thePlayers.get(i).pawnProperty(pawned);
							i--;
						} else if (turn.equals("Løft pantsætning")) {
							Ownable hasPawned = null;
							String hasPawnName = GUIControl.makeLists("Du vil gerne hæve en pantsætning",
									thePlayers.get(i).getPawned());
							for (int j = 0; j < thePlayers.get(i).getOwned().size(); j++) {

								if (thePlayers.get(i).getOwned().get(j).toString().equals(hasPawnName)) {

									hasPawned = thePlayers.get(i).getOwned().get(j);

								}

							}

							thePlayers.get(i).liftPawn(hasPawned);

							i--;
						} else if (turn.equals(msgL.msg(6))) {// køb hus eller
																// hotel
							if (thePlayers.get(i).getBuildStatus() == true) {
								String streetName = GUIControl.makeLists("Hvilken grund vil du gerne bygge et hus på?",
										thePlayers.get(i).getBuildableList());
								setBuilding(thePlayers.get(i), streetName);
							} else {
								GUIControl.printMessage("Du kan ikke købe mere .....");
							}
							i--;
						} else if (turn.equals(msgL.msg(8))) {
							if (thePlayers.get(i).getBuilding() == true) {
								String streetName = GUIControl.makeLists(
										"Hvilken grund vil du gerne sælge et hus/hotel fra?",
										thePlayers.get(i).getSellableList());
								removeBuilding(thePlayers.get(i), streetName);
							}
							i--;
						} else if (turn.equals(msgL.msg(10))) {
							GUIGame.removePlayer(thePlayers.get(i));
							// missing removePlayer
							thePlayers.remove(i);
							i--; // fordi arrayet bliver mindre
						} else if (turn.equals(msgL.msg(166))) {
							GUIControl.printMessage(msgL.msg(167));
							thePlayers.get(i).withdraw(1000);
							thePlayers.get(i).setJailStatus(false);
							i--;
						}
					} else if (thePlayers.get(i).getBalance() < 0 && thePlayers.get(i).getProperty() == true) {

						if (thePlayers.get(i).getProperty()) {
							getMenu(thePlayers.get(i));
							if (turn.equals(msgL.msg(4))) {
								Ownable pawned = null;
								String pawnName = GUIControl.makeLists(msgL.msg(5), thePlayers.get(i).getPawnable());
								for (int j = 0; j < thePlayers.get(i).getOwned().size(); j++) {

									if (thePlayers.get(i).getOwned().get(j).toString().equals(pawnName)) {

										pawned = thePlayers.get(i).getOwned().get(j);

									}

								}

								thePlayers.get(i).pawnProperty(pawned);
								if (thePlayers.get(i).getBalance() < 0) {
									i--;
								}
							}

						} else if (turn.equals(msgL.msg(8))) {
							if (thePlayers.get(i).getBuilding() == true) {
								String streetName = GUIControl.makeLists(
										"Hvilken grund vil du gerne sælge et hus/hotel fra?",
										thePlayers.get(i).getSellableList());
								removeBuilding(thePlayers.get(i), streetName);
							}
							if (thePlayers.get(i).getBalance() < 0) {
								i--;
							}
						}

					} else if (thePlayers.get(i).getBalance() < 0 && thePlayers.get(i).getProperty() == false) {

						GUIGame.removePlayer(thePlayers.get(i));
						// missing removePlayer
						thePlayers.remove(i);
						i--; // fordi arrayet bliver mindre

					}
				} else { // Breaks the forloop because winner is found.
					break;
				}
			}
		}
		GUIGame.showWinner(thePlayers.get(0)); // Shows the winner.
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

		if (theplayer.getJailStatus() == true) {
			choices.add(msgL.msg(166));
		}
		if (!(theplayer.getBalance() < 0)) {
			choices.add(msgL.msg(1));
		}
		if (theplayer.getProperty()) {
			if (theplayer.getPawnStatus() == true) {
				choices.add(msgL.msg(4));
			}
			if (theplayer.getHasPawned() == true) {
				choices.add("Løft pantsætning");
			}
			if (theplayer.getBuilding() == true) {
				choices.add(msgL.msg(8));
			}
			if (theplayer.getBuildStatus() == true) {
				choices.add(msgL.msg(6));
			}
		}
		choices.add(msgL.msg(10));

		// }

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
			GUIControl.printMessage(msgL.msg(170));
			doMoveVehicle(theplayer);
			theplayer.setJailStatus(false);
			i--;
		} else if (theplayer.getJailCounter() == 2) {
			GUIControl.printMessage(msgL.msg(171));
			theplayer.withdraw(1000);
			GUIControl.updateBalance(theplayer);
			theplayer.setJailStatus(false);
			doMoveVehicle(theplayer);
		} else {
			GUIControl.printMessage(msgL.msg(172));
			theplayer.addToJailCounter();
			// der sker ikke noget.
		}
		equalEyeCounter = 0;
	}

	private void setBuilding(Player thePlayer, String streetName) {
		int i, position = 0, numberOfBuildings = 0;
		Street theStreet = null;

		for (i = 0; i < thePlayer.getOwnedStreet().size(); i++) {
			if (thePlayer.getOwnedStreet().get(i).toString().equals(streetName)) {
				position = thePlayer.getOwnedStreet().get(i).getID();
				numberOfBuildings = thePlayer.getOwnedStreet().get(i).getNumberOfBuildings();
				theStreet = thePlayer.getOwnedStreet().get(i);
			}
		}
		GUIGame.setBuilding(position, numberOfBuildings);
		thePlayer.buyHouses(theStreet, 1);
		GUIGame.updateBalance(thePlayer);

	}

	private void removeBuilding(Player thePlayer, String streetName) {
		int i, position = 0, numberOfBuildings = 0;
		Street theStreet = null;

		for (i = 0; i < thePlayer.getOwnedStreet().size(); i++) {
			if (thePlayer.getOwnedStreet().get(i).toString().equals(streetName)) {
				position = thePlayer.getOwnedStreet().get(i).getID();
				numberOfBuildings = thePlayer.getOwnedStreet().get(i).getNumberOfBuildings();
				theStreet = thePlayer.getOwnedStreet().get(i);
			}
		}
		GUIGame.removeBuilding(position, numberOfBuildings);
		thePlayer.removeHouses(theStreet, 1);
		GUIGame.updateBalance(thePlayer);

	}
}
