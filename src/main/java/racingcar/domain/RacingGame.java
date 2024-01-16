package main.java.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import main.java.racingcar.domain.Car;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        initializeCars(carNames);
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public List<Car> getCars() {
        return cars;
    }

    private void initializeCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.move(randomNumberGenerator);
        }
    }

    public List<String> getNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
        return distances;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == tryCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getTryCount() {
        return tryCount;
    }
}