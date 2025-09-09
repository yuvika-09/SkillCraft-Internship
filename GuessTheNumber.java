import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // Random number between 1 and 100
        int userGuess = 0;
        int attempts = 0;

        System.out.println("=== Guess the Number Game ===");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts.");
            }
        }

        sc.close();
    }
}
