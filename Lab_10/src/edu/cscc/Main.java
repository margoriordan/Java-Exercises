package edu.cscc;

import java.io.*;
import java.util.Scanner;

/**
 * Generate report based on file contents
 * @author Margaret Riordan
 */
public class Main {
    static final String INPUTFILE = "components.txt";
    static final String PRINTFFORMAT = "%20s %2d    %6.2f\n";
    public static void main(String[] args) {
    	double total = 0;
	    File infile = new File(INPUTFILE);
	    System.out.printf("%s%n","           Component Units Price");

	    // TODO - add code that reads the input file, prints a component report, and calculates total cost
        try (
                Scanner input = new Scanner(infile)
        ){

            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] lineArray = line.split(",");
                String component = lineArray[0];
                int units = Integer.parseInt(lineArray[1]);
                double price = Double.parseDouble(lineArray[2]);
                total += price * units;

                System.out.printf(PRINTFFORMAT, component,units,price);

            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Error opening file " + INPUTFILE + ": " + ex.getMessage());
        } catch (NumberFormatException ex){
            System.out.println("Error processing string to number " + INPUTFILE + ": " + ex.getMessage());
        }
	    System.out.println("Total cost: " + total);
    }
}

/*
 * Copyright Notice: Columbus State Community College and its employees hold the copyright for this course material. This material is
 * made available to students for their personal use only and may not be distributed for commercial purposes without the College’s
 * express written consent. Uploading this copyrighted material to "tutoring" or other non-Columbus State web sites is prohibited and
 * may result in referral to the Office of Student Conduct and disciplinary action up to and including dismissal.
 *
 * Course ID: 40A9B085A383430396E7BACF467DE6E0
 */