import generator.MovableNumberGenerator;
import generator.NonMovableNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.*;


public class RacingCarTest {

    @DisplayName("random number가 4보다 크거나 같을 때의 Car 위치 테스트")
    @Test
    void greaterThenFourCarPositionUpdateTest() {
        // given
        final RacingCar car = new RacingCar("마티즈");
        final NumberGenerator numberGenerator = new MovableNumberGenerator();

        // when
        car.carPositionUpdate(numberGenerator);

        // then
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @DisplayName("random number가 4보다 작을 때의 Car 위치 테스트")
    @Test
    void lessThenFouCarPositionUpdateTest() {
        // given
        final RacingCar car = new RacingCar("모닝");
        final NumberGenerator numberGenerator = new NonMovableNumberGenerator();

        // when
        car.carPositionUpdate(numberGenerator);

        // then
        assertThat(car).extracting("position").isEqualTo(0);
    }

    @DisplayName("RacingCar의 Bar Status 정보를 제대로 지니고 있는지 테스트")
    @Test
    void eachCarHaveBarStatusTest() {
        // given
        final RacingCar car = new RacingCar("소나타");
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        car.carPositionUpdate(numberGenerator);

        // when
        StringBuilder currentBarStatus = car.getCurrentBarStatus();

        // then
        assertThat(currentBarStatus.toString()).isEqualTo("소나타 : -");
    }


}
