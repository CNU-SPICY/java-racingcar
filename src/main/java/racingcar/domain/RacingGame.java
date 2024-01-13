package main.java.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import main.java.racingcar.view.OutputView;

public class RacingGame {
    private List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        initializeCars(carNames);
    }

    private void initializeCars(String[] carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
