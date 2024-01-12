package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printResults(List<Car> cars) {
        cars.forEach(car -> {
            String statusOfCar = car.getName() +
                    " : " +
                    "-".repeat(car.getPosition());
            System.out.println(statusOfCar);
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
