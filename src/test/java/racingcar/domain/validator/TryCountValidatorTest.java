package racingcar.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class TryCountValidatorTest {

    @Test
    @DisplayName("입력이 숫자가 아닐 때 테스트")
    void isNotNumber() {
        // given
        String inputCount = "string";

        // when
        Throwable thrown = catchThrowable(()->{
            TryCountValidator.validate(inputCount);
        });

        // then
        assertThat(thrown).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("양의 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("입력이 양의 정수가 아닐 때 테스트")
    void isNotPositiveInteger() {
        // given
        String inputCount = "0";

        // when
        Throwable thrown = catchThrowable(()->{
            TryCountValidator.validate(inputCount);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("입력이 정상일 때 테스트")
    void isPassed() {
        // given
        String inputCount = "5";

        // when
        Throwable thrown = catchThrowable(()->{
            TryCountValidator.validate(inputCount);
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }

}