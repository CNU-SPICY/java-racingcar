package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.IOException;

public class RacingCarApplication {

    public static void main(final String... args) throws IOException {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.start();

        ResultView.printWinners(racingGame.getWinners());
    }

}


