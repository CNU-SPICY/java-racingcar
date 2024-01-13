package main.java.racingcar.view;

import java.util.List;

public class OutputView {
    public static void printCurrentStatus(List<String> carsStatus) {
        for (String status : carsStatus) {
            System.out.println(status);
        }
        System.out.println();
    }
}
