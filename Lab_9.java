package edu.cscc;
import java.util.Scanner;

/**
 * Calculate Target Heart Rate and Maximum Heart Rate using the Karvonen Method
 * @author Margaret Riordan
 */
public class Main {
    private static Scanner input = new Scanner(System.in);

    /**
     * Main method - get user input and calculate / output target and maximum heart rate
     * @param args not used
     */
    public static void main(String[] args) {
        double restingHR = getRestingHR();
        double age = getAge();
        System.out.println("Your target heart rate is: " +
                calculateTargetHR(restingHR, age, 0.65) + " to " +
                calculateTargetHR(restingHR, age, 0.85)
        );
        System.out.println("Your maximum heart rate is: "+calculateMaxHR(age));
    }

    /**
     * Get resting heart rate
     * @return resting heart rate
     */
    public static double getRestingHR() {
        String userInputHR;
        Double restingHR = null;
        boolean validInput = false;
        do {
            System.out.print("Enter your resting heart rate: ");
            userInputHR = input.nextLine();
            try {
                restingHR = Double.parseDouble(userInputHR);
                if (restingHR <= 0) {
                    System.out.println("Invalid input: must be greater than 0");
                } else {
                    validInput = true;
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Invalid input: provide a number.");
            }
        } while (!validInput) ;
        return restingHR;
    }

    /**
     * Get person's age (years)
     * @return person's age
     */
    public static double getAge() {
        String userInputAge;
        Double age = null;
        boolean validInput = false;

        do {
            System.out.print("Enter your age: ");
            userInputAge = input.nextLine();
            try {
                age = Double.parseDouble(userInputAge);
                if (age <= 0){
                    System.out.println("Invalid input: must be greater than 0.");
                } else {
                    validInput = true;
                }
            } catch (NullPointerException | NumberFormatException e){
                System.out.println("Invalid input: provide a number.");
            }

        } while (!validInput);

        return age;
    }

    /**
     * Calculate maximum heart rate for aerobic exercise
     * @param age persons are
     * @return maximum hear rate
     */
    public static int calculateMaxHR(double age) {
        double maxHR = 220 - age;
        return (int)maxHR;
    }

    /**
     * Calculate target heart rate for aerobic exercise
     * @param restingHR resting heart rate
     * @param age person age (years)
     * @param intensity intensity of exercise (percentage 0.0 - 1.0)
     * @return target heart rate for a given intensity aerobic workout
     */
    public static int calculateTargetHR(double restingHR, double age, double intensity) {
        double targetHR = (((calculateMaxHR(age) - restingHR) * intensity) + restingHR);
        return (int)targetHR;
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