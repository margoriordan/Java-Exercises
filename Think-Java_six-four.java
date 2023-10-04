import java.util.Scanner;
/* write a method to determines if a word is an abecedarian...this means that the letters
used to spell the word are in alphabetical order*/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input;
        System.out.print("Enter a word: ");
        input = in.nextLine();

        System.out.print(isAbecedarian(input));
        
    }
    public static boolean isAbecedarian (String word){
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++){
            if (word.charAt(i) < word.charAt(i+1)){
                i += 1;
            }
            else {
                return false;
            }
        }

        return true;
    }


}