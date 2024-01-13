package main.java.racingcar.controller;

import main.java.racingcar.domain.RacingGame;
import main.java.racingcar.view.InputView;
import main.java.racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.race();

        OutputView.printCurrentStatus(racingGame.generateStatus());
        OutputView.printWinners(racingGame.getWinners());
    }
}
