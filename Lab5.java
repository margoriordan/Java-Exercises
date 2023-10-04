package edu.cscc;

import java.util.Scanner;
import java.util.Arrays;

//Margaret (Margo) Riordan | 29 Sept 2023 | CSCI-2467 | Lab 5 - Grocery List with duplication checker

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String [] args){

        int count = 0;
        String [] groceryList = new String [6];


        while (count < groceryList.length){
            System.out.print("Enter grocery item: ");
            String newItem = input.nextLine();

            if (!isDuplicate(newItem, groceryList, count)){
                groceryList[count] = newItem;
                count++;
            } else {
                System.out.println("Sorry, the item '" + newItem + "' is a duplicate.");
            }

        }

        Arrays.sort(groceryList);

        System.out.println();
        System.out.println("Your grocery list:");
        for (String listItem : groceryList){
            System.out.println(listItem);
        }

    }
    public static boolean isDuplicate(String item, String[] list, int listcnt){
        boolean foundDuplicate = false;
        for (int i = 0; i <= listcnt; i++) {
            if (item.equalsIgnoreCase(list[i])){
                foundDuplicate = true;
            }
        }
        return foundDuplicate;
    }

    }

