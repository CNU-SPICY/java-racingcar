package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class SpringTest {
    @Test
    void test() {
        //given
        String str = "1,2";
        //when
        String[] result = str.split(",");
        //then
        Assertions.assertThat(result)
                .contains("1","2");
        Assertions.assertThat(result)
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
        Assertions.assertThat(pobi.compareTo(crong)).isEqualTo(-1);
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
        Assertions.assertThat(pobi.compareTo(crong)).isEqualTo(1);
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
        Assertions.assertThat(pobi.compareTo(crong)).isEqualTo(0);
    }
}
