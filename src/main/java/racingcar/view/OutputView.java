package racingcar.view;

import racingcar.domain.Cars;
import racingcar.view.constants.ConstantMessage;

public class OutputView {

    public OutputView() {
    }

    public void printInputCarNames() {
        System.out.println(ConstantMessage.INPUT_CAR_NAMES.getMessage());
    }

    public void printInputNumberOfTrials() {
        System.out.println(ConstantMessage.INPUT_NUMBER_OF_TRIALS.getMessage());
    }

    public void printResult() {
        System.out.println(ConstantMessage.RESULT.getMessage());
    }

    public void printCars(Cars cars) {
        for (int i = 0; i < cars.getCars().length; i++) {
            System.out.print(cars.getCars()[i].getCarName() + " : ");
            printPosition(cars.getCars()[i].getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
