package racingcar.validator;

import java.util.Arrays;

public class InputValidator {
    public void validateCarNames(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            validateCarName(carName);
        }
        if (carNamesArray.length != getDistinctCarNames(carNamesArray).length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private String[] getDistinctCarNames(String[] carNamesArray) {
        return Arrays.stream(carNamesArray)
            .distinct()
            .toArray(String[]::new);
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상만 가능합니다.");
        }

        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백만으로는 구성할 수 없습니다.");
        }
    }

    public void validateNumberOfTrials(String numberOfTrials) {
        if (!isNumeric(numberOfTrials)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }

        if (Integer.parseInt(numberOfTrials) < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
        }
    }

    private boolean isNumeric(String numberOfTrials) {
        return numberOfTrials.matches("[0-9]+");
    }
}
