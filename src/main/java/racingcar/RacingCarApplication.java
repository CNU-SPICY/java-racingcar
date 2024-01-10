package racingcar;

import java.util.Scanner;
public class RacingCarApplication {
    private static String[] name_list;
    private static int try_num;

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String name = sc.next();
        name_list = name.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        try_num= sc.nextInt();
        sc.close();
    }
    public static void main(String[] args){
        RacingCarApplication racing = new RacingCarApplication();
        racing.input();
    }
}
