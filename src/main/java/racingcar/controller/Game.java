package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printInputCarNames();
        String[] carNames = inputView.inputCarNames();
        outputView.printInputNumberOfTrials();
        Integer numberOfTrials = inputView.inputNumberOfTrials();

        Cars cars = new Cars(carNames);

        outputView.printResult();
        for (int i = 0; i < numberOfTrials; i++) {
            cars.move();
            outputView.printCars(cars);
        }

        outputView.printWinner(cars.getWinners());
    }
}
