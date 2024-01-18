package racingcar.domain;

public class Car {
    public static final int MOVABLE_NUMBER = 4;
    private final String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int random) {
        if (random >= MOVABLE_NUMBER) {
            distance ++;
        }
    }
}