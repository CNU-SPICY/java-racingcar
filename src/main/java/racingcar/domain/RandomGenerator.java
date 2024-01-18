package racingcar.domain;

import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_RANGE = 10;

    public int generate() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
