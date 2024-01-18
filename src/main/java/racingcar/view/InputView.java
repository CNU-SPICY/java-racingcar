package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.TryCountValidator;

public class InputView {

    private static final String CAR_NAME_INPUT_FORMAT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_FORMAT = "시도할 회수는 몇회인가요?";

    public static List<String> getCarNames() throws IOException {
        System.out.println(CAR_NAME_INPUT_FORMAT);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        List<String> carNames = List.of(buffer.readLine().split(","));
        CarNamesValidator.validate(carNames);

        return carNames;
    }

    public static int getTryCount() throws IOException {
        System.out.println(TRY_COUNT_FORMAT);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String tryCount = buffer.readLine();
        TryCountValidator.validate(tryCount);

        return Integer.parseInt(tryCount);
    }
}
