package racingcar;

import racingcar.controller.RaceController;
public class RacingCarApplication {
    public static void main(String[] args){
        RaceController raceController = new RaceController();
        raceController.run();
    }
}