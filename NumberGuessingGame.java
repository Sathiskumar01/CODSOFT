import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static final int min = 1;
    private static final int max = 100;
    private static final int att = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totrd = 0;
        int totatt = 0;
        int rw = 0;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            int no = generateRandomNumber(random,min, max);
            int attempts = 0;

            System.out.printf("Guess the number between %d and %d.%n",min, max);

            while (attempts < att) {
                int userGuess = getUserGuess(sc);

                if (userGuess == no) {
                    System.out.printf("Congratulations! You guessed the number %d in %d attempts.%n", no, attempts + 1);
                    totatt += attempts + 1;
                    rw++;
                    break;
                } else if (userGuess < no) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                attempts++;
            }

            totrd++;
            playAgain = askToPlayAgain(sc);
        }

        displayGameSummary(totrd, totatt, rw);
        sc.close();
    }

    private static int generateRandomNumber(Random random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess(Scanner sc) {
        System.out.print("Enter your guess: ");
        return sc.nextInt();
    }

    private static boolean askToPlayAgain(Scanner sc) {
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgainInput = sc.next().toLowerCase();
        return playAgainInput.equals("yes");
    }

    private static void displayGameSummary(int totrd, int totatt, int rw) {
        System.out.printf("Game Over!%nTotal Rounds Played: %d%nTotal Attempts: %d%nRounds Won: %d%n",
                totrd, totatt, rw);
    }
}
