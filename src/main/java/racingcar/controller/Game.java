package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MovementCondition;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementCondition movementCondition;

    private Game(MovementCondition movementCondition, InputView inputView, OutputView outputView) {
        this.movementCondition = movementCondition;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static Game createGame(MovementCondition movementCondition, InputView inputView, OutputView outputView) {
        return new Game(movementCondition, inputView, outputView);
    }

    public void start() {
        String[] carNames = getCarNamesFromUser();
        Integer numberOfTrials = getNumberOfTrialsFromUser();
        Cars cars = new Cars(carNames, movementCondition);
        runRaces(cars, numberOfTrials);
        declareWinners(cars);
    }


    private String[] getCarNamesFromUser() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private Integer getNumberOfTrialsFromUser() {
        outputView.printInputNumberOfTrials();
        return inputView.inputNumberOfTrials();
    }

    private void runRaces(Cars cars, Integer numberOfTrials) {
        outputView.printResult();
        for (int i = 0; i < numberOfTrials; i++) {
            cars.move();
            outputView.printCars(cars);
        }
    }

    private void declareWinners(Cars cars) {
        outputView.printWinner(cars.getWinners());
    }
}
