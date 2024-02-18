import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;  // Define lower bound of the range
        int upperBound = 100;  // Define upper bound of the range
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;  // Generate random number
        
        int attempts = 0;
        final int maxAttempts = 10;  // Maximum number of attempts allowed
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ". Guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number: " + randomNumber);
                break;
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
        }

        scanner.close();
    }
}
