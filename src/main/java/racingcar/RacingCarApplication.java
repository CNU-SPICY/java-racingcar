package racingcar;

import racingcar.controller.Game;
import racingcar.domain.MovementCondition;
import racingcar.domain.RandomMovementCondition;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        MovementCondition movementCondition = new RandomMovementCondition();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Game game = Game.createGame(movementCondition, inputView, outputView);
        game.start();
    }
}
