package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarApplicationTest {
    RacingCarApplication app = new RacingCarApplication();
    private static ArrayList<String> win_list = new ArrayList<>();
    private Car[] car_list = {new Car("pobi"), new Car("crong"), new Car("loopy"),};


    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("경주 - 이동 메서드")
    void moveRacing(int input) {
        app.moveRacing(car_list);
        assertThat(car_list[input].getDistance() == 0 || car_list[input].getDistance() == 1).isTrue();
    }
}