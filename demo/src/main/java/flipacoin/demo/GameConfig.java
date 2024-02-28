package flipacoin.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GameConfig {
    @Bean
    public CoinFlipGame coinFlipGame() {
        return new SimpleCoinFlipGame();
    }

    @Override
    public String toString() {
        return "GameConfig []";
    }
}

