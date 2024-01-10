package racingcar;

import java.util.Random;


public class Car implements Comparable<Car>{
    private final String carName;
    private int moveCount;

    public Car(String carName) {
        this.carName = carName;
        this.moveCount = 0;
    }

    public int randomNum() {
        Random random = new Random();
        return random.nextInt(9);
    }   // 자동차의 움직임 여부 판단을 위한 난수 생성

    public boolean checkAhead(int num) {
        return num >= 4;
    }   // 자동차의 움직임 여부 판단

    public void increaseCount() {
        int check = randomNum();
        if (checkAhead(check)) {
            moveCount++;
        }
    }

    public void increaseCount(int check) {
        if(checkAhead(check)) {
            moveCount++;
        }
    }
    @Override
    public String toString() {
        return carName + " : " + "-".repeat(moveCount);
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.moveCount, car.moveCount);
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
