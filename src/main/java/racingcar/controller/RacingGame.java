package racingcar.controller;
import racingcar.domain.RacingCars;
import racingcar.view.ResultView;
import java.util.List;

public class RacingGame {

    private int tries;
    private final RacingCars racingCars;

    public RacingGame(String carNames, int tryCount) {
        racingCars = new RacingCars(carNames);
        this.tries = tryCount;
    }

    public void start() {
        for(int i=0; i<tries; i++) {
            racingCars.racingOneGame();
            ResultView.showCarsPosition(racingCars);
        }
        ResultView.showCarsPosition(racingCars);
    }

    public List<String> getWinners() {
        return racingCars.pickWinner(racingCars);
    }
}
