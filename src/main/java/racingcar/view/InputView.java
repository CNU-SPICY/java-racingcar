package racingcar.view;

import racingcar.validator.InputValidator;
import java.util.Scanner;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    private static Scanner scanner;

    private String nextLine() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String carNames = nextLine();
        inputValidator.validateCarNames(carNames);
        return carNames.split(",");
    }

    public Integer inputNumberOfTrials() {
        String numberOfTrials = nextLine();
        inputValidator.validateNumberOfTrials(numberOfTrials);
        return Integer.parseInt(numberOfTrials);
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
