package edu.cscc;

import java.util.Scanner;

//Margaret (Margo) Riordan | 06 Sept 23 | CSCI-2467 Lab 2 | Hurricane Wind Scale
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        long speed;
        String classification;

        System.out.print("Enter wind speed (mph): ");
        speed = input.nextLong();

        if (speed < 0) {
                classification = "Invalid input";
            }
        else if (speed < 39) {
                    classification = "Not in scale.";
            }
        else if (speed < 74){
                    classification = "Tropical storm.";
            }
        else if (speed < 96){
                    classification = "Category one hurricane.";
            }
        else if (speed < 111){
                    classification = "Category two hurricane.";
            }
        else if (speed < 130){
                    classification = "Category three hurricane!";
            }
        else if (speed < 157){
                    classification = "Category four hurricane!";
            }
        else {
                //if speed is equal to or greater than 157 mph
                    classification = "Category five hurricane!";
            }

        System.out.println("Classification: " + classification);
    }
}
