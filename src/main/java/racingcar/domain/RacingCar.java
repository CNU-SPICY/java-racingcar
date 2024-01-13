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

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION) {
            this.position++;
        }
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

    public int getPosition() {
        return position;
    }
}