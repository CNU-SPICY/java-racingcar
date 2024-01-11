package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private final List<Car> cars;
    public Referee(ArrayList<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(0, carName, new RandomGenerator()));
        }
    }
    public void move() {
        for (Car car : cars) {
            increaseMoveCount(car.isMovable(), car);
        }
    }   // 자동차 전진 판단
    public void increaseMoveCount(boolean movable, Car car) {
        if(movable) {
            car.increaseMoveCount();
        }
    }
    public List<CarDto> findWinners() {
        List<Car> winners = new ArrayList<>();
        if (!carsIsEmpty()) {
           winners.add(cars.get(0));
        }
        Car winner = Collections.max(cars);

        winners = compareCarMoveCount(winners, winner);

        return Car.makeCarDtos(winners);
    }
    public List<Car> compareCarMoveCount(List<Car> winners, Car car) {
        Car cmp = winners.get(0);
        if(cmp.compareTo(car) < 0) {
            winners.clear();
            winners.add(car);
        } else if (cmp.compareTo(car) == 0 && !cmp.equals(car)) {
            winners.add(car);
        }
        return winners;
    }
    public boolean carsIsEmpty() {
        return cars.isEmpty();
    }
    public List<CarDto> returnCars() {
        return Car.makeCarDtos(cars);
    }
}
