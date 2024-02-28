package flipacoin.demo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;

public class SimpleCoinFlipGame implements CoinFlipGame {
    private List<Player> players = new ArrayList<>();
    private int maxRounds = 5; // Set the default number of rounds
    private Random random = new Random();

    public SimpleCoinFlipGame(Player player1, Player player2) {
    }

    public SimpleCoinFlipGame() {
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int index) {
        if (index >= 0 && index < players.size()) {
            return players.get(index);
        } else {
            return null;
        }
    }

    public void resetScores() {
        for (Player player : players) {
            player.resetScore();
        }
    }

    @Scheduled(fixedRate = 3600000) // Reset scores after an hour (3600000 milliseconds)
    public void resetScoresAfterAnHour() {
        resetScores();
    }

    @Override
    public void play() {
        if (players.isEmpty()) {
            System.out.println("No players to play the game.");
            return;
        }

        for (int rounds = 0; rounds < maxRounds; rounds++) {
            System.out.println("Round " + (rounds + 1));
            int coinFlipResult = random.nextInt(2) + 1;

            for (Player player : players) {
                int playerGuess = player.getGuess();
                System.out.print("The coin flip result is ");
                if (coinFlipResult == 1) {
                    System.out.println("Heads.");
                } else {
                    System.out.println("Tails.");
                }

                if (playerGuess == coinFlipResult) {
                    System.out.println(player.getName() + " guessed correctly.");
                    player.updateScore(1);
                } else {
                    System.out.println(player.getName() + " guessed wrong.");
                }
            }
        }

        System.out.println("Game Over!");
        for (Player player : players) {
            player.displayScore();
        }
        saveGame();
    }

    @Override
    public void loadGame() {
        try (BufferedReader reader = new BufferedReader(new FileReader("players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String playerName = line;
                int playerScore = Integer.parseInt(reader.readLine());
                Player player = new SimplePlayer(playerName);
                player.updateScore(playerScore);
                players.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveGame() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("players.txt", false))) {
            for (Player player : players) {
                writer.write(player.getName());
                writer.newLine();
                writer.write(Integer.toString(player.getScore()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving player information.");
        }
    }

    @Override
    public int getRoundsPlayed() {
        return maxRounds;
    }

    @Override
    public String playRound(String name, int guess) {
        if (players.isEmpty()) {
            return "No players to play the game.";
        }

        int coinFlipResult = random.nextInt(2) + 1;

        for (Player player : players) {
            if (player.getName().equals(name)) {
                int playerGuess = guess;

                if (playerGuess == coinFlipResult) {
                    player.updateScore(1);
                    System.out.println(player.getName() + " guessed correctly.");
                } else {
                    System.out.println(player.getName() + " guessed wrong.");
                }
            }
        }

        System.out.println("Game Over!");
        for (Player player : players) {
            player.displayScore();
        }
        saveGame();
        return "Game Over!";
    }
}
