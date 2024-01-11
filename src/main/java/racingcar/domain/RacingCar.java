package racingcar.domain;

import java.util.Random;

public class RacingCar implements Comparable<RacingCar> {
    private final int MOVE_CONDITION = 4;
    private final int MAX_RANDOM_VALUE = 10;

    private String name;
    private int position;
    private Random random;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        random = new Random();
    }

    public void carPositionUpdate() {
        if (random.nextInt(MAX_RANDOM_VALUE) >= MOVE_CONDITION) {
            moveCarForword();
        }
    }

    private void moveCarForword() {
        this.position++;
    }

    public StringBuilder getCurrentBarStatus() {
        StringBuilder currentBarStatus = new StringBuilder();
        currentBarStatus.append(name).append(" : ");
        currentBarStatus.append("-".repeat(Math.max(0, position)));
        return currentBarStatus;
    }

    @Override
    public int compareTo(RacingCar otherRacingCar) {
        return this.position - otherRacingCar.position;
    }

    public boolean isSampPositionCar(RacingCar otherRacingCar) {
        return this.position == otherRacingCar.position;
    }
    public String getName() {
        return this.name;
    }
}