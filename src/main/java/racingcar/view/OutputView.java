package racingcar.view;

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
}
