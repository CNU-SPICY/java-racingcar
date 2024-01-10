package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.assertj.core.api.Assertions.*;


class CarTest {
    private Car car1 = new Car("pobi");

    @Test
    @DisplayName("자동차 객체 - 이름 반환")
    void getCar_name() {
        assertThat(car1.getCar_name()).isEqualTo("pobi");

        Car car2 = new Car("");
        assertThat(car2.getCar_name()).isEqualTo("");
    }

    @Test
    @DisplayName("자동차 객체 - 이동거리 반환")
    void getDistance() {
        assertThat(car1.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 객체 - 이동 메서드")
    void move() {
        car1.move();
        assertThat(car1.getDistance() == 0 || car1.getDistance() == 1).isTrue();
    }
}