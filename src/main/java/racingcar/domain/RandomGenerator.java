package racingcar.domain;

import java.util.Random;

public class RandomGenerator {
    private final Random random;
    public RandomGenerator() {
        this.random = new Random();
    }
    public int randomGenerate() {
        return random.nextInt(10);
    }
}
