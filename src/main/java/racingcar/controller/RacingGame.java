package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        }
    }


    public List<String> getWinners() {
    }




}
