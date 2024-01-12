package racingcar.view;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
    }
    public void inputRepeatCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }
    public void printRaceState(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
    public void printRaceResult(List<CarDto> winners) {
        StringBuilder result = new StringBuilder();
        for (CarDto winner : winners) {
            result.append(winner.getCarName()).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("가 최종우승했습니다.");
        System.out.println(result);
    }
}

