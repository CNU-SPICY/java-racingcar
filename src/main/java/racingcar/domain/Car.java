package racingcar.domain;

public class Car implements Comparable<Car>{
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int position = 1;

    public Car(final String name){
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }

    public boolean isSamePosition(Car o){
        return this.position == o.getPosition();
    }

    public void move(final int random) {
        if (random >= MOVEMENT_CONDITION) position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
