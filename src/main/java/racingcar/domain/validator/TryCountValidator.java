package racingcar.domain.validator;

public class TryCountValidator {
    private static final String IS_NOT_NUMBER_ERROR = "올바른 형식의 정수를 입력해주세요.";
    private static final String EMPTY_INPUT_ERROR = "입력값이 공백이면 안됩니다.";

    public static void validate(String tryCount) {
        if(isBlank(tryCount)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        if (!isInteger(tryCount)) {
            throw new NumberFormatException(IS_NOT_NUMBER_ERROR);
        }
    }
    public static boolean isInteger(String tryCount) {
        try {
            Integer.parseInt(tryCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isBlank(String tryCount) {
        return tryCount.isBlank();
    }
}
