package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarApplication {

    private static final ArrayList<RacingCar> cars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        InitCarStatus(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int tries = sc.nextInt();

        GameStart(tries);

    }

    // 자동차 상태 값 초기화 메서드
    public static void InitCarStatus(String input) {
        for (String name : input.split(",")) {
            cars.add(new RacingCar(name, 0));
        }
    }


    // 한 턴마다 자동차 경주를 하는 메서드
    public static void RacingOneGame() {

    }


    // 랜덤 수 생성 및 상태 업데이트 메서드
    public static void StatusUpdate() {

    }

    // 자동차 상태 결과 출력 메서드
    public static void ShowCarStatus() {

    }

    // 승자 출력 메서드
    public static void PickWinner() {

    }
    // 게임 진행 메서드
    public static void GameStart(int tries) {

    }



}

class RacingCar {

    private String name;
    private int status;

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public RacingCar() {
    }

    public RacingCar(String name, int status) {
        this.name = name;
        this.status = status;
    }
}
