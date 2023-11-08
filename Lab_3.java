package edu.cscc;

//Margaret (Margo) Riordan | 11 Sept 2023 | CSCI-2467 | Lab 3: Calculate BMI

import java.util.Scanner;
import java.lang.Math;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

    //initialize variables
    double lbs, inches, kilos, meters, bmi;
    String classification;

    //collect input from user
    System.out.println("Calculate BMI");

    System.out.print("Enter weight (lbs): ");
    lbs = input.nextDouble();

    System.out.print("Enter height (inches): ");
    inches = input.nextDouble();

    //logic
    kilos = convertToKilograms(lbs);
    meters = convertToMeters(inches);
    bmi = calcBMI(kilos, meters);
    classification = bmiClassification(bmi);

    //results
    System.out.println("Your BMI is "+ bmi);
    System.out.println("Your BMI classification is "+ "'" + classification + "'");
}

    //methods

    public static double convertToKilograms(double lbs){
        return lbs/2.2046;
    }

    public static double convertToMeters(double inches){
        return inches/39.37;
    }

    //bmi = kg/m^2
    public static double calcBMI( double kilos, double meters){
        return kilos/(Math.pow(meters, 2));
    }

    public static String bmiClassification(double bmi) {

        String bmiClassification;

        if (bmi < 18.5) {
            bmiClassification =  "underweight.";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            bmiClassification =  "normal.";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            bmiClassification =  "overweight.";
        } else {
            bmiClassification =  "obese.";
        }
        return bmiClassification;
    }

}
