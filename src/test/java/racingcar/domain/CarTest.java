package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("Test");
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    @DisplayName("move(arg) 테스트")
    void moveTest(int arg, int expected) {
        // given
        int position = car.getPosition();

        // when
        car.move(arg);

        // then
        assertThat(car.getPosition()).isEqualTo(position+expected);
    }

    @Test
    @DisplayName("isSamePosition() 테스트")
    void isSamePositionTest() {
        // given
        Car other = new Car("Other");

        // when
        Boolean result = car.isSamePosition(other);

        // then
        assertThat(result).isEqualTo(true);
    }



}