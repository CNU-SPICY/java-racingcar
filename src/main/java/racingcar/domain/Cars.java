package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach((car) -> car.move(new RandomGenerator().generate()));
    }

    public List<String> getWinners() {
        final Car carOfMaxPosition = getCarOfMaxPosition();
        return getNamesOfSamePosition(carOfMaxPosition);
    }

    private Car getCarOfMaxPosition() {
        return Collections.max(cars);
    }

    private List<String> getNamesOfSamePosition(Car carOfMaxPosition) {
        return cars.stream().filter(carOfMaxPosition::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
