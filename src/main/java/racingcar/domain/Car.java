package racingcar.domain;

import racingcar.dto.CarDto;
import java.util.ArrayList;
import java.util.List;


public class Car implements Comparable<Car> {
    private int moveCount;
    private final String carName;
    private final RandomGenerator generator;
    public Car(int moveCount, String carName, RandomGenerator generator) {
        this.moveCount = moveCount;
        this.carName = carName;
        this.generator = generator;
    }
    public boolean isMovable() {
        return generator.randomGenerate() >= 4;
    }
    public void increaseMoveCount() {
        moveCount++;
    }
    public static List<CarDto> makeCarDtos(List<Car> cars) {
        ArrayList<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(new CarDto(car.moveCount, car.carName));
        }
        return carDtos;
    }
    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.moveCount, car.moveCount);
    }
}
