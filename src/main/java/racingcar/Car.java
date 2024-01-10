package racingcar;

public class Car {
    String name;
    int distance;

    Car(String name) {
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
}
