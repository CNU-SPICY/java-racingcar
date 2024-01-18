import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;

public class RacingGameTest {
    @DisplayName("RacingGame의 getWinners 메서드 테스트")
    @Test
    void RacingGameGetWinnersTest() {
        // given
        List<String> carNames = Arrays.asList("소나타", "마티즈", "싼타페");

        int tryCount = 3;
        RacingGame racingGame = new RacingGame(carNames, tryCount);

        // when
        List<String> winners = racingGame.getWinners();

        // then
        assertThat(winners).isNotNull();
    }
}
