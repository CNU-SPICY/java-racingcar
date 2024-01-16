package racingcar.domain.validator;

public class TryCountValidator {

    public static void validate(String inputCount){
        int tryCount;

        try {
            tryCount = Integer.parseInt(inputCount);
        } catch (NumberFormatException e){
            throw new NumberFormatException("양의 정수를 입력해주세요.");
        }

        if(tryCount <= 0){
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
    }
}
