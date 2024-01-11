package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarApplication {

    public static RacingCars racingCars;

    public static void main(final String... args) throws IOException {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.start();

        ResultView.printWinners(racingGame.getWinners());
    }


    // 승자 계산 메서드
    public static void pickWinner(RacingCars racingCars) {

        int maxStatus = racingCars.getCars().stream()
                .mapToInt(RacingCar::getStatus)
                .max()
                .orElse(-1);

        List<String> winners = racingCars.getCars().stream()
                .filter(car -> car.getStatus() == maxStatus)
                .map(RacingCar::getName).collect(Collectors.toList());

        printWinner(winners);
    }

    // 승자 출력 메서드
    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    // 게임 진행 메서드
    public static void gameStart(int tries) {
        for (int i=0; i<tries; i++) {
            racingOneGame();
            racingCars.showCarStatus();
        }
        racingCars.showCarStatus();
        pickWinner(racingCars);
    }

}


