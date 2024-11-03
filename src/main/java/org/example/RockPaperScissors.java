package org.example;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public void playGame(Scanner scanner) {
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("Enter your choice (Rock, Paper, Scissors) or 'quit' to exit: ");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("quit")) {
                break;
            }

            if (!userChoice.equalsIgnoreCase("Rock") &&
                    !userChoice.equalsIgnoreCase("Paper") &&
                    !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
                continue;
            }

            String computerChoice = choices[random.nextInt(choices.length)];
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                    (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                    (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }

            System.out.printf("Score - You: %d, Computer: %d%n", userScore, computerScore);
            System.out.println();
        }

        System.out.println("Thanks for playing! Final Score - You: " + userScore + ", Computer: " + computerScore);
    }
}
