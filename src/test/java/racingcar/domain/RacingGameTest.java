package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

class RacingGameTest {
    String[] names = {"pobi", "crong", "loopy"};
    RacingGame racingGame = new RacingGame(names);

    @ParameterizedTest
    @DisplayName("난수값에 따른 다수의 자동차 이동여부 테스트")
    @CsvSource({"0,0","1,0","2,0","3,0",
            "4,1","5,1","6,1","7,1","8,1","9,1"})
    void moveCarsBasedOnRandomInt(int input, int expected) {
        racingGame.moveCars(input);
        Car[] cars = racingGame.getCars();
        for(Car car: cars){
            assertThat(car.getDistance()).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("경주 후 승리 자동차 탐색 테스트")
    void findWinners() {
        racingGame.moveCars(5);
        assertThat(racingGame.findWinners()).isEqualTo(Arrays.asList("pobi", "crong", "loopy"));
    }
}