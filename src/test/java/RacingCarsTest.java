import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @DisplayName("RacingCar 생성이 잘 되는 지 테스트")
    @Test
    void RacingCarCreationTest() {
        // given
        String carNames = "소나타,마티즈,싼타페";

        // when
        RacingCars racingCars = new RacingCars(carNames);

        // then
        assertThat(racingCars).isNotNull();
    }

    @DisplayName("RacingCars의 racingOneGame 메서드 테스트")
    @Test
    void RacingOneGameTest() {
        // given
        String carNames = "소나타,마티즈,싼타페";
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.racingOneGame();

        // then
        assertThat(racingCars.getAllCurrentBarStatus().toString()).isNotEmpty();
    }

    @DisplayName("RacingCars의 pickWinner 메서드 테스트")
    @Test
    void PickWinnerTest() {
        // given
        String carNames = "소나타,마티즈,싼타페";
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.racingOneGame();

        // then
        List<String> winners = racingCars.pickWinner(racingCars);
        assertThat(winners).isNotNull();
        assertThat(winners).isNotEmpty();
    }

}
