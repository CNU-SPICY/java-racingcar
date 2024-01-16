package racingcar.domain.validator;

import java.util.List;
import java.util.stream.Collectors;

public class CarNamesValidator {

    public static void validate(final List<String> carNames){
        if(isDuplicated(carNames)){
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }

        if(isBlank(carNames)){
            throw new IllegalArgumentException("이름은 최소 1글자입니다.");
        }
    }

    public static boolean isDuplicated(final List<String> carNames){
        return carNames.stream().distinct().count() != carNames.size();
    }

    public static boolean isBlank(final List<String> carNames){
        final List<String> blanks = carNames.stream().filter(String::isBlank).collect(Collectors.toUnmodifiableList());
        return !blanks.isEmpty();
    }
}
