package racingcar;

import java.util.Random;

public class Car {
    private String car_name;
    private int distance = 0;
    private Random random = new Random();
    public Car(String car_name) {
        this.car_name = car_name;

    }
    public String getCar_name() {
        return car_name;
    }
    public int getDistance() {
        return distance;
    }
    public void move() {
        if (random.nextInt(10) >= 4) {
            distance ++;
        }
    }
    public void print() {
        System.out.println(car_name + " : " + "-".repeat(distance));
    }
}