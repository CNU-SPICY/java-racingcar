package racingcar.domain;

public class RandomGenerator {
    public static int generateRandomNumber(int randomNumberBound) {
        return (int) (Math.random() * randomNumberBound);
    }
}
