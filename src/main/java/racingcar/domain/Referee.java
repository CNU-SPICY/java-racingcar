package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Referee {
    private final List<Car> cars;
    private final List<Car> winners;
    private final RandomGenerator generator = new RandomGenerator();
    public Referee(List<String> carNames) {
        winners = new ArrayList<>();
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(0, carName));
        }
    }   // 자동차 이름을 이용한 생성자
    public void move() {
        for (Car car : cars) {
            increaseMoveCount(isMovable(), car);
        }
    }   // 자동차 전진 판단
    public void increaseMoveCount(boolean movable, Car car) {
        if(movable) {
            car.increaseMoveCount();
        }
    }   // 자동차 전진
    public List<CarDto> findWinners() {
        if (carsIsEmpty()) return null;
        if (!winners.isEmpty()) winners.clear();
        Car winner = Collections.max(cars);
        winners.add(winner);
        for (Car car : cars) {
            compareAndAddWinners(winner, car);
        }
        return Car.makeCarDtos(winners);
    }   // 우승 자동차 반환
    public boolean carsIsEmpty() {
        return cars.isEmpty();
    }
    public List<CarDto> returnCars() {
        return Car.makeCarDtos(cars);
    }   // 전체 자동차 반환
    private boolean isMovable() {
        return generator.randomGenerate() >= 4;
    }
    private void compareAndAddWinners(Car winner, Car car) {
        if(winner!=car && winner.compareTo(car) <= 0) {
            winners.add(car);
        }
    }   // 자동차의 전진 거리 비교
}
