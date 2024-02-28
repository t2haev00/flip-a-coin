package flipacoin.demo;


public interface Player {
    String getName();
    int getGuess();
    void updateScore(int score);
    void displayScore();
    void resetScore();
    int getScore();
}




