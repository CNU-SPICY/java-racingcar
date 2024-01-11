package racingcar.domain;

import racingcar.domain.generator.NumberGenerator;

public class RacingCar implements Comparable<RacingCar> {
    private final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void carPositionUpdate(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION) {
            this.position++;
        }
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

    public boolean isSamePositionCar(RacingCar otherRacingCar) {
        return this.position == otherRacingCar.position;
    }
    public String getName() {
        return this.name;
    }
}