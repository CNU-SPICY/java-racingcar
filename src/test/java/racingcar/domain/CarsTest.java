package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarsTest {

    Cars cars;
    @BeforeEach
    public void init() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "rupy", "crong"));
        cars = new Cars(names);
    }

    @Test
    void increaseMoveCount() {
        //given
        CarDto carDto = cars.returnCars().get(0);
        Car car = new Car(carDto.getMoveCount(), carDto.getCarName());
        //when
        cars.increaseMoveCount(true, car);
        //then
        assertThat(Car.makeCarDto(car).getMoveCount()).isEqualTo(1);
    }

    @Test
    void findWinners() {
        //given
        List<CarDto> carDtos = cars.returnCars();
        CarDto pobi = carDtos.get(0);
        CarDto rupy = carDtos.get(1);
        CarDto crong = carDtos.get(2);
        //when
        cars.increaseMoveCount(true, new Car(pobi.getMoveCount(), pobi.getCarName()));
        cars.increaseMoveCount(true, new Car(pobi.getMoveCount(), pobi.getCarName()));
        cars.increaseMoveCount(true, new Car(rupy.getMoveCount(), rupy.getCarName()));
        //then
        List<CarDto> winners = cars.findWinners();
        assertThat(winners.get(0).getCarName()).isEqualTo(pobi.getCarName());
    }
}