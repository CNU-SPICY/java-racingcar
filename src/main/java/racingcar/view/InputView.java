package racingcar.view;

import racingcar.domain.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputView {
    private final static int NAME_LEN = 5;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public ArrayList<String> getInputCarName() throws IOException {
        ArrayList<String> carNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(),",");
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken().strip();
            addCarNames(carName, carNames);
        }
        return carNames;
    }
    public int repeatCount() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    private void addCarNames(String carName, ArrayList<String> carNames) {
        if(checkNameLen(carName)) {
            carNames.add(carName);
        }
    }
    private  boolean checkNameLen(String carName) {
        return carName.length() <= NAME_LEN;
    }
}
