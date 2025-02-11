
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            roundsPlayed++;
            int attempts = playGame(scanner);
            if (attempts > 0) {
                roundsWon++;
                totalAttempts += attempts;
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        // Display final statistics
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Total Rounds Won: " + roundsWon);
        if (roundsWon > 0) {
            System.out.printf("Average Attempts per Win: %.2f\n", (double) totalAttempts / roundsWon);
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int maxAttempts = 7; // Limit on the number of guesses
        int attemptsTaken = 0;

        System.out.println("\nI've picked a number between 1 and 100. Try to guess it!");

        while (attemptsTaken < maxAttempts) {
            System.out.print("Attempt " + (attemptsTaken + 1) + "/" + maxAttempts + ": Enter your guess: ");

            // Validate input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int guess = scanner.nextInt();
            attemptsTaken++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attemptsTaken + " attempts.");
                return attemptsTaken;
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
        return 0; // Indicate the player did not guess the number
    }
}
