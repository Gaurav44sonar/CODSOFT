import java.util.*;
import java.math.*;

public class Nummber_Guess_Game {
    private int guess_number = 0;
    private int user_guess = 0;

    Scanner scanner = new Scanner(System.in);

    public void guessNumberGame() {
        int attempts = 10;
        Random random = new Random();
        guess_number = random.nextInt(0, 100);

        System.out.println("Please guess the number....");
        System.out.println();
        int count = 0;
        while (attempts > 0) {
            System.out.println();
            System.out.print("Enter your guess number: ");
            user_guess = scanner.nextInt();
            if (guess_number == user_guess) {
                count++;
                attempts--;
                System.out.println("!!!! Congratulations You guess the number !!!!");
                System.out.println("You have taken " + count + " attempts to guess the number");
                System.out.println("Your score is: " + attempts * 10 + "/100");
                break;
            } else if (guess_number > user_guess) {
                System.out.println("You entered smaller number than guess number");
                count++;
                attempts--;
                System.out.println("Attempts remainings: " + attempts);
            } else if (guess_number < user_guess) {
                System.out.println("You entered larger number than guess number");
                count++;
                attempts--;
                System.out.println("Attempts remainings: " + attempts);
            }
        }
        if (attempts == 0) {
            System.out.println();
            System.out.println("You reached the maximum attempts.");
        }
    }

    public static void main(String[] args) {
        Nummber_Guess_Game nummber_Guess_Game = new Nummber_Guess_Game();
        System.out.println("--------------- NUMBER GUESS GAME ----------------- ");
        System.out.println();
        System.out.println("You have 10 attempts to guess a number");

        System.out.println("Do you want to start the game: Yes/No");
        String game_start_or_not = nummber_Guess_Game.scanner.next();

        System.out.println();

        if (game_start_or_not.equalsIgnoreCase("Yes")) {
            nummber_Guess_Game.guessNumberGame();
            System.out.println();
            int user_wish;
            do {
                System.out.println("Do you want to play again: Yes/No");
                String play_again = nummber_Guess_Game.scanner.next();
                user_wish = 0;
                if (play_again.equalsIgnoreCase("Yes")) {
                    nummber_Guess_Game.guessNumberGame();
                } else {
                    user_wish++;
                }
            } while (user_wish == 0);

        } else {
            System.out.println("Thanks you");
        }

    }
}