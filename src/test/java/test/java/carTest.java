package test.java;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.*;

class CarTest {
    private Car car;
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
        randomNumberGenerator = mock(RandomNumberGenerator.class);
    }

    @Test
    void testMove() {
        // given
        int initialDistance = car.getDistance();
        when(randomNumberGenerator.generateRandomNumber(10)).thenReturn(5); // 예시로 5를 주입

        // when
        car.move(randomNumberGenerator);

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

