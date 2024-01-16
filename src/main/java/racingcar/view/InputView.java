package racingcar.view;

import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();

        List<String> carNames = Arrays.asList(inputNames.split(","));
        CarNamesValidator.validate(carNames);
        return carNames;
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = scanner.nextLine();
        close();
        TryCountValidator.validate(tryCount);
        return Integer.parseInt(tryCount);
    }

    private static void close() {
        scanner.close();
    }
}
