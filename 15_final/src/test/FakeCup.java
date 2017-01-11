package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Cup;

public class FakeCup extends Cup{
	String[] cupArray = new String[100];
	int[] d1= new int[100];
	int[] d2= new int[100];
	private static int counter=0;

	public FakeCup(int testCaseNumber) {
		//System.out.println(new File("ajknsfhijoa").getAbsolutePath()); // FInd bib
		String fileName = "testData.csv";
		File file = new File(fileName);
		int i = 0;
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNextLine()) {
				cupArray[i++] = inputStream.nextLine().split(";")[testCaseNumber];
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Forkert");
		}
		
		for(i=0;i<cupArray.length;i++){
			if(cupArray[i] == null)
				break;
			d1[i]=Integer.valueOf(cupArray[i].split(",")[0]);
			d2[i]=Integer.valueOf(cupArray[i].split(",")[1]);
		}
	}
	@Override
	public int roll(){
		counter++;
		int value=d1[counter]+d2[counter];
		return value;
	}
	/**
	 * Method for getting the result of the roll.
	 * 
	 * @return sum of the two dices.
	 */
	public int getSum() {
		return d1[counter] + d2[counter];
	}

	/**
	 * Method for identifying if the two die show the same value.
	 * 
	 * @return true if the two dices shows the same eyes.
	 */
	public boolean getEquals() {
		boolean res = false;
		if (d1[counter] == d2[counter]) {
			res = true;
		}
		return res;
	}

	/**
	 * Method for getting the value of dice 1.
	 * 
	 * @return value of dice 1.
	 */
	public int getD1() {
		return d1[counter];
	}

	/**
	 * Method for getting the value of dice 2.
	 * 
	 * @return value of dice 2.
	 */
	public int getD2() {
		return d2[counter];
	}
}
