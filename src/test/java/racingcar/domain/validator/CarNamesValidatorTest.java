package racingcar.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class CarNamesValidatorTest {

    @Test
    @DisplayName("자동차 이름이 공백일 때 테스트")
    void EmptyInputTest() {
        // given
        String inputNames = "";
        List<String> carNames = Arrays.asList(inputNames.split(","));

        // when
        Throwable thrown = catchThrowable(() -> {
            CarNamesValidator.validate(carNames);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최소 1글자입니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 때 테스트")
    void isDuplicatedTest() {
        // given
        String inputNames = "abc,123,abc";
        List<String> carNames = Arrays.asList(inputNames.split(","));

        // when
        Throwable thrown = catchThrowable(() -> {
            CarNamesValidator.validate(carNames);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름은 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 정상일 때 테스트")
    void isPassed() {
        // given
        String inputNames = "pobi,crong,honux";
        List<String> carNames = Arrays.asList(inputNames.split(","));

        // when
        Throwable thrown = catchThrowable(() -> {
            CarNamesValidator.validate(carNames);
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }
}