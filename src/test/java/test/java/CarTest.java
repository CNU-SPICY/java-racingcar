package test.java;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void move_WhenNumberIsGreaterThanOrEqual() {
        // given
        RandomNumberGenerator mockRandomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(mockRandomNumberGenerator.generateRandomNumber(10)).thenReturn(5); // arbitrary value

        Car car = new Car("Car1");

        // when
        car.move(mockRandomNumberGenerator);

        // then
        assertEquals(1, car.getDistance());
    }

    @Test
    void move_TryCountIsLessThan() {
        // given
        RandomNumberGenerator mockRandomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(mockRandomNumberGenerator.generateRandomNumber(10)).thenReturn(3); // arbitrary value

        Car car = new Car("Car2");

        // when
        car.move(mockRandomNumberGenerator);

        // then
        assertEquals(0, car.getDistance());
    }
}
