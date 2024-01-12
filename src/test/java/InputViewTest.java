import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.TryCountValidator;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @DisplayName("중복된 입력이 막아지는지 테스트")
    @Test
    void dupicatedInputTest() {
        // given
        String names = "소나타,소나타,마티즈";

        // when
        Throwable carNameException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNamesValidator.validate(names);
        });

        // then
        assertThat(carNameException.getMessage()).isEqualTo("중복된 이름을 사용하면 안됩니다.");
    }

    @DisplayName("빈 문자열 입력 제한이 되는 지 테스트")
    @Test
    void emptyInputTest() {
        // given
        String names = "";

        // when
        Throwable emptyNameException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNamesValidator.validate(names);
        });

        // then
        assertThat(emptyNameException.getMessage()).isEqualTo("하나의 자동차라도 입력해주세요.");
    }

    @DisplayName("올바르지 않은 형식의 tryCount를 넣었을 때의 테스트")
    @Test
    void notProperTryCountTest() {
        // given
        String tryCount = "hi";

        // when
        Throwable tryCountException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(tryCount);
        });

        // then
        assertThat(tryCountException.getMessage()).isEqualTo("올바른 형식의 정수를 입력해주세요.");
    }

    @DisplayName("tryCount가 공백이 경우 테스트")
    @Test
    void emptyTryCountTest() {
        // given
        String tryCount = "";

        // when
        Throwable tryCountException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(tryCount);
        });

        // then
        assertThat(tryCountException.getMessage()).isEqualTo("입력값이 공백이면 안됩니다.");
    }
}