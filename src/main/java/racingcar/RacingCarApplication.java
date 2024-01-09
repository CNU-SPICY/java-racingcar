package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarApplication {

    private static Random random = new Random();
    public static RacingCarList racingCarList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        initCarStatus(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int tries = sc.nextInt();

        gameStart(tries);
    }

    // 자동차 상태 값 초기화 메서드
    private static void initCarStatus(String input) {
        ArrayList<RacingCar> cars = new ArrayList<>();
        for (String name : input.split(",")) {
            cars.add(new RacingCar(name, 0));
        }
        racingCarList = new RacingCarList(cars);
    }


    // 한 턴마다 자동차 경주를 하는 메서드
    private static void racingOneGame() {
        for (int i=0; i<racingCarList.getCarSize(); i++) {
            statusUpdate(racingCarList.getRacingCar(i));
        }
    }


    // 랜덤 수 생성 및 상태 업데이트 메서드
    private static void statusUpdate(RacingCar car) {

        // 0에서 9까지의 랜덤 숫자 생성
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            car.increaseStatus();
            car.increaseCurrentCarBar();
        }

    }

    // 승자 계산 메서드
    private static void pickWinner() {

        int maxStatus = racingCarList.getCars().stream()
                .mapToInt(RacingCar::getStatus)
                .max()
                .orElse(-1);

        List<String> winners = racingCarList.getCars().stream()
                .filter(car -> car.getStatus() == maxStatus)
                .map(RacingCar::getName).collect(Collectors.toList());

        printWinner(winners);
    }

    // 승자 출력 메서드
    private static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    // 게임 진행 메서드
    private static void gameStart(int tries) {
        for (int i=0; i<tries; i++) {
            racingOneGame();
            racingCarList.showCarStatus();
        }
        racingCarList.showCarStatus();
        pickWinner();
    }

}


