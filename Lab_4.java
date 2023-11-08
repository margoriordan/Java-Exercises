package edu.cscc;
import java.util.Scanner;

//Margaret (Margo) Riordan | 19 Sept 23 | Lab 4 - Loops: Multiplication Table

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main (String[] args){


        System.out.print("Enter size of multiplication table: ");
        int numLoops = input.nextInt();

        for (int i = 1; i <= numLoops; i++){
            for (int h = 1; h <= numLoops; h++){
                System.out.print(i + " * " + h + " = " + (h * i) + "  ");
            }
            System.out.println();
        }

    }
}
