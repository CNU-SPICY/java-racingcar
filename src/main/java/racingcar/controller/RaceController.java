package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.io.IOException;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run() {
        try {
            Cars cars = new Cars(inputView.getInputCarName());

            int repeatCount = inputView.repeatCount();
            repeatRace(cars, repeatCount);

            outputView.printRaceResult(cars.findWinners());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void repeatRace(Cars cars, int repeatCount) {
        while (repeatCount > 0) {
            cars.moveCars();
            outputView.printRaceState(cars.returnCars());
            repeatCount--;
        }
    }
}
