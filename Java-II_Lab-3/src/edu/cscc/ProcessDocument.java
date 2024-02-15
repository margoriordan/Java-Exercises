package edu.cscc;

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class ProcessDocument {
	
	public static ArrayList<String> processDocument(File myFile) {
		
		ArrayList<String> invalidNumbers = new ArrayList<>();
		int lineNumber = 0;
		
		try( Scanner input = new Scanner (myFile)){
			
		while (input.hasNextLine()) {
			lineNumber++;
			String textLine = input.nextLine();
			boolean result = comparePatterns(textLine, validPatterns);
			
			if(!result) {
			
				invalidNumbers.add("Line " + lineNumber + ": Invalid phone number " + "\"" + textLine + "\"");
											}
			}
		
		} catch (FileNotFoundException ex) {
			
			System.out.print("Error opening file!");
		}
		
		return invalidNumbers;
		
		
	}
	
	private static boolean comparePatterns(String text, String[] validPatterns) {
		
		for (String numberPattern : validPatterns) {
			
			Pattern pattern = Pattern.compile(numberPattern);
			Matcher matcher = pattern.matcher(text);
			
			if(matcher.matches()) {
				
				return true;
			}
			
		}
		return false;
	}
	
	static String[] validPatterns = {
			
			"\\([2-9]\\d{2}\\) \\d{3}-\\d{4}",
			"[2-9]\\d{2}-\\d{3}-\\d{4}",
			"[2-9]\\d{9}"
	};

}
