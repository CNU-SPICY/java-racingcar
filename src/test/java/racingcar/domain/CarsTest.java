package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @BeforeEach
    void setUp(){
        Cars.setNames("pobi,crong,honux");
    }

    @Test
    @DisplayName("setNames() 테스트")
    void setNamesTest() {
        // given

        // when
        List<String> result = Cars.getCars().stream().map(Car::getName).collect(Collectors.toUnmodifiableList());

        // then
        assertThat(result).contains("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("getWinners() 테스트")
    void getWinnersTest() {
        // given

        // when
        List<String> result = Cars.getWinners();

        // then
        assertThat(result).isNotEmpty();
    }

}