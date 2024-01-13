package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        final String carNames = InputView.getCarNames();
        final String tryCount = InputView.getTryCount();

        final Cars cars = new Cars(carNames);
        final RacingController controller = new RacingController(cars, tryCount);
        controller.run();

        OutputView.printResults(cars.getCars());
        OutputView.printWinners(controller.getWinners());

    }

}
