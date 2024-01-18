package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        final List<String> carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final Cars cars = new Cars(carNames);
        final RacingController controller = new RacingController(cars, tryCount);
        controller.run();

        OutputView.printResults(cars.getCars());
        OutputView.printWinners(controller.getWinners());
    }
}
