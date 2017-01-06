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
		//Street colors 
		Field[] fields = new Field[40];
		fields[0] = new Start.Builder().setTitle("Start").setDescription("Hver gang De passere modtag kr. 4000").setSubText("4000 kr.").
				setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[1] = new Street.Builder().setTitle("Rødovrevej").setDescription("Leje af grund 50,  m/1 hus = 250, 2 huse = 750, 3 huse = 2250, 4 huse = 4000, hotel = 6000, Hus pris = 1000, Hotel pris = 1000, pant = 600").setSubText("Pris: 1200")
				.setBgColor(Color.blue).setFgColor(Color.black).build();
		fields[2] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[3] = new Street.Builder().setTitle("Hvidovrevej").setDescription("Leje af grund 50,  m/1 hus = 250, 2 huse = 750, 3 huse = 2250, 4 huse = 4000, hotel = 6000, Hus pris = 1000, Hotel pris = 1000, pant = 600").setSubText("Pris: 1200 kr.")
				.setBgColor(Color.blue).setFgColor(Color.black).build();
		fields[4] = new Tax.Builder().setTitle("Indkomstskat").setDescription("Vælg mellem 10% eller 4000 kr.").setSubText("")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[5] = new Shipping.Builder().setTitle("Scandlines H-H").setDescription("Leje af grund 500,  m/1 hus = 1000, 2 huse = 2000, 3 huse = 4000").setSubText("Pris: 4000 kr.").setRent("Rent: 500")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[6] = new Street.Builder().setTitle("Roskildevej").setDescription("Leje af grund 100,  m/1 hus = 600, 2 huse = 1800, 3 huse = 5400, 4 huse = 8000, hotel = 11000, Hus pris = 1000, Hotel pris = 1000, pant = 1000").setSubText("Pris: 2000")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[7] = new Chance.Builder().
				setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[8] = new Street.Builder().setTitle("Valby Langgade").setDescription("Leje af grund 100,  m/1 hus = 600, 2 huse = 1800, 3 huse = 5400, 4 huse = 8000, hotel = 11000, Hus pris = 1000, Hotel pris = 1000, pant = 1000").setSubText("Pris: 2000 kr.")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[9] = new Street.Builder().setTitle("Allégade").setDescription("Tax").setSubText("Pris: 2400 kr.")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[10] = new Jail.Builder().setTitle("Fængsels besøg").setDescription("Du er på besøg i fængselet").setSubText("Fængsels besøg.")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[11] = new Street.Builder().setTitle("Frederiksberg Allé").setDescription("").setSubText("Pris: 2800 kr.")
				.setRent("1600").setBgColor(Color.green).setFgColor(Color.black).build();
		fields[12] = new Brewery.Builder().setTitle("Tuborg").setDescription("").setSubText("Pris: 3000 kr.").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[13] = new Street.Builder().setTitle("Bülowsvej").setDescription("").setSubText("Pris: 2800 kr.")
				.setRent("2000").setBgColor(Color.green).setFgColor(Color.black).build();
		fields[14] = new Street.Builder().setTitle("Gl. Kongevej").setDescription("").setSubText("Pris: 3200 kr.")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[15] = new Shipping.Builder().setTitle("Mols-Linien").setDescription("").setSubText("Pris: 4000 kr.").setRent("Rent: Eyes * 100 * Camps owned")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[16] = new Street.Builder().setTitle("Bernstorffsvej").setDescription("").setSubText("Pris: 3600 kr.")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[17] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[18] = new Street.Builder().setTitle("Hellerupvej").setDescription("").setSubText("Pris: 3600 kr.")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[19] = new Street.Builder().setTitle("Strandvejen").setDescription("").setSubText("Pris: 4000 kr")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[20] = new Refuge.Builder().setTitle("Parkering").setDescription("Du er pakeret").setSubText("Helle")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[21] = new Street.Builder().setTitle("Trianglen").setDescription("").setSubText("Pris: 4400 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[22] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[23] = new Street.Builder().setTitle("Østerbrogade").setDescription("").setSubText("Pris: 4400 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[24] = new Street.Builder().setTitle("Grønningen").setDescription("").setSubText("Pris: 4800 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[25] = new Shipping.Builder().setTitle("Scandlines G-R").setDescription("").setSubText("Pris: 4000 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[26] = new Street.Builder().setTitle("Bredgade").setDescription("").setSubText("Pris: 5200 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[27] = new Street.Builder().setTitle("Kgs. Nytorv").setDescription("").setSubText("Pris: 5200 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[28] = new Brewery.Builder().setTitle("Carlsberg").setDescription("").setSubText("Pris: 3000 kr.").setRent("Rent: 700")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[29] = new Street.Builder().setTitle("Østergade").setDescription("").setSubText("Pris: 5600 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[30] = new Jail.Builder().setTitle("Fængslet").setDescription("Ryk til fængsel!").setSubText("Ryk til fængsel!")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[31] = new Street.Builder().setTitle("Amagertorv").setDescription("").setSubText("Pris: 6000 kr.")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[32] = new Street.Builder().setTitle("Vimmelskaftet").setDescription("").setSubText("Pris: 6000 kr.")
				.setRent("1600").setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[33] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[34] = new Street.Builder().setTitle("Nygade").setDescription("").setSubText("Pris: 6400 kr.")
				.setRent("2000").setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[35] = new Shipping.Builder().setTitle("Scandlines R-P").setDescription("").setSubText("Pris: 4000 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[36] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[37] = new Street.Builder().setTitle("Frederiksberggade").setDescription("").setSubText("Pris: 7000 kr.")
				.setBgColor(Color.orange).setFgColor(Color.black).build();
		fields[38] = new Tax.Builder().setTitle("Ekstraordinær statsskat").setDescription("Betal 2000 kr.").setSubText("Betal 2000 kr.")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[39] = new Street.Builder().setTitle("Rådhuspladsen").setDescription("").setSubText("Pris: 8000 kr.")
				.setBgColor(Color.orange).setFgColor(Color.black).build();
	
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
