package racingcar.view;

import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.TryCountValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String CAR_NAME_INPUT_FORMAT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_FORMAT = "시도할 회수는 몇회인가요?";

    public static String getCarNames() throws IOException {
        System.out.println(CAR_NAME_INPUT_FORMAT);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String carNames = buffer.readLine();
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
