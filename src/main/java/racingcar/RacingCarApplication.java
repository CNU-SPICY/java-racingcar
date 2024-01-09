package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingCarApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Car> cars = new ArrayList<>();
        while (st.hasMoreElements()) {
            cars.add(new Car(st.nextToken()));
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        int repeatCount = Integer.parseInt(br.readLine());

        while (repeatCount > 0) {
            for (Car car : cars) {
                car.increaseCount();
                System.out.println(car);
            }
            System.out.println();
            repeatCount--;
        }

        Referee referee = new Referee(cars);
        referee.decideTheGame();
        referee.printResult();
    }
}