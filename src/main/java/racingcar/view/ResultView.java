package racingcar.view;

import racingcar.domain.RacingCars;

import java.util.List;

public class ResultView {

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void showCarsPosition(RacingCars racingCars) {
        StringBuilder racingCarsInfo = racingCars.getAllCurrentBarStatus();
        System.out.println(racingCarsInfo);
    }
}
