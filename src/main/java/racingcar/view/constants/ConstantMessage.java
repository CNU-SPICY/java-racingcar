package racingcar.view.constants;

public enum ConstantMessage {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)."),
    INPUT_NUMBER_OF_TRIALS("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("가 최종 우승했습니다.");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
