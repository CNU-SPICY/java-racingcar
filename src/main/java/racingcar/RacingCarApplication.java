package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //이름 및 시도 횟수 입력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = in.nextLine();
        String[] carNames = inputNames.split(",");

        while(!isValidCarNames(carNames)) {
            System.out.println("각 자동차 이름은 5자 이하로 입력해주세요.");
            inputNames = in.nextLine();
            carNames = inputNames.split(",");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = in.nextInt();



    }
    //차 이름이 다섯글자 이하인지 확인
    private static boolean isValidCarNames(String[] carNames) {
        return Arrays.stream(carNames).allMatch(name -> name.trim().length() <= 5);
    }




}
