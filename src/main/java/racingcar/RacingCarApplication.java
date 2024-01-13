package racingcar;

import main.java.racingcar.controller.RacingGameController;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGameController racingController = new RacingGameController();
        racingController.run();
    }
}
