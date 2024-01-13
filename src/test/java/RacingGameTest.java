import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @DisplayName("RacingGame의 getWinners 메서드 테스트")
    @Test
    void RacingGameGetWinnersTest() {
        // given
        String[] carNames = {"소나타","마티즈","싼타페"};
        int tryCount = 3;
        RacingGame racingGame = new RacingGame(carNames, tryCount);

        // when
        List<String> winners = racingGame.getWinners();

        // then
        assertThat(winners).isNotNull();
    }
}
