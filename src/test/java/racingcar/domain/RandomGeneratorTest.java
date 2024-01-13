package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @Test
    @DisplayName("generate() 범위 확인")
    void generateTest() {
        // given
        RandomGenerator randomGenerator = new RandomGenerator();

        // when
        int result = randomGenerator.generate();

        // then
        assertThat(result).isBetween(0, 9);
    }
}