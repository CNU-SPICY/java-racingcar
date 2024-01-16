package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp(){
        final List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("Cars 생성자를 통해 car 객체 생성")
    void setNamesTest() {
        // then
        assertThat(cars.getCars())
                .extracting(Car::getName)
                .contains("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("Winner를 정상적으로 반환")
    void getWinnersTest() {
        // then
        assertThat(cars.getWinners())
                .contains("pobi", "crong", "honux");
    }
}