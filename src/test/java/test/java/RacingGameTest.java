package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.racingcar.domain.RacingGame;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        int tryCount = 5;
        racingGame = new RacingGame(carNames, tryCount);
    }

    @Test
    void race_ShouldUpdateDistances_WhenCalled() {
        // given & when
        racingGame.race();

        // then
        for (int distance : racingGame.getDistances()) {
            assertTrue(distance == 0 || distance == 1);
        }
    }

    @Test
    void getWinners_ShouldReturnEmptyList_WhenNoCarReachedTryCount() {
        // when
        List<String> winners = racingGame.getWinners();

        // then
        assertTrue(winners.isEmpty());
    }

    @Test
    void getWinners_ShouldReturnWinningCars_WhenSomeCarReachedTryCount() {
        // when
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.race();
        }

        List<String> winners = racingGame.getWinners();

        // then
        assertFalse(winners.isEmpty());
        assertEquals(racingGame.getCars().size(), winners.size());
    }
}