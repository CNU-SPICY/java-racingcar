package racingcar.domain;

public class Car {
    private final String carName;
    private final MovementCondition movementCondition;
    private int position = 0;

    public Car(String carName, MovementCondition movementCondition) {
        this.carName = carName;
        this.movementCondition = movementCondition;
    }

    public void move() {
        if (movementCondition.isMovable()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
