package controller;

import java.awt.Color;
import java.util.ArrayList;

//import board.Tax;
//import board.Refuge;
import board.Ownable;
//import desktop_fields.Refuge;
//import desktop_fields.Tax;
import desktop_codebehind.Car;
//import board.*;
import desktop_fields.Brewery;
import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;
import entities.Cup;
import entities.Player;

public class GUIControl {

	public void makeBoard() { // Method that creates the board for the GUI and
								// sets the squares with their descriptions,
								// colouring and number
		// Street colors
		Field[] fields = new Field[40];
		fields[0] = new Start.Builder().setTitle(msgL.msg(11)).setDescription(msgL.msg(12)).setSubText(msgL.msg(173))
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[1] = new Street.Builder().setTitle(msgL.msg(13)).setDescription(msgL.msg(14)).setSubText(msgL.msg(15))
				.setBgColor(Color.blue).setFgColor(Color.black).build();
		fields[2] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[3] = new Street.Builder().setTitle(msgL.msg(16)).setDescription(msgL.msg(17)).setSubText(msgL.msg(15))
				.setBgColor(Color.blue).setFgColor(Color.black).build();
		fields[4] = new Tax.Builder().setTitle(msgL.msg(18)).setDescription(msgL.msg(19)).setSubText("")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[5] = new Shipping.Builder().setTitle(msgL.msg(20)).setDescription(msgL.msg(21)).setSubText(msgL.msg(22))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[6] = new Street.Builder().setTitle(msgL.msg(23)).setDescription(msgL.msg(24)).setSubText(msgL.msg(25))
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[7] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[8] = new Street.Builder().setTitle(msgL.msg(26)).setDescription(msgL.msg(27)).setSubText(msgL.msg(28))
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[9] = new Street.Builder().setTitle(msgL.msg(29)).setDescription(msgL.msg(30)).setSubText(msgL.msg(31))
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[10] = new Jail.Builder().setTitle(msgL.msg(32)).setDescription(msgL.msg(33)).setSubText(msgL.msg(32))
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[11] = new Street.Builder().setTitle(msgL.msg(34)).setDescription(msgL.msg(35)).setSubText(msgL.msg(36))
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[12] = new Brewery.Builder().setTitle(msgL.msg(37)).setDescription(msgL.msg(38)).setSubText(msgL.msg(39))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[13] = new Street.Builder().setTitle(msgL.msg(40)).setDescription(msgL.msg(41)).setSubText(msgL.msg(42))
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[14] = new Street.Builder().setTitle(msgL.msg(43)).setDescription(msgL.msg(44)).setSubText(msgL.msg(45))
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[15] = new Shipping.Builder().setTitle(msgL.msg(46)).setDescription(msgL.msg(47)).setSubText(msgL.msg(22))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[16] = new Street.Builder().setTitle(msgL.msg(49)).setDescription(msgL.msg(50)).setSubText(msgL.msg(54))
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[17] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[18] = new Street.Builder().setTitle(msgL.msg(52)).setDescription(msgL.msg(50)).setSubText(msgL.msg(54))
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[19] = new Street.Builder().setTitle(msgL.msg(55)).setDescription(msgL.msg(56)).setSubText(msgL.msg(48))
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[20] = new Refuge.Builder().setTitle(msgL.msg(58)).setDescription(msgL.msg(59)).setSubText(msgL.msg(60))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[21] = new Street.Builder().setTitle(msgL.msg(61)).setDescription(msgL.msg(56)).setSubText(msgL.msg(63))
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[22] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[23] = new Street.Builder().setTitle(msgL.msg(64)).setDescription(msgL.msg(65)).setSubText(msgL.msg(63))
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[24] = new Street.Builder().setTitle(msgL.msg(67)).setDescription(msgL.msg(68)).setSubText(msgL.msg(69))
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[25] = new Shipping.Builder().setTitle(msgL.msg(70)).setDescription(msgL.msg(71)).setSubText(msgL.msg(48))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[26] = new Street.Builder().setTitle(msgL.msg(73)).setDescription(msgL.msg(44)).setSubText(msgL.msg(75))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[27] = new Street.Builder().setTitle(msgL.msg(76)).setDescription(msgL.msg(74)).setSubText(msgL.msg(78))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[28] = new Brewery.Builder().setTitle(msgL.msg(79)).setDescription(msgL.msg(80)).setSubText(msgL.msg(81))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[29] = new Street.Builder().setTitle(msgL.msg(82)).setDescription(msgL.msg(83)).setSubText(msgL.msg(84))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[30] = new Jail.Builder().setTitle(msgL.msg(85)).setDescription(msgL.msg(86)).setSubText(msgL.msg(86))
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[31] = new Street.Builder().setTitle(msgL.msg(87)).setDescription(msgL.msg(88)).setSubText(msgL.msg(89))
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[32] = new Street.Builder().setTitle(msgL.msg(90)).setDescription(msgL.msg(91)).setSubText(msgL.msg(92))
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[33] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[34] = new Street.Builder().setTitle(msgL.msg(93)).setDescription(msgL.msg(94)).setSubText(msgL.msg(95))
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[35] = new Shipping.Builder().setTitle(msgL.msg(96)).setDescription(msgL.msg(47)).setSubText(msgL.msg(47))
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[36] = new Chance.Builder().setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[37] = new Street.Builder().setTitle(msgL.msg(97)).setDescription(msgL.msg(98)).setSubText(msgL.msg(99))
				.setBgColor(Color.orange).setFgColor(Color.black).build();
		fields[38] = new Tax.Builder().setTitle("").setDescription(msgL.msg(100)).setSubText(msgL.msg(100))
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[39] = new Street.Builder().setTitle(msgL.msg(101)).setDescription(msgL.msg(102))
				.setSubText(msgL.msg(103)).setBgColor(Color.orange).setFgColor(Color.black).build();

		GUI.create(fields);
	}

