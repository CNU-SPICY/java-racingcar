package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        final String carNames = InputView.getCarNames();
        final String tryCount = InputView.getTryCount();

        final RacingController controller = new RacingController(carNames, tryCount);
        controller.run();

        OutputView.printResults(Cars.getCars());
        OutputView.printWinners(controller.getWinners());

    }

}
