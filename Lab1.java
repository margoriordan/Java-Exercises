package edu.cscc;

import java.util.Scanner;
import java.lang.Math;

/*
   Margaret Riordan
   CSCI-2476 | Lab 1: Free-fall Calc
   29 Aug 2023
 */

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        double time, distance, velocity;
        double acc = 32.0;

        System.out.println("Free-fall Calculator");
        System.out.print("Enter time (secs): ");
        time = input.nextDouble();

        distance = (acc/2) * (Math.pow(time,2.0)); // distance = (1/2) acc * (time^2)
        velocity = acc * time;

        System.out.println("Distance: " + distance + " feet");
        System.out.println("Velocity: " + velocity + " feet/sec.");
    }

}
