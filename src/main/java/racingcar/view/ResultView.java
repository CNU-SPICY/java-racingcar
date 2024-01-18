package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;

public class ResultView {

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void showCarsPosition(List<RacingCar> racingCars) {
        StringBuilder racingCarsInfo = new StringBuilder();
        racingCars.forEach(racingCar -> {
            racingCarsInfo.append(racingCar.getName()).append(" : ");
            racingCarsInfo.append("-".repeat(Math.max(0, racingCar.getPosition()))).append("\n");
        });
        System.out.println(racingCarsInfo);
    }
}
