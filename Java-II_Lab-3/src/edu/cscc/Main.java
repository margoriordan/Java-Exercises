package edu.cscc;

import java.io.File;
import java.util.*;

public class Main {
	
	private static final String fileName = "phoneno.txt";
	
	public static void main(String[] args) {
		
		File file = new File(fileName);
		
		if (file.exists()) {
			ArrayList<String> invalidNumbers = ProcessDocument.processDocument(file);
			for (String line : invalidNumbers) {
				System.out.println(line);
		} 
			} else { 
				System.out.println("File not found.");
			}
		System.out.println("Done");
		
		} 
	}


		
	
	
	

