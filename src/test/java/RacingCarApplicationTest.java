import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.RacingCarApplication;
import racingcar.domain.RacingCars;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class RacingCarApplicationTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }


    @DisplayName("자동차 리스트 초기화 테스트")
    @Test
    void initCarStatusTest() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1", 0));
        RacingCars racingCars = new RacingCars(cars);

        assertEquals(racingCars.getCarSize(), 1);
    }


    @DisplayName("자동차의 상태가 잘 증가하는 지 테스트")
    @Test
    void racingCarIncreaseTest() {
        RacingCar car2 = new RacingCar("car2", 3);
        car2.increaseStatus();
        car2.increaseCurrentCarBar();

        assertEquals(car2.getStatus(), 4);
        assertEquals(car2.getBar(), "-");

    }


    @DisplayName("자동차 상태 출력 메서드")
    @Test
    void showCarStatusTest() {
        RacingCar car1 = new RacingCar("car1", 3);
        RacingCar car2 = new RacingCar("car2", 4);
        RacingCar car3 = new RacingCar("car3", 5);

        car1.increaseCurrentCarBar();
        car2.increaseCurrentCarBar();
        car3.increaseCurrentCarBar();

        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCars racingCars = new RacingCars(cars);
        racingCars.showCarStatus();

        assertEquals("car1 : -\ncar2 : -\ncar3 : -\n\n", outputMessage.toString());

    }

    @DisplayName("승자 계산 메서드")
    @Test
    void pickWinnerTest() {
        RacingCar car1 = new RacingCar("car1", 3);
        RacingCar car2 = new RacingCar("car2", 4);
        RacingCar car3 = new RacingCar("car3", 5);

        car1.increaseStatus();
        car1.increaseStatus();
        car1.increaseStatus();

        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCars racingCars = new RacingCars(cars);

        RacingCarApplication.pickWinner(racingCars);

        assertEquals("car1가 최종 우승했습니다.\n", outputMessage.toString());
    }

    @DisplayName("승자 출력 메서드")
    @Test
    void printWinnerTest() {
        List<String> winners = new ArrayList<>();
        String winner = "winner";
        winners.add(winner);
        RacingCarApplication.printWinner(winners);
        assertEquals("winner가 최종 우승했습니다.\n", outputMessage.toString());
    }


}
