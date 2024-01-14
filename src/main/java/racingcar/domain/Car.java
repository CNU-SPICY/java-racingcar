package racingcar.domain;

public class Car {
    private final String carName;
    private int distance = 0;
    private RandomGenerator random = new RandomGenerator();

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (random.randomGenerate() >= 4) {
            distance ++;
        }
    }
}