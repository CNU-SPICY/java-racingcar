package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {
    private Cars cars;
    private final String[] carNames = {"pobi", "crong", "honux"};

    @BeforeEach
    public void setup() {
        cars = new Cars(carNames);
    }

    @Test
    void testInitCars() {
        Assertions.assertEquals(carNames.length, cars.getCars().length);

        for (int i = 0; i < carNames.length; i++) {
            Assertions.assertEquals(carNames[i], cars.getCars()[i].getCarName());
        }
    }
}
