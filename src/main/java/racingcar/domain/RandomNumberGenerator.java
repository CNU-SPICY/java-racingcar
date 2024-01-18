package main.java.racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
