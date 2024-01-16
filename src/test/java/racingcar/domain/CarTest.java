package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("move() 인자 값에 따른 position 값 변화")
    void moveTest(int arg, int expected) {
        // given
        Car car = new Car("Test");
        int position = car.getPosition();

        // when
        car.move(arg);

        // then
        assertThat(car.getPosition()).isEqualTo(position+expected);
    }

    @Test
    @DisplayName("position이 같은 두 car 객체에 대해 position이 같음을 판단")
    void isSamePositionTest() {
        // given
        Car car = new Car("Test");
        Car other = new Car("Other");

        // when
        Boolean result = car.isSamePosition(other);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 이름이 5글자보다 클 때 테스트")
    void nameValidator() {
        // when
        Throwable thrown = catchThrowable(()->{
            Car car = new Car("Test Car");
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하로 입력해주세요.");
    }
}