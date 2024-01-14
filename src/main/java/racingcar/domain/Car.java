package racingcar.domain;

public class Car {
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
        if (random >= 4) {
            distance ++;
        }
    }
}