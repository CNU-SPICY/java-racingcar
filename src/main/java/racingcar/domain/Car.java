package racingcar.model;

import static racingcar.model.MovementControl.isMoveable;

public class Car {
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int position = 1;

    Car(final String name){
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(final int random) {
        if (random >= MOVEMENT_CONDITION) position++;
    }
}
