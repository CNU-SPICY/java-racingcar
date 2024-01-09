package racingcar;

public class Car {
    String carName;
    int moveCount;

    public Car(String carName) {
        this.carName = carName;
        this.moveCount = 0;
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(moveCount) + "\n";
    }
}
