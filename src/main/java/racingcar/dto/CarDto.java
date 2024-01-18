package racingcar.dto;
public class CarDto {
    private final int moveCount;
    private final String carName;
    public CarDto(int moveCount, String carName) {
        this.moveCount = moveCount;
        this.carName = carName;
    }
    public int getMoveCount() {
        return moveCount;
    }
    public String getCarName() {
        return carName;
    }
    @Override
    public String toString() {
        return carName + " : " + "-".repeat(moveCount);
    }
}
