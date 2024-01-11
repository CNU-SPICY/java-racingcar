package racingcar.domain;

import java.util.Random;

public class RacingCar {

    private String name;
    private int position;
    private Random random;


    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        random = new Random();
    }
    public void carPositionUpdate() {
        if (random.nextInt(10) >= 4) {
            moveCarForword();
        }
    }

    private void moveCarForword() {
        this.position++;
    }

    public StringBuilder getCurrentBarStatus() {
        StringBuilder currentBarStatus = new StringBuilder();
        currentBarStatus.append("-".repeat(Math.max(0, position)));
        return currentBarStatus;
    }


    public String getName() {
        return name;
    }


}