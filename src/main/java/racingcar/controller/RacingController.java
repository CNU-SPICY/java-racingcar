package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingController {

    private final Cars cars;
    private final int tryCount;

    public RacingController(final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void run() {
        IntStream.range(0, tryCount).forEach((round)->{
            OutputView.printResults(cars.getCars());
            cars.play();
        });
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
