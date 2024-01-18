package racingcar.domain;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();
    public int randomGenerate() {
        return random.nextInt(10);
    }
}
