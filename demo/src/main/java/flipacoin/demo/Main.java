package flipacoin.demo;


import org.springframework.web.client.RestTemplate;

public class Main {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Create Player 1
        String player1Name = "Player1";
        String createPlayerUrl = "http://localhost:8080/coinflip/player?name=" + player1Name;
        restTemplate.postForObject(createPlayerUrl, null, String.class);

        // Create Player 2
        String player2Name = "Player2";
        String createPlayerUrl2 = "http://localhost:8080/coinflip/player?name=" + player2Name;
        restTemplate.postForObject(createPlayerUrl2, null, String.class);

        // Start a new game
        String createGameUrl = "http://localhost:8080/coinflip/game";
        restTemplate.postForObject(createGameUrl, null, String.class);

        // Make game moves
        String makeMoveUrl = "http://localhost:8080/coinflip/game/move?name=Player1&guess=1"; // Replace with actual moves
        restTemplate.put(makeMoveUrl, null, String.class);
    }
}

