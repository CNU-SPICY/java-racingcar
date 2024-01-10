package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RacingCarApplicationTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        cars = List.of(car1, car2, car3);
    }

    @Test
    void isValidCarNames_validNames_returnTrue() {
        String[] validNames = {"car1", "car2", "car3"};
        assertTrue(RacingCarApplication.isValidCarNames(validNames));
    }

    @Test
    void isValidCarNames_invalidNames_returnFalse() {
        String[] invalidNames = {"car1", "car2", "car345678"};
        assertFalse(RacingCarApplication.isValidCarNames(invalidNames));
    }

    @Test
    void moveCars_checkDistanceAfterMoving_returnTrue() {
        RacingCarApplication.moveCars(cars);
        assertTrue(cars.stream().allMatch(car -> car.getDistance() >= 0 && car.getDistance() <= 9));
    }

    @Test
    void getWinners_oneWinner_returnWinnerList() {
        cars.get(0).move();  // Move the first car to make it a winner
        List<String> winners = RacingCarApplication.getWinners(cars, 1);
        assertEquals(List.of("car1"), winners);
    }

    @Test
    void getWinners_noWinner_returnEmptyList() {
        List<String> winners = RacingCarApplication.getWinners(cars, 1);
        assertTrue(winners.isEmpty());
    }

    @Test
    void printWinners_multipleWinners_printWinnersMessage() {
        cars.forEach(Car::move);  // Move all cars to make them winners
        List<String> winners = RacingCarApplication.getWinners(cars, 1);
        assertDoesNotThrow(() -> RacingCarApplication.printWinners(winners));
    }
}

