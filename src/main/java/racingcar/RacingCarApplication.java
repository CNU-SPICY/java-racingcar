package racingcar;

import racingcar.controller.Game;
import racingcar.domain.MovementCondition;
import racingcar.domain.RandomMovementCondition;

public class RacingCarApplication {
    public static void main(String[] args) {
        MovementCondition movementCondition = new RandomMovementCondition();
        Game game = new Game(movementCondition);
        game.start();
    }
}
