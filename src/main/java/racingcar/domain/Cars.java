package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static List<Car> cars;

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static void setNames(final String carNames) {
        cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<String> getWinners(){
        final Car carOfMaxPosition = getCarOfMaxPosition();
        return getNamesOfSamePosition(carOfMaxPosition);
    }

    private static Car getCarOfMaxPosition() {
        return Collections.max(cars);
    }

    private static List<String> getNamesOfSamePosition(Car carOfMaxPosition){
        return cars.stream().filter(carOfMaxPosition::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public static void play() {
        cars.forEach(Car::play);
    }
}
