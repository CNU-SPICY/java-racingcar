package racingcar.view;

import racingcar.domain.validator.CarNamesValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {


    public static String getCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String carNames = buffer.readLine();
        CarNamesValidator.validate(carNames);

        return carNames;
    }

    public static int getTryCount() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(buffer.readLine());
    }
}
