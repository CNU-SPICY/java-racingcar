package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void increaseMoveCount() {
        //given
        Car pobi = new Car(0,"pobi");
        //when
        pobi.move();
        //then
        assertThat(Car.makeCarDto(pobi).getMoveCount()).isEqualTo(1);
    }
}