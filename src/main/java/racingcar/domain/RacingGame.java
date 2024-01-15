package main.java.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import main.java.racingcar.view.OutputView;

public class RacingGame {
    private List<Car> cars;
    private int tryCount;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        initializeCars(carNames);
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void initializeCars(String[] carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void race() {
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    cars.forEach(car -> car.move(randomNumberGenerator));
                    OutputView.printCurrentStatus(generateStatus()); // 각 회차별 상태 출력
                });
    }

    public List<String> generateStatus() {
        List<String> carsStatus = new ArrayList<>();
        for (Car car : cars) {
            carsStatus.add(car.generateStatus());
        }
        return carsStatus;
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
}
