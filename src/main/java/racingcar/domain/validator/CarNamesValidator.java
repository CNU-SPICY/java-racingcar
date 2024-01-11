package racingcar.domain.validator;

import java.util.Arrays;

public class CarNamesValidator {

    private static final String EMPTY_INPUT_ERROR = "하나의 자동차라도 입력해주세요.";
    private static final String DUPLICATE_NAME_ERROR = "중복된 이름을 사용하면 안됩니다.";

    public static void validate(String names) {
        if(isBlank(names)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        if(isDuplicate(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private static boolean isDuplicate(String names) {
        String[] cars = names.split(",");
        return Arrays.stream(cars).distinct().count() != cars.length;
    }

    private static boolean isBlank(String names) {
        return names.isBlank();
    }
}
