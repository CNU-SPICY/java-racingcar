package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Random;

class RacingGameTest {
    String[] names = {"pobi", "crong", "loopy"};
    RacingGame racingGame = new RacingGame(names);
    @Mock
    Random mockRandom = mock(Random.class);
    @ParameterizedTest
    @DisplayName("Cars Move Test")
    @CsvSource({"0,0","1,0","2,0","3,0",
            "4,1","5,1","6,1","7,1","8,1","9,1"})
    void moveCars(int input, int expected) {
        when(mockRandom.nextInt(10)).thenReturn(input);
        racingGame.moveCars();
        Car[] cars = racingGame.getCars();
        for(Car car: cars){
            assertThat(car.getDistance()).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("Find Winner Test")
    void findWinners() {
        when(mockRandom.nextInt(10)).thenReturn(5);
        racingGame.moveCars();
        racingGame.findWinners();
        assertThat(racingGame.getWinners()).isEqualTo(Arrays.asList("pobi", "crong", "loopy"));
    }
}