package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class msgL {
	private static String[] info_danish = new String[1000];
	private static String[] info_english = new String[1000];
	static String lang="Dansk";
	
	//the static block runs as soon as a method in this class has been initiated.
	static {
		String fileName = "language2";
		File file = new File(fileName);
		String tempString;
		int Danish = 1;
		int English = 2; 
		int i = 0;
		int j = 0;
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNextLine()) {
				tempString=inputStream.nextLine();//stores the next line in a temporary string
				info_danish[i++] = tempString.split("\t")[Danish];//splits the text by tabs
				info_english[j++] = tempString.split("\t")[English];
			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("Forkert filnavn");
		}
	}
	/**
	 * Getter for the String arrays with messages.
	 * @param index
	 * @return string
	 */
	public static String msg(int index){
		if(lang.equals("English")){
			return info_english[index];
		}
		else{
			return info_danish[index];
		}
	}
	/**
	 * Changes the language of the strings msg() returns
	 * @param language
	 */
	public static void changeLanguage(String language){
		if(language.equals("English")){
			lang="English";
		}else if(language.equals("Dansk")){
			lang="Dansk";
		}
	}
}
