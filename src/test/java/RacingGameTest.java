package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import main.java.racingcar.domain.RacingGame;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] carNames = {"Car1", "Car2"};
        racingGame = new RacingGame(carNames, 5);
    }

    @Test
    void testGenerateStatus() {
        // when
        List<String> statusList = racingGame.generateStatus();

        // then
        for (String status : statusList) {
            assertTrue(status.matches("(Car1|Car2) : -+"));
        }
    }

    @Test
    void testGetWinners() {
        // when
        racingGame.race();
        List<String> winners = racingGame.getWinners();

        // then
        assertTrue(winners.contains("Car1"));
        assertFalse(winners.contains("Car2"));
    }
}

