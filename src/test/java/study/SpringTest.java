package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class SpringTest {
    @Test
    void test() {
        //given
        String str = "1,2";
        //when
        String[] result = str.split(",");
        //then
        assertThat(result)
                .contains("1","2");
        assertThat(result)
                .containsExactly("1","2");
    }

    @Test
    void compareCar1() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        //when
        pobi.setMoveCount(3);
        crong.setMoveCount(4);
        //then
        assertThat(pobi.compareTo(crong)).isEqualTo(-1);
    }

    @Test
    void compareCar2() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        //when
        pobi.setMoveCount(5);
        crong.setMoveCount(4);
        //then
        assertThat(pobi.compareTo(crong)).isEqualTo(1);
    }

    @Test
    void compareCar3() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        //when
        pobi.setMoveCount(4);
        crong.setMoveCount(4);
        //then
        assertThat(pobi.compareTo(crong)).isEqualTo(0);
    }
    @Test
    void increaseCount() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        //when
        pobi.setMoveCount(2);
        crong.increaseCount(5);
        honux.increaseCount(4);

        //then
        assertThat(pobi.getMoveCount()).isEqualTo(0);
        assertThat(crong.getMoveCount()).isEqualTo(1);
        assertThat(honux.getMoveCount()).isEqualTo(1);
    }
    @Test
    void decideTheGame() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        pobi.setMoveCount(2);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(crong);
        cars.add(honux);

        //when

    }
}
