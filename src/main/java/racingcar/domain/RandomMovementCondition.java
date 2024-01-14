package racingcar.domain;

public class RandomMovementCondition implements MovementCondition {
    private static final int MOVEMENT_CONDITION = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public boolean isMovable() {
        return RandomGenerator.generateRandomNumber(RANDOM_NUMBER_BOUND) >= MOVEMENT_CONDITION;
    }
}
