package main.java.racingcar.view;

import java.util.List;

public class OutputView {
    public static void printCurrentStatus(List<String> carsStatus) {
        for (String status : carsStatus) {
            System.out.println(status);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
