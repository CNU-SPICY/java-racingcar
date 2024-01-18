package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ForceMovementCondition;
import racingcar.domain.MovementCondition;

public class CarTest {
    private Car car;
    private final String carName = "car";

    @BeforeEach
    public void setup() {
        MovementCondition movementCondition = new ForceMovementCondition();
        car = new Car(carName, movementCondition);
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
