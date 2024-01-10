package racingcar;

import java.util.Scanner;
import java.util.Random;
class Car {
    private String car_name;
    private int distance = 0;
    private Random random = new Random();
    public Car(String car_name) {
        this.car_name = car_name;

    }
    public String getCar_name() {
        return car_name;
    }
    public int getDistance() {
        return distance;
    }
    public void move() {
        if (random.nextInt(10) >= 4) {
            distance ++;
        }
    }
    public void print() {
        System.out.println(car_name + " : " + "-".repeat(distance));
    }
}

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
