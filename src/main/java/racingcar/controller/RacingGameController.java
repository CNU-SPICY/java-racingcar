package main.java.racingcar.controller;

import main.java.racingcar.domain.RacingGame;
import main.java.racingcar.view.InputView;
import main.java.racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    public void run() {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);

        for (int i = 0; i < tryCount; i++) {
            racingGame.race();
            List<String> carNamesList = racingGame.getNames();
            List<Integer> distancesList = racingGame.getDistances();
            OutputView.printCurrentStatus(carNamesList, distancesList);
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
