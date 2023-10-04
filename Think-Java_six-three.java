import java.util.Scanner;

/*write a method named gauss that takes x and n as arguments and returns
the sum fo the first nth terms of the series*/

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a, b;
        System.out.print("Enter number a: ");
        a = in.nextDouble();
        System.out.print("Enter number b:  ");
        b = in.nextDouble();
        System.out.println(gauss(a, b));



    }
    public static double gauss (double x, double n){
        double total = 0;
        for (int i = 0; i < n; i++){
            total += (Math.pow(-1, i) * Math.pow(x, 2*i) / factorial(i));
        } return total;

    }

    public static double factorial(int n){
        long fact = 1;
        for (int i = 2; i <= n; i++){
            fact = fact * i;
        } return fact;
    }
}

