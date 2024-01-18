import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.TryCountValidator;

public class InputViewTest {

    @DisplayName("중복된 입력이 막아지는지 테스트")
    @Test
    void duplicatedInputTest() {
        // given
        List<String> names = Arrays.asList("소나타", "소나타", "마티즈");

        // when, then
        assertThatThrownBy(() -> CarNamesValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 사용하면 안됩니다.");
    }

    @DisplayName("빈 문자열 입력 제한이 되는 지 테스트")
    @Test
    void emptyInputTest() {
        // given
        List<String> names = Arrays.asList("");

        // when, then
        assertThatThrownBy(() -> CarNamesValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 자동차라도 입력해주세요.");
    }

    @DisplayName("공백이 여러 개인 경우 테스트")
    @Test
    void multipleEmptyInputTest() {
        // given
        List<String> names = Arrays.asList(" ");

        // when, then
        assertThatThrownBy(() -> CarNamesValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 자동차라도 입력해주세요.");
    }

    @DisplayName("올바르지 않은 형식의 tryCount를 넣었을 때의 테스트")
    @Test
    void notProperTryCountTest() {
        // given
        String tryCount = "hi";

        // when, then
        assertThatThrownBy(() -> TryCountValidator.validate(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 형식의 정수를 입력해주세요.");
    }

    @DisplayName("올바른 형식의 tryCount를 넣었을 때의 테스트")
    @Test
    void properTryCountTest() {
        // given
        String tryCount = "5";

        // when, then
        assertDoesNotThrow(() -> TryCountValidator.validate(tryCount));
    }

    @DisplayName("tryCount가 공백인 경우 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyTryCountTest(String input) {
        // given
        // 주어지는 인수 input

        // when, then
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("입력값이 공백이면 안됩니다.");
    }
}