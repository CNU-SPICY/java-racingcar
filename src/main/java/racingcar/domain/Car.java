package main.java.racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomValue = (int) (Math.random()*10);
        if (randomValue >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String generateStatus() {
        return name + " : " + "-".repeat(distance);
    }
}