	public String changeLanguage() {
		String language = GUI.getUserButtonPressed(msgL.msg(174), msgL.msg(175), msgL.msg(176));
		msgL.changeLanguage(language);
		return language;
	}

	// public void showSquareInfo(Square theSquare) {
	//
	// }

	public void showWinner(Player winner) {
		GUI.showMessage(msgL.msg(104) + winner + "! " + msgL.msg(105));
	}

	public void createPlayer(Player newPlayer) {

		// Creating the car.
		Car car = new Car.Builder().typeUfo()
				.patternHorizontalDualColor()
				.primaryColor(Color.WHITE)
				.secondaryColor(newPlayer.getColor())
				.build();
		// Creating player on board.
		GUI.addPlayer(newPlayer.toString(), newPlayer.getBalance(), car);
		GUI.setCar(1, newPlayer.toString());
	}

	// Getting dice value, printing to GUI
	public void showDice(Cup newCup) {
		int d1 = newCup.getD1();
		int d2 = newCup.getD2();
		if (d1 > 6 || d2 > 6 && d2<0||d2<0)
			GUI.setDice(1, 1);
		else
			GUI.setDice(d1, d2);
	}

	// Creation of players, saving the number of players to an integer and the
	// name of a player as a string in an array.
	/**
	 * Input number of players, name of players and denies same name entries.
	 */

	public String[] numberOfPlayers() {
		int numberOfPlayers = GUI.getUserInteger(msgL.msg(106), 3, 6);
		String[] playerNames = new String[numberOfPlayers];
		String[] tempArray = new String[numberOfPlayers];
		for (int u = 0; u < numberOfPlayers; u++) {
			tempArray[u] = msgL.msg(107);
			playerNames[u] = msgL.msg(107) + u;
		}
		String tempName;
		boolean sameName = false;
		int number;

		for (int i = 0; i < numberOfPlayers; i++) {
			number = i + 1; // The Array[] have to start at index 0, but the
							// player is number 1.
			sameName = false;
			tempName = GUI.getUserString(msgL.msg(108) + String.valueOf(number));
			for (int j = 0; j < numberOfPlayers; j++) {
				if (tempArray[j].equals(tempName)) {
					sameName = true;
					i--;
					GUI.showMessage(msgL.msg(109));
				}
			}
			if (sameName == false) {
				playerNames[i] = tempName;
				tempArray[i] = tempName;
			}
		}
		return playerNames;
	}

	// Player choices for each new turn
	public String getUserInputTurn(Player thePlayer, String[] choices) {
		String input;
		input = GUI.getUserButtonPressed(thePlayer.toString() + msgL.msg(110), choices);
		return input;
	}

	/**
	 * Moves vehicle on the board
	 * 
	 * @param thePlayer
	 *            type: Player
	 */

