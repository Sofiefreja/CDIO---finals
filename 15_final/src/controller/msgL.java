package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class msgL {
	private static String[] info_danish = new String[1000];
	private static String[] info_english = new String[1000];
	static String lang="Dansk";
	
	static {
		//System.out.println(new File("Language.csv").getAbsolutePath()); // FInd bib.
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
				tempString=inputStream.nextLine();
				info_danish[i++] = tempString.split("\t")[Danish];
				info_english[j++] = tempString.split("\t")[English];
			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("Forkert filnavn");
		}
	}
	public static String msg(int index){
		if(lang.equals("English")){
			return info_english[index];
		}
		else{
			return info_danish[index];
		}
	}
	/**
	 * 
	 * @param language
	 * @return
	 */
	public static void changeLanguage(String language){
		if(language.equals("English")){
			lang="English";
		}else if(language.equals("Dansk")){
			lang="Dansk";
		}
	}
}
