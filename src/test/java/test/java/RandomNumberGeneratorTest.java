package test.java;

import main.java.racingcar.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {

    @Test
    void generateRandomNumber_ShouldGenerateNumberInRange() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int result = randomNumberGenerator.generateRandomNumber(10);

        // then
        assertTrue(result >= 0 && result < 10);
    }
}

