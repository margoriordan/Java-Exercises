import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a, y;
        System.out.print("Enter number: ");
        a = in.nextDouble();
        System.out.print("Enter  ");
        y = in.nextDouble();
        System.out.println("The square root is " + sqroot(a));



    }
    public static double sqroot (double a){
        double x, newx;
        x = a/2;
        newx = ((x + (a/x))/2);
        while (Math.abs(x-newx) > 0.0001){
            x = ((x + (a/x))/2);
            newx = ((x + (a/x))/2);

        } return newx;
    }}