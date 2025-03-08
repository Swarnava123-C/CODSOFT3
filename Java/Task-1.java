import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\n🔢 I've picked a number between 1 and 100. Try to guess it!");
            System.out.println("🔥 You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("🏆 Your current score: " + totalScore);

            System.out.print("\n🔄 Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n👋 Thanks for playing! Your final score: " + totalScore);
        scanner.close();
    }
}
//Output:
/*? Welcome to the Number Guessing Game! ?

? I've picked a number between 1 and 100. Try to guess it!
? You have 10 attempts.
Enter your guess: 4
? Congratulations! You guessed the number in 1 attempts.
? Your current score: 10

? Do you want to play again? (yes/no): no

? Thanks for playing! Your final score: 10 */
