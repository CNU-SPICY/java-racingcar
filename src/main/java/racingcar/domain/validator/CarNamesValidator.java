package racingcar.domain.validator;

import java.util.List;

public class CarNamesValidator {

    private static final String EMPTY_INPUT_ERROR = "하나의 자동차라도 입력해주세요.";
    private static final String DUPLICATE_NAME_ERROR = "중복된 이름을 사용하면 안됩니다.";

    public static void validate(List<String> names) {
        if (isBlank(names)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
        if (isDuplicate(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private static boolean isDuplicate(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private static boolean isBlank(List<String> names) {
        return names.isEmpty() || names.stream().anyMatch(String::isBlank);
    }
}
