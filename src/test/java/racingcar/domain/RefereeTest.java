package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RefereeTest {
    Referee referee;
    @BeforeEach
    public void init() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "rupy", "crong"));
        referee = new Referee(names);
    }
    @Test
    void increaseMoveCount() {
        //given
        CarDto carDto = referee.returnCars().get(0);
        Car car = new Car(carDto.getMoveCount(), carDto.getCarName());
        //when
        referee.increaseMoveCount(true, car);
        //then
        assertThat(Car.makeCarDto(car).getMoveCount()).isEqualTo(1);
    }
    @Test
    void findWinners() {
        //given
        List<CarDto> carDtos = referee.returnCars();
        CarDto pobi = carDtos.get(0);
        CarDto rupy = carDtos.get(1);
        CarDto crong = carDtos.get(2);
        //when
        referee.increaseMoveCount(true, new Car(pobi.getMoveCount(), pobi.getCarName()));
        referee.increaseMoveCount(true, new Car(pobi.getMoveCount(), pobi.getCarName()));
        referee.increaseMoveCount(true, new Car(rupy.getMoveCount(), rupy.getCarName()));
        //then
        List<CarDto> winners = referee.findWinners();
        assertThat(winners.get(0).getCarName()).isEqualTo(pobi.getCarName());
    }
}