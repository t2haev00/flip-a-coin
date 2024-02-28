package flipacoin.demo;


import java.util.Scanner;


// Player implementation

public class SimplePlayer implements Player {
    private String name;
    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public SimplePlayer(String name) {
        this.name = name;
    }
// Getters and Setters
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    // Get the player's guess (1 for Heads, 2 for Tails)
    @Override
    public int getGuess() {
        int guess = -1;
        while (guess != 1 && guess != 2) {
            try {
                System.out.print(name + ", enter your guess (1 for Heads, 2 for Tails): ");
                guess = Integer.parseInt(scanner.nextLine());
                if (guess != 1 && guess != 2) {
                    System.out.println("Invalid input. Please enter 1 for Heads or 2 for Tails.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 for Heads or 2 for Tails.");
            }
        }
        return guess;
    }

    // Update the player's score

    @Override
    public void updateScore(int score) {
        this.score += score;
    }

    // Display the player's score

    @Override
    public void displayScore() {
        System.out.println(name + "'s score: " + score);
    }

    // Reset the player's score

    @Override
    public void resetScore() {
        score = 0;
    }

    // Get the player's score

    @Override

    public int getScore() {
        return score;
    }
   
}