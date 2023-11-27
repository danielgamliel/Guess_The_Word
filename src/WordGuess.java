import java.util.Scanner;


public class WordGuess {

    public static void main(String[] args) {
        String ABC = "abcdefghijklmnopqrstuvwxyz";
        // generate random word
        Word word = WordStock.Stock();
        Scanner scanner = new Scanner(System.in);
        System.out.println("The hidden word is: " + word.getHiddenWord());
        System.out.println("Guess a small letter");
        String guessedLetter = scanner.nextLine();
        WordGuess.guessFunc(ABC, guessedLetter, scanner, word, word.getHiddenWord());

    }

    public static String guessFunc(String ABC, String guessedLetter, Scanner scanner, Word word, String wordBefore) {
        String stars = "*****************************";
        String validGuess = validationFunc(ABC, guessedLetter, scanner);
        String updatedWord = word.updateTheWord(word.getLetters(), validGuess.charAt(0), wordBefore);
        if (!updatedWord.equals(word.getLetters())) {
            System.out.println("keep going");
            // removing the letters already chosen
            String newABC = ABC.substring(0, ABC.indexOf(validGuess))
                    + ABC.substring(ABC.indexOf(validGuess) + 1, ABC.length());
            guessedLetter = scanner.nextLine();
            return guessFunc(newABC, guessedLetter, scanner, word, updatedWord);
        } else {
            System.out.println(stars + "\n*** the hidden word is: " + updatedWord + "\n" + stars);
            System.out.println("The number of guesses: " + (26 - ABC.length() + 1));
            System.out.println("Type yes to play again");
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                main(null);
            }
            return wordBefore;
        }
    }

    // checking the guessed string is a small letter
    public static String validationFunc(String ABC, String guessed, Scanner scanner) {
        String tempABC = "abcdefghijklmnopqrstuvwxyz";
        while (tempABC.contains(guessed) && !ABC.contains(guessed)) {
            System.out.println("already chosen, you can guess one of those: " + ABC);
            guessed = scanner.nextLine();
        }
        while (!ABC.contains(guessed)) {
            System.out.println("not a small letter, guess again");
            guessed = scanner.nextLine();
        }
        return guessed;
    }

}
