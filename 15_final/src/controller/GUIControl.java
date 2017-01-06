package controller;
import entities.Player;
import sun.applet.Main;
import entities.Cup;
import java.awt.*;
import java.util.ArrayList;
//import board.*;
import desktop_fields.*;
import desktop_fields.Jail;
import desktop_fields.Start;
import desktop_fields.Brewery;
import desktop_fields.Shipping;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_fields.Start;
import desktop_fields.Jail;
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
		fields[5] = new Shipping.Builder().setTitle("Scandlines H-H").setDescription("Leje af grund hvis du ejer 1 = 500, 2 = 1000, 3 = 2000, 4 huse = 4000").setSubText("Pris: 4000 kr.").setRent("Rent: 500")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[6] = new Street.Builder().setTitle("Roskildevej").setDescription("Leje af grund 100,  m/1 hus = 600, 2 huse = 1800, 3 huse = 5400, 4 huse = 8000, hotel = 11000, Hus pris = 1000, Hotel pris = 1000, pant = 1000").setSubText("Pris: 2000")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[7] = new Chance.Builder().
				setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[8] = new Street.Builder().setTitle("Valby Langgade").setDescription("Leje af grund 100,  m/1 hus = 600, 2 huse = 1800, 3 huse = 5400, 4 huse = 8000, hotel = 11000, Hus pris = 1000, Hotel pris = 1000, pant = 1000").setSubText("Pris: 2000 kr.")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[9] = new Street.Builder().setTitle("Allégade").setDescription("Leje af grund 150,  m/1 hus = 800, 2 huse = 2000, 3 huse = 6000, 4 huse = 9000, hotel = 12000, Hus pris = 1000, Hotel pris = 1000, pant = 1200").setSubText("Pris: 2400 kr.")
				.setBgColor(Color.getHSBColor(127, 140, 141)).setFgColor(Color.black).build();
		fields[10] = new Jail.Builder().setTitle("Fængsels besøg").setDescription("Du er på besøg i fængselet").setSubText("Fængsels besøg.")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[11] = new Street.Builder().setTitle("Frederiksberg Allé").setDescription("Leje af grund 200,  m/1 hus = 1000, 2 huse = 3000, 3 huse = 9000, 4 huse = 12500, hotel = 15000, Hus pris = 2000, Hotel pris = 2000, pant = 1400").setSubText("Pris: 2800 kr.")
				.setRent("1600").setBgColor(Color.green).setFgColor(Color.black).build();
		fields[12] = new Brewery.Builder().setTitle("Tuborg").setDescription("Leje af grund, per grund du ejer x100, x200  , pant = 1500").setSubText("Pris: 3000 kr.").setRent("Rent: 500,1000,2000 or 4000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[13] = new Street.Builder().setTitle("Bülowsvej").setDescription("Leje af grund 200,  m/1 hus = 1000, 2 huse = 3000, 3 huse = 9000, 4 huse = 12500, hotel = 15000, Hus pris = 2000, Hotel pris = 2000, pant = 1400").setSubText("Pris: 2800 kr.")
				.setRent("2000").setBgColor(Color.green).setFgColor(Color.black).build();
		fields[14] = new Street.Builder().setTitle("Gl. Kongevej").setDescription("Leje af grund 250,  m/1 hus = 1250, 2 huse = 3750, 3 huse = 10000, 4 huse = 14000, hotel = 18000, Hus pris = 2000, Hotel pris = 2000, pant = 1600").setSubText("Pris: 3200 kr.")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[15] = new Shipping.Builder().setTitle("Mols-Linien").setDescription("Leje af grund hvis du ejer 1 = 500, 2 = 1000, 3 = 2000, 4 huse = 4000").setSubText("Pris: 4000 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[16] = new Street.Builder().setTitle("Bernstorffsvej").setDescription("Leje af grund 300,  m/1 hus = 1400, 2 huse = 4000, 3 huse = 11000, 4 huse = 15000, hotel = 19000, Hus pris = 2000, Hotel pris = 2000, pant = 1800").setSubText("Pris: 3600 kr.")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[17] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[18] = new Street.Builder().setTitle("Hellerupvej").setDescription("Leje af grund 300,  m/1 hus = 1400, 2 huse = 4000, 3 huse = 11000, 4 huse = 15000, hotel = 19000, Hus pris = 2000, Hotel pris = 2000, pant = 1800").setSubText("Pris: 3600 kr.")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[19] = new Street.Builder().setTitle("Strandvejen").setDescription("Leje af grund 350,  m/1 hus = 1600, 2 huse = 4400, 3 huse = 12000, 4 huse = 16000, hotel = 20000, Hus pris = 2000, Hotel pris = 2000, pant = 2000").setSubText("Pris: 4000 kr")
				.setBgColor(Color.gray).setFgColor(Color.black).build();
		fields[20] = new Refuge.Builder().setTitle("Parkering").setDescription("Du er pakeret").setSubText("Helle")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[21] = new Street.Builder().setTitle("Trianglen").setDescription("Leje af grund 350,  m/1 hus = 1800, 2 huse = 5000, 3 huse = 14000, 4 huse = 17500, hotel = 21000, Hus pris = 3000, Hotel pris = 3000, pant = 1800").setSubText("Pris: 4400 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[22] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[23] = new Street.Builder().setTitle("Østerbrogade").setDescription("Leje af grund 350,  m/1 hus = 1800, 2 huse = 5000, 3 huse = 14000, 4 huse = 17500, hotel = 21000, Hus pris = 3000, Hotel pris = 3000, pant = 2200").setSubText("Pris: 4400 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[24] = new Street.Builder().setTitle("Grønningen").setDescription("Leje af grund 400,  m/1 hus = 2000, 2 huse = 6000, 3 huse = 15000, 4 huse = 18500, hotel = 22000, Hus pris = 3000, Hotel pris = 3000, pant = 2400").setSubText("Pris: 4800 kr.")
				.setBgColor(Color.getHSBColor(224, 130, 131)).setFgColor(Color.black).build();
		fields[25] = new Shipping.Builder().setTitle("Scandlines G-R").setDescription("Leje af grund hvis du ejer 1 = 500, 2 = 1000, 3 = 2000, 4 huse = 4000").setSubText("Pris: 4000 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[26] = new Street.Builder().setTitle("Bredgade").setDescription("Leje af grund 450,  m/1 hus = 2200, 2 huse = 6600, 3 huse = 16000, 4 huse = 19500, hotel = 23000, Hus pris = 3000, Hotel pris = 3000, pant = 2600").setSubText("Pris: 5200 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[27] = new Street.Builder().setTitle("Kgs. Nytorv").setDescription("Leje af grund 450,  m/1 hus = 2200, 2 huse = 6600, 3 huse = 16000, 4 huse = 19500, hotel = 23000, Hus pris = 3000, Hotel pris = 3000, pant = 2600").setSubText("Pris: 5200 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[28] = new Brewery.Builder().setTitle("Carlsberg").setDescription("Hvis du ejer 1 terning = x100, 2=x200").setSubText("Pris: 3000 kr.").setRent("Rent: 700")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[29] = new Street.Builder().setTitle("Østergade").setDescription("Leje af grund 500,  m/1 hus = 2400, 2 huse = 7200, 3 huse = 17000, 4 huse = 20500, hotel = 24000, Hus pris = 3000, Hotel pris = 3000, pant = 2800").setSubText("Pris: 5600 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[30] = new Jail.Builder().setTitle("Fængslet").setDescription("Ryk til fængsel!").setSubText("Ryk til fængsel!")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[31] = new Street.Builder().setTitle("Amagertorv").setDescription("Leje af grund 550,  m/1 hus = 2600, 2 huse = 7800, 3 huse = 18000, 4 huse = 22000, hotel = 25000, Hus pris = 4000, Hotel pris = 4000, pant = 3000").setSubText("Pris: 6000 kr.")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[32] = new Street.Builder().setTitle("Vimmelskaftet").setDescription("Leje af grund 550,  m/1 hus = 2600, 2 huse = 7800, 3 huse = 18000, 4 huse = 22000, hotel = 25000, Hus pris = 4000, Hotel pris = 4000, pant = 2600").setSubText("Pris: 6000 kr.")
				.setRent("1600").setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[33] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[34] = new Street.Builder().setTitle("Nygade").setDescription("Leje af grund 600,  m/1 hus = 3000, 2 huse = 9000, 3 huse = 20000, 4 huse = 24000, hotel = 28000, Hus pris = 4000, Hotel pris = 4000, pant = 3200").setSubText("Pris: 6400 kr.")
				.setRent("2000").setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[35] = new Shipping.Builder().setTitle("Scandlines R-P").setDescription("Leje af grund hvis du ejer 1 = 500, 2 = 1000, 3 = 2000, 4 huse = 4000").setSubText("Pris: 4000 kr.")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[36] = new Chance.Builder()
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[37] = new Street.Builder().setTitle("Frederiksberggade").setDescription("Leje af grund 700,  m/1 hus = 3500, 2 huse = 10000, 3 huse = 22000, 4 huse = 30000, hotel = 40000, Hus pris = 4000, Hotel pris = 4000, pant = 3500").setSubText("Pris: 7000 kr.")
				.setBgColor(Color.orange).setFgColor(Color.black).build();
		fields[38] = new Tax.Builder().setTitle("").setDescription("Betal ekstraordinær statsskat 2000 kr.").setSubText("Betal ekstraordinær statsskat 2000 kr.")
				.setBgColor(Color.getHSBColor(241, 196, 15)).setFgColor(Color.black).build();
		fields[39] = new Street.Builder().setTitle("Rådhuspladsen").setDescription("Leje af grund 1000,  m/1 hus = 4000, 2 huse = 12000, 3 huse = 28000, 4 huse = 34000, hotel = 40000, Hus pris = 4000, Hotel pris = 4000, pant = 4000").setSubText("Pris: 8000 kr.")
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
	/**
	 * Input number of players, name of players and denies same name entries.
	 */
	
	public String[] numberOfPlayers() {
		int numberOfPlayers = GUI.getUserInteger("How many players are you? (between 2-6)", 2, 6);
		String[] playerNames = new String[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i++) {
			int number = i + 1; // The Array[] have to start at index 0, but the
								// player is number 1.
			boolean sameName = false;
			String[] tempArray = new String[6];
			String tempName = GUI.getUserString("Player " + String.valueOf(number));
			for (int j = 0; j < 6;j++){
				if(tempName.equals(tempArray[j])){
					sameName = true;
					i--;
					GUI.showMessage("Ugyldigt navn: navne må ikke være ens");
				}
				
			}
			if(sameName = false){
				playerNames[i] = tempName;
				tempArray[i] = tempName;
			}
			
		}
		return playerNames;
	}

	// Player choices for each new turn
	public String getUserInputTurn(Player thePlayer, String[] choices) {
		String input;
		input = GUI.getUserButtonPressed(thePlayer.toString() + " it's your turn. Take an action: ", choices);
		return input;
	}

	/**
	 * Moves vehicle on the board
	 * @param thePlayer type: Player
	 */
	public static void moveVehicle(Player thePlayer) {
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
	/**
	 * Prints message in GUI
	 * @param message type: String
	 * @author Jonas Larsen (s136335)
	 * @author Morten Velin (s147300)
	 */
	public static void printMessage(String message){
		GUI.showMessage(message);
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
	//public void removePlayer(Player thePlayer) {

		// Remove the players owned squares.
	//	int[] list = thePlayer.ownedID();
	//	ArrayList <Ownable> arr=thePlayer.returnOwned();
	//	for (int i = 0; i < list.length; i++) {
	//		GUI.removeOwner(list[i]);
	//		arr.get(i).clearOwner();
	//	}

		// Remove Car
	//	GUI.removeCar(thePlayer.getCurrentPosition()+1, thePlayer.toString());
	//	GUI.setBalance(thePlayer.toString(),0);
//	}

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
