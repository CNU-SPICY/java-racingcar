package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.racingcar.domain.Car;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    void testMove() {
        // given
        int initialDistance = car.getDistance();

        // when
        car.move();

        // then
        assertEquals(initialDistance + 1, car.getDistance());
    }

    @Test
    void testGenerateStatus() {
        // when
        String status = car.generateStatus();

        // then
        assertTrue(status.matches("TestCar : -+"));
    }
}

