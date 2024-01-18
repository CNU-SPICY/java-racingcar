import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;

public class RacingCarsTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("소나타", "마티즈", "싼타페");
    }

    @DisplayName("RacingCar 생성이 잘 되는 지 테스트")
    @Test
    void racingCarCreationTest() {
        // when
        RacingCars racingCars = new RacingCars(carNames);

        // then
        assertThat(racingCars).isNotNull();
    }

    @DisplayName("RacingCars의 pickWinner 메서드 테스트")
    @Test
    void pickWinnerTest() {
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.racingOneGame();

        // then
        List<String> winners = racingCars.pickWinner(racingCars);
        assertThat(winners).isNotNull();
        assertThat(winners).isNotEmpty();
    }
}
