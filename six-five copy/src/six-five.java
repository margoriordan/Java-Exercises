import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Is your word a Doubloon? Enter a word: ");
        String userWord;
        userWord = in.nextLine();

        int wordLength = userWord.length();
        userWord = userWord.toLowerCase();
        int occurances = 1;
        char otherChar;
        for (int i = 0; i < (wordLength-1); i++){
            otherChar = userWord.charAt(i+1);
            if (userWord.charAt(i) == otherChar){
                occurances++;
                otherChar=userWord.charAt(i+2);
            }
        }System.out.print(occurances);
    }
}



