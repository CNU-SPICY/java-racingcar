package main.java.racingcar.domain;

public class Car {
    private static final int MOVE_NUMBER = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        int randomValue = randomNumberGenerator.generateRandomNumber(10);
        if (randomValue >= MOVE_NUMBER) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
