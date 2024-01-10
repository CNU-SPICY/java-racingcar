package racingcar.domain;

public class Cars {
    private final Car[] cars;
    public Cars(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
