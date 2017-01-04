package controller;
import entities.Player;
import entities.Cup;
import java.awt.*;
import java.util.ArrayList;
//import board.*;
import desktop_fields.*;
//import desktop_fields.Refuge;
//import desktop_fields.Tax;
import desktop_codebehind.*;
import desktop_resources.GUI;
//import board.LaborCamp;
import board.*;
//import board.Tax;
//import board.Refuge;
import board.Ownable;

public class GUIControl {

	public void makeBoard() { // Method that creates the board for the GUI and
								// sets the squares with their descriptions,
								// colouring and number
		// terr = white, ref = green, fleet = blue, tax = red, labor = yellow.
		Field[] fields = new Field[40];
		fields[0] = new Street.Builder().setTitle("Tribe Encampment").setDescription("Territory").setSubText("Price: 1000").setRent("Rent: 100")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[1] = new Shipping.Builder().setTitle("Second Sail").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[2] = new Street.Builder().setTitle("Crater").setDescription("Territory").setSubText("Price: 1500").setRent("Rent: 300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[3] = new Street.Builder().setTitle("Walled City").setDescription("Refuge").setSubText("Reward: 5000")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[4] = new Street.Builder().setTitle("Huts in the mountain").setDescription("Labor Camp").setSubText("Price: 2500").setRent("Rent: Eyes * 100 * Camps owned")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[5] = new Street.Builder().setTitle("Mountain").setDescription("Territory").setSubText("Price: 2000").setRent("Rent: 500")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[6] = new Shipping.Builder().setTitle("Sea Grover").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[7] = new Street.Builder().setTitle("Cold Desert").setDescription("Territory").setSubText("Price: 3000").setRent("Rent: 700")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[8] = new Street.Builder().setTitle("Black Cave").setDescription("Territory").setSubText("Price: 4000").setRent("Rent: 1000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[9] = new Street.Builder().setTitle("Goldmine").setDescription("Tax").setSubText("2000 or 10% of balance tax!")
				.setBgColor(Color.red).setFgColor(Color.black).build();
		fields[10] = new Street.Builder().setTitle("The Werewall").setDescription("Territory").setSubText("Price: 4300").setRent("Rent: 1300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[11] = new Street.Builder().setTitle("Mountain Village").setDescription("Territory").setSubText("Price: 4750")
				.setRent("1600").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[12] = new Shipping.Builder().setTitle("Buccaneers").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[13] = new Street.Builder().setTitle("South Citidel").setDescription("Territory").setSubText("Price: 5000")
				.setRent("2000").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[14] = new Street.Builder().setTitle("Monestary").setDescription("Refuge").setSubText("Reward: 500")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[15] = new Street.Builder().setTitle("The Pit").setDescription("Labor Camp").setSubText("Price: 2500").setRent("Rent: Eyes * 100 * Camps owned")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[16] = new Street.Builder().setTitle("Palace Gates").setDescription("Territory").setSubText("Price: 5500").setRent("Rent: 2600")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[17] = new Shipping.Builder().setTitle("Privateer").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[18] = new Street.Builder().setTitle("Caravan").setDescription("Tax").setSubText("4000 or 10% of balance tax!").setBgColor(Color.red)
				.setFgColor(Color.black).build();
		fields[19] = new Street.Builder().setTitle("Tower").setDescription("Territory").setSubText("Price: 6000").setRent("Rent: 3200")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[20] = new Street.Builder().setTitle("Castle").setDescription("Territory").setSubText("Price: 8000").setRent("Rent: 4000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[21] = new Street.Builder().setTitle("Tribe Encampment").setDescription("Territory").setSubText("Price: 1000").setRent("Rent: 100")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[22] = new Shipping.Builder().setTitle("Second Sail").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[23] = new Street.Builder().setTitle("Crater").setDescription("Territory").setSubText("Price: 1500").setRent("Rent: 300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[24] = new Street.Builder().setTitle("Walled City").setDescription("Refuge").setSubText("Reward: 5000")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[25] = new Street.Builder().setTitle("Huts in the mountain").setDescription("Labor Camp").setSubText("Price: 2500").setRent("Rent: Eyes * 100 * Camps owned")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[26] = new Street.Builder().setTitle("Mountain").setDescription("Territory").setSubText("Price: 2000").setRent("Rent: 500")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[27] = new Shipping.Builder().setTitle("Sea Grover").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[28] = new Street.Builder().setTitle("Cold Desert").setDescription("Territory").setSubText("Price: 3000").setRent("Rent: 700")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[29] = new Street.Builder().setTitle("Black Cave").setDescription("Territory").setSubText("Price: 4000").setRent("Rent: 1000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[30] = new Street.Builder().setTitle("Goldmine").setDescription("Tax").setSubText("2000 or 10% of balance tax!")
				.setBgColor(Color.red).setFgColor(Color.black).build();
		fields[31] = new Street.Builder().setTitle("The Werewall").setDescription("Territory").setSubText("Price: 4300").setRent("Rent: 1300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[32] = new Street.Builder().setTitle("Mountain Village").setDescription("Territory").setSubText("Price: 4750")
				.setRent("1600").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[33] = new Shipping.Builder().setTitle("Buccaneers").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[34] = new Street.Builder().setTitle("South Citidel").setDescription("Territory").setSubText("Price: 5000")
				.setRent("2000").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[35] = new Street.Builder().setTitle("Monestary").setDescription("Refuge").setSubText("Reward: 500")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[36] = new Street.Builder().setTitle("The Pit").setDescription("Labor Camp").setSubText("Price: 2500").setRent("Rent: Eyes * 100 * Camps owned")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[37] = new Street.Builder().setTitle("Palace Gates").setDescription("Territory").setSubText("Price: 5500").setRent("Rent: 2600")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[38] = new Shipping.Builder().setTitle("Privateer").setDescription("Fleet").setSubText("Price: 4000").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[39] = new Street.Builder().setTitle("Caravan").setDescription("Tax").setSubText("4000 or 10% of balance tax!").setBgColor(Color.red)
				.setFgColor(Color.black).build();
	
		GUI.create(fields);
	}
		
		
	
	// public void showSquareInfo(Square theSquare) {
	//
	// }


	public void showWinner(Player winner) {
		GUI.showMessage("Congratulations " + winner + "! " + "You are the winner!");
	}

	public void createPlayer(Player newPlayer) {

		// Creating the car.
		Car car = new Car.Builder().typeUfo().patternFill().primaryColor(newPlayer.getColor()).secondaryColor(newPlayer.getColor()).build();
		// Creating player on board.
		GUI.addPlayer(newPlayer.toString(), newPlayer.getBalance(), car);
	}

	// Getting dice value, printing to GUI
	public void showDice(Cup newCup) {
		int d1 = newCup.getD1();
		int d2 = newCup.getD2();
		GUI.setDice(d1, d2);
	}

	// Creation of players, saving the number of players to an integer and the
	// name of a player as a string in an array.
	public String[] numberOfPlayers() {
		int numberOfPlayers = GUI.getUserInteger("How many players are you? (between 2-6)", 2, 6);
		String[] playerNames = new String[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			int number = i + 1; // The Array[] have to start at index 0, but the
								// player is number 1.
			playerNames[i] = GUI.getUserString("Player " + String.valueOf(number));
		}
		return playerNames;
	}

	// Player choices for each new turn
	public String getUserInputTurn(Player thePlayer) {
		String input;
		input = GUI.getUserButtonPressed(thePlayer.toString() + " it's your turn. Take an action: ", "Roll",
				"Surrender");
		return input;
	}

	// Move vehicle on the board.
	public void moveVehicle(Player thePlayer) {
		GUI.removeCar(thePlayer.getPreviousPosition()+1, thePlayer.toString());
		GUI.setCar(thePlayer.getCurrentPosition()+1, thePlayer.toString());

	}

	// Extra roll to determine Labor Camp tax.

	/*public static int getUserRoll(LaborCamp camp) {
		int value = 0;
		Cup thecup = new Cup();
		//GUI.showMessage("You landed on "+camp.toString()+ ". You roll to determine the rent you need to pay.");
		value = thecup.roll();
		GUI.setDice(thecup.getD1(),thecup.getD2());
		//GUI.showMessage("You rolled: "+value);
		return value;
	}*/

	// Player choice of buying a square or not.
	public static boolean getBuyChoice(Ownable field, Player player) {

		String input = GUI.getUserButtonPressed(player.toString()+", you landed on "+field.toString()+
		".\nDo you want to buy " + field.toString() + " for "+field.getPrice()+"£?", "Yes", "No");
		if (input.equals("Yes"))
			return true;
		else
			return false;
	}

	// Player choice of paying 10% flatrate tax or Tax amount.

	/*public static String rateOrAmount(Tax theTax, Player player) {

		String TaxAmount = String.valueOf(theTax.getTaxAmount());
		String output = null;

		String input = GUI.getUserButtonPressed(player.toString()+", you landed on "+theTax.toString()+", you have two options: ", "Tax rate 10 %",
				"Tax Amount " + TaxAmount+"£");
		if (input.equals("Tax rate 10 %"))
			output = "Tax rate";
		else if (input.equals("Tax Amount " + TaxAmount+"£"))
			output = "Tax Amount";

		return output;
	}*/

	// Removing player from playing board when player surrenders or looses.
	public void removePlayer(Player thePlayer) {

		// Remove the players owned squares.
		int[] list = thePlayer.ownedID();
		ArrayList <Ownable> arr=thePlayer.returnOwned();
		for (int i = 0; i < list.length; i++) {
			GUI.removeOwner(list[i]);
			arr.get(i).clearOwner();
		}

		// Remove Car
		GUI.removeCar(thePlayer.getCurrentPosition()+1, thePlayer.toString());
		GUI.setBalance(thePlayer.toString(),0);
	}

	// set square as owned.
	public static void setOwned(int squareNumber, Player thePlayer) {

		GUI.setOwner(squareNumber, thePlayer.toString());
	}
	public static void updateBalance(Player player){
		GUI.setBalance(player.toString(), player.getBalance());
	}
	public static void ownedMessage(Ownable field, Player landed, Player owner, int payment){
		GUI.showMessage(landed.toString()+", you landed on "+field.toString()+", which is owned by "+owner.toString()+".\n"
				+"You pay " +payment+"£ to "+owner.toString());
	}
	public static void buyMessage(Ownable field, Player player){
		GUI.showMessage("Congratulations! You have bought "+field.toString()+"! You pay "+field.getPrice()+"£");
	}
	public static void taxMessage(Player player, int amount){
		GUI.showMessage(player.toString()+" payed "+amount+"£");
	}
	public static void refugeMessage(Refuge refuge, Player player, int bonus){
		GUI.showMessage(player.toString()+", you landed on the Refuge "+refuge.toString()+". You are awarded a bonus of: "+bonus+"£");
	}
	public static void selfOwned(){
		GUI.showMessage("You are the owner of this square!");
	}
	public static void notEnoughMoney(Ownable own){
		GUI.showMessage("Whoa there, you don't have enough money to buy "+own.toString());
	}
	/*public static void taxNotEnoughMoney(Tax tax){
		GUI.showMessage("You don't have enough money to pay the tax amount of "+tax.getTaxAmount()+", so you have to pay the 10% tax rate.");
	}*/
	public void endGUI(){
		GUI.close();
	}

}
