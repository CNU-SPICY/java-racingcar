package racingcar;

import racingcar.controller.Game;
import racingcar.domain.MovementCondition;
import racingcar.domain.RandomMovementCondition;

public class RacingCarApplication {
    public static void main(String[] args) {
        Game game = new Game();
        MovementCondition movementCondition = new RandomMovementCondition();
        game.start(movementCondition);
    }
}
