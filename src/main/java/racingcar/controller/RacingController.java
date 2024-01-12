package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingController {

    private final int tryCount;

    public RacingController(final String carNames, final String tryCount) {
        setNames(carNames);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public void run() {
        IntStream.range(0, tryCount).forEach((round)->{
            OutputView.printResults(Cars.getCars());
            Cars.play();
        });
    }

    public void setNames(final String carNames){
        Cars.setNames(carNames);
    }

    public List<String> getWinners() {
        return Cars.getWinners();
    }
}
