package racingcar.domain;

import racingcar.dto.CarDto;
import java.util.ArrayList;
import java.util.List;
public class Car implements Comparable<Car> {
    private int moveCount;
    private final String carName;
    public Car(int moveCount, String carName) {
        this.moveCount = moveCount;
        this.carName = carName;
    }
    public void increaseMoveCount() {
        moveCount++;
    }
    public static List<CarDto> makeCarDtos(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(new CarDto(car.moveCount, car.carName));
        }
        return carDtos;
    }
    public static CarDto makeCarDto(Car car) {
        return new CarDto(car.moveCount, car.carName);
    }
    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.moveCount, car.moveCount);
    }
}
