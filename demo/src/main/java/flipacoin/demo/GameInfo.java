package flipacoin.demo;


import java.util.Map;

public class GameInfo {
    private int roundsPlayed;
    private Map<String, Integer> playerScores;

    public GameInfo() {
    }

    public GameInfo(int roundsPlayed, Map<String, Integer> playerScores) {
        this.roundsPlayed = roundsPlayed;
        this.playerScores = playerScores;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public Map<String, Integer> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Map<String, Integer> playerScores) {
        this.playerScores = playerScores;
    }

    @Override
    public String toString() {
        return "GameInfo{" +
                "roundsPlayed=" + roundsPlayed +
                ", playerScores=" + playerScores +
                '}';
    }
}
