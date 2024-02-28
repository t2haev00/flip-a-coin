package flipacoin.demo.application;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import flipacoin.demo.Player;
import flipacoin.demo.SimpleCoinFlipGame;
import flipacoin.demo.SimplePlayer;

@RestController
@RequestMapping("/coinflip")
public class CoinFlipController {
    private List<Player> players = new ArrayList<>();
    private SimpleCoinFlipGame game;

    @PostMapping("/player")
    public String createPlayer(@RequestParam String name) {
        Player newPlayer = new SimplePlayer(name);
        players.add(newPlayer);
        return "Player " + name + " created.";
    }

    @PostMapping("/game")
    public String createGame() {
        if (players.size() < 2) {
            return "Both players must be created. Create players first.";
        }

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        game = new SimpleCoinFlipGame(player1, player2);
        game.loadGame(); // Load the game state
        return "New game created.";
    }

    @PutMapping("/game/move")
    public String makeGameMove(@RequestParam String name, @RequestParam int guess) {
        if (game == null) {
            return "No game created. Create a game first.";
        }

        if (guess != 1 && guess != 2) {
            return "Invalid guess. Guess must be 1 for Heads or 2 for Tails.";
        }

        // Implement your game move logic here
        String result = game.playRound(name, guess);

        if (result.equals("Game Over!")) {
            // The game is over, you can handle it accordingly
        }

        return result;
    }

    @GetMapping("/player")
    public String getPlayerInfo(@RequestParam String name) {
        // Implement getting player information here
        return "Player information for " + name;
    }
}
