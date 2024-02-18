import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = {"java", "programming", "hangman", "computer", "coding"};
    private static final int MAX_TRIES = 5;
    private static final char HIDDEN_CHAR = '_';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        boolean[] letterGuessed = new boolean[26];
        int tries = 0;

        // Initialize guessedLetters array
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = HIDDEN_CHAR;
        }

        System.out.println("Welcome to Hangman!");
        System.out.print("Guess the word: ");
        printWithSpaces(guessedLetters);

        while (tries < MAX_TRIES) {
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (letterGuessed[guess - 'a']) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            letterGuessed[guess - 'a'] = true;

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (found) {
                System.out.print("Correct guess: ");
                printWithSpaces(guessedLetters);
            } else {
                tries++;
                System.out.println("Incorrect guess. Tries left: " + (MAX_TRIES - tries));
            }

            if (String.valueOf(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (tries == MAX_TRIES) {
            System.out.println("Sorry, you've run out of tries. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static void printWithSpaces(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
