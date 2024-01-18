package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @ParameterizedTest
    @DisplayName("난수값에 따른 단일자동차 이동여부 테스트")
    @CsvSource({"0,0","1,0","2,0","3,0",
            "4,1","5,1","6,1","7,1","8,1","9,1"})
    void moveCarBasedOnRandomInt(int input, int expected) {
        //given
        Car car = new Car("pobi");
        //when
        car.move(input);
        //then
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}