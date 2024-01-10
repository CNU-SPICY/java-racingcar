package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingCarApplication {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final ArrayList<Car> cars = new ArrayList<>();

    private static int repeatCount;
    public static void main(String[] args){

        try {
            carName();
            repeatCount();
        } catch (IOException e) {
            System.out.println("입력된 값이 없습니다");
            e.getStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("반복횟수는 int 타입 입니다.");
        } catch (Exception e) {
            System.out.println("경주할 자동차 이름의 구분은 (,)를 기준으로 구분 해야합니다.");
        }

        while (repeatCount > 0) {
            repeatIncrease();
            repeatCount--;
        }

        Referee referee = new Referee(cars);
        referee.decideTheGame();
        referee.printResult();
    }

    public static void repeatIncrease() {
        for (Car car : cars) {
            car.increaseCount();
            System.out.println(car);
        }
        System.out.println();
    }

    public static void carName() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.");
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(),",");

        while (st.hasMoreElements()) {
            cars.add(new Car(st.nextToken().strip()));
        }
    }

    public static void repeatCount() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");
        repeatCount = Integer.parseInt(bufferedReader.readLine());
    }
}