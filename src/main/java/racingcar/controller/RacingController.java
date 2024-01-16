package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.RacingGame;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void race() {
        final String[] carNames = inputView.getCarNames();
        final int tryCount = inputView.getTryCount();
        RacingGame racingGame = new RacingGame(carNames);
        for(int i = 0; i < tryCount; i++) {
            racingGame.moveCars(-1);
            outputView.printRacing(racingGame.getCars());
        }
        outputView.printWinner(racingGame.findWinners());
    }
}
