package main.java.racingcar.view;

import java.util.List;

public class OutputView {
    public static void printCurrentStatus(List<String> carNames, List<Integer> distances) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println("-".repeat(distances.get(i)));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
