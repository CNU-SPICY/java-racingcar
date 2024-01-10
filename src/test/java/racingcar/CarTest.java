package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    private Car car;
    private final String carName = "car";

    @BeforeEach
    public void setup() {
        car = new Car(carName);
    }

    @Test
    void testInitCarName() {
        Assertions.assertEquals(carName, car.getCarName());
    }

    @Test
    void testInitPosition() {
        Assertions.assertEquals(0, car.getPosition());
    }
}
