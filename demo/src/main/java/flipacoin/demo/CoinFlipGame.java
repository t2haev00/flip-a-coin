package flipacoin.demo;



public interface CoinFlipGame {
    void loadGame();
    void play();
    void saveGame();
    void addPlayer(Player player);
    Player getPlayer(int index);
    void resetScores();
    int getRoundsPlayed();
    String playRound(String name, int guess);
}