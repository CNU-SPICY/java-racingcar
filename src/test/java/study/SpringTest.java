package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Referee;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Collection;

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
    void compareCarTest1() {
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
    void compareCarTest2() {
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
    void compareCarTest3() {
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
    void increaseCountTest() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        //when
        pobi.setMoveCount(2);
        crong.increaseCount(5);
        honux.increaseCount(4);

        //then
        assertThat(pobi.getMoveCount()).isEqualTo(2);
        assertThat(crong.getMoveCount()).isEqualTo(1);
        assertThat(honux.getMoveCount()).isEqualTo(1);
    }

    @Test
    void initVictoryTest() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        pobi.setMoveCount(2);
        crong.setMoveCount(3);
        honux.setMoveCount(4);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(crong);
        cars.add(honux);

        Referee referee = new Referee(cars);
        //when
        referee.initVictoryCar();

        //then
        assertThat(referee.getVictoryCars().get(0)).isEqualTo(pobi);
    }

    @Test
    void fasterTest() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        pobi.setMoveCount(2);
        crong.setMoveCount(3);
        honux.setMoveCount(4);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(crong);
        cars.add(honux);

        Referee referee = new Referee(cars);
        //when
        referee.initVictoryCar();
        referee.faster(honux);
        //then
        assertThat(referee.getVictoryCars().get(0)).isEqualTo(honux);
    }
    @Test
    void decideTheGameTest() {
        //given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        pobi.setMoveCount(2);
        crong.setMoveCount(4);
        honux.setMoveCount(4);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(crong);
        cars.add(honux);

        Referee referee = new Referee(cars);
        //when
        referee.decideTheGame();
        //then
        assertThat(referee.getVictoryCars().size()).isEqualTo(2);
        assertThat(referee.getVictoryCars()).contains(crong, honux);
    }
}
