package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class msgL {
	private static String[] info_danish = new String[1000];
	private static String[] info_english = new String[1000];
	static String lang="dk";
	
	static {
		System.out.println(new File("ajknsfhijoa").getAbsolutePath()); // FInd bib.
		String fileName = "Lastfile.csv";
		File file = new File(fileName);
		int Danish = 2;
		int English = 3; 
		int i = 0;
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNextLine()) {
				info_danish[i++] = inputStream.nextLine().split(";")[Danish];
				info_english[i++] = inputStream.nextLine().split(";")[English];
			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("Forkert");
		}
	}
	public static String msg(int index){
		if(lang.equals("en")){
			return info_english[index];
		}
		else{
			return info_danish[index];
		}
	}
//	public static void changeLanguage(){
//		String l =GUIControl.giveLanguageChoice();
//		if(l.equals("en")){
//			lang="en";
//		}else{
//			lang="dk";
//		}
//	}
}
