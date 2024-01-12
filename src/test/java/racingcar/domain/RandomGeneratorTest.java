package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "4:4", "6:6", "9:9"}, delimiter = ':')
    @DisplayName("generate 상수 테스트")
    void generateTest(int arg, int expected) {
        // given
        RandomGenerator randomGenerator = new RandomGenerator(() -> arg);

        // when
        int result = randomGenerator.generate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("generate 난수 테스트")
    void generateRandomTest() {
        final int BOUND = 10;

        // given
        RandomGenerator randomGenerator = new RandomGenerator(()->{
           Random random = new Random();
           return random.nextInt(BOUND);
        });

        // when
        int result = randomGenerator.generate();

        // then
        assertThat(result).isBetween(0, BOUND);
    }

}