	public static void moveVehicle(Player thePlayer) {
		// Calculate value

		int value = thePlayer.getCurrentPosition() - thePlayer.getPreviousPosition();
		while (value < 0)
			value += 40;
			
		for (int i = 0; i < value; i++) {
			GUI.removeCar((thePlayer.getPreviousPosition() + i) % 40 + 1, thePlayer.toString());
			GUI.setCar((thePlayer.getPreviousPosition() + i + 1) % 40 + 1, thePlayer.toString());
			if ((thePlayer.getPreviousPosition() + i + 1) % 40 + 1 == 2) {
				if (thePlayer.getFirstRound() == false && thePlayer.getCurrentPosition()!=10) {
					thePlayer.deposit(4000);
					updateBalance(thePlayer);
				} else {
					thePlayer.setFirstRound(false);
				}
			}

			try {
				Thread.currentThread();
				if(value>12){
					Thread.sleep(0);
				}else{
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Player choice of buying a square or not.

	public static boolean getBuyChoice(Ownable field, Player player) {

		String input = GUI.getUserButtonPressed(player.toString() + msgL.msg(111) + field.toString() + msgL.msg(177)
				+ field.toString() + msgL.msg(178) + field.getPrice() + msgL.msg(181), msgL.msg(179), msgL.msg(180));
		if (input.equals(msgL.msg(179)))
			return true;
		else
			return false;
	}

	public static boolean getTaxChoice(String name, Player player) {

		String input = GUI.getUserButtonPressed(player.toString() + msgL.msg(111) + name + msgL.msg(182), msgL.msg(173),
				msgL.msg(183));
		if (input.equals(msgL.msg(173)))
			return true;
		else
			return false;
	}

	/**
	 * Prints message in GUI
	 * 
	 * @param message
	 *            type: String
	 * @author Jonas Larsen (s136335)
	 * @author Morten Velin (s147300)
	 */
	public static void printMessage(String message) {
		GUI.showMessage(message);
	}

	// Removing player from playing board when player surrenders or looses.
	public void removePlayer(Player thePlayer) {

		// Remove the players owned squares.
		int[] list = thePlayer.getOwnedID();
		ArrayList<Ownable> arr = thePlayer.getOwned();
		for (int i = 0; i < list.length; i++) {
			GUI.removeOwner(list[i]);
			arr.get(i).clearOwner();
		}
		// Remove Car
		GUI.removeCar(thePlayer.getCurrentPosition() + 1, thePlayer.toString());
		GUI.setBalance(thePlayer.toString(), 0);
	}

	// set square as owned.
	public static void setOwned(int squareNumber, Player thePlayer) {

		GUI.setOwner(squareNumber, thePlayer.toString());
	}

	public static void updateBalance(Player player) {
		GUI.setBalance(player.toString(), player.getBalance());
	}

	public static void ownedMessage(Ownable field, Player landed, Player owner, int payment) {
		GUI.showMessage(landed.toString() + msgL.msg(111) + field.toString() + msgL.msg(112) + owner.toString()
				+ msgL.msg(113) + payment + msgL.msg(119) + msgL.msg(114) + owner.toString());
	}

	public static void buyMessage(Ownable field, Player player) {
		GUI.showMessage(msgL.msg(115) + field.toString() + msgL.msg(184) + field.getPrice() + msgL.msg(119));
	}

	public static void taxMessage(Player player, int amount) {
		GUI.showMessage(player.toString() + msgL.msg(116) + amount + msgL.msg(119));
	}

	public static void refugeMessage(Refuge refuge, Player player, int bonus) {
		GUI.showMessage(player.toString() + msgL.msg(117) + refuge.toString() + msgL.msg(118) + bonus + msgL.msg(119));
	}

	public static void notEnoughMoney(Ownable own) {
		GUI.showMessage(msgL.msg(121) + own.toString());
	}

	/*
	 * public static void taxNotEnoughMoney(Tax tax){
	 * GUI.showMessage("You don't have enough money to pay the tax amount of "
	 * +tax.getTaxAmount()+", so you have to pay the 10% tax rate."); }
	 */
	public void endGUI() {
		GUI.close();
	}

	public void setBuilding(int position, int numberOfBuildings) {

		if (numberOfBuildings == 4) {
			GUI.setHotel(position, true);
		} else if (numberOfBuildings >= 0) {
			GUI.setHouses(position, numberOfBuildings + 1);
		} else {
			GUI.showMessage("Der er sket en fejl i setBuildings");// tiltænkt
																	// til os
		}
	}

	public void removeBuilding(int position, int numberOfBuildings) {

		GUI.setHouses(position, numberOfBuildings - 1);

	}

	public static String make2Buttons(String message, String button1, String button2) {
		return GUI.getUserButtonPressed(message, button1, button2);
	}

	public static String makeLists(String test, String[] options) {
		return GUI.getUserSelection(test, options);
	}

	public static void displayChanceCard(String txt) {
		GUI.displayChanceCard(txt);
	}
}
