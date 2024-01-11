package racingcar.controller;

import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.io.IOException;

public class RaceController {
    private static InputView inputView;
    private static OutputView outputView;
    public RaceController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run() {
        try {
            outputView.inputCarName();
            Referee referee = new Referee(inputView.getInputCarName());

            outputView.inputRepeatCount();
            int repeatCount = inputView.repeatCount();

            repeatRace(referee, repeatCount);

            outputView.printRaceResult(referee.findWinners());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void repeatRace(Referee referee, int repeatCount) {
        while (repeatCount > 0) {
            referee.move();
            outputView.printRaceState(referee.returnCars());
            repeatCount--;
        }
    }
}
