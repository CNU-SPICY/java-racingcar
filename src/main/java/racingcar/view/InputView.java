package main.java.racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();
        String[] carNames = inputNames.split(",");

        while (!isValidCarNames(carNames)) {
            System.out.println("각 자동차 이름은 5자 이하로 입력해주세요.");
            inputNames = scanner.nextLine();
            carNames = inputNames.split(",");
        }
        return carNames;
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = scanner.nextLine();
        return Integer.parseInt(tryCount);
    }

    private static boolean isValidCarNames(String[] carNames) {
        return Arrays.stream(carNames).allMatch(name -> name.trim().length() <= 5);
    }
}
