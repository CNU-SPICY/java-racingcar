package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private static final int NAME_LEN = 5;
    private StringTokenizer stringTokenizer;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> getInputCarName() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        List<String> carNames = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(),",");
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken().strip();
            addCarNames(carName, carNames);
        }
        return carNames;
    }

    public int repeatCount() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(bufferedReader.readLine());
    }

    private void addCarNames(String carName, List<String> carNames) throws IOException {
        if(checkNameLen(carName)) {
            carNames.add(carName);
            return;
        }
        carNames.clear();
        System.out.println("자동차 이름은 5자 이하로 입력 해주세요.");
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
    }

    private  boolean checkNameLen(String carName) {
        return carName.length() <= NAME_LEN;
    }
}
