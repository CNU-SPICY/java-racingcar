package racingcar.view;

import racingcar.validator.InputValidator;
import java.util.Scanner;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    private final Scanner scanner = new Scanner(System.in);

    private String getInput() {
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String carNames = getInput();
        inputValidator.validateCarNames(carNames);
        return carNames.split(",");
    }

    public Integer inputNumberOfTrials() {
        String numberOfTrials = getInput();
        inputValidator.validateNumberOfTrials(numberOfTrials);
        return Integer.parseInt(numberOfTrials);
    }
}
