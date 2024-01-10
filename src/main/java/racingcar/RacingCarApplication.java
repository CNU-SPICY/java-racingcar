package racingcar;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;



public class RacingCarApplication {
    private static String[] name_list;
    private static int try_num;
    private static ArrayList<String> win_list = new ArrayList<>();


    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String name = sc.next();
        name_list = name.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        try_num= sc.nextInt();
        sc.close();
    }
    public void moveRacing(Car[] car_list) {
        for(int i = 0; i < car_list.length; i++) {
            car_list[i].move();
        }
    }
    public void printRacing(Car[] car_list) {
        for(int i = 0; i < car_list.length; i++) {
            car_list[i].print();
        }
        System.out.println("");
    }

    public int getMax(Car[] car_list) {
        int[] dis_list = new int[name_list.length];
        for(int i = 0; i < car_list.length; i++) {
            dis_list[i] = car_list[i].getDistance();
        }
        Arrays.sort(dis_list);
        int max = dis_list[dis_list.length -1];
        return max;
    }

    public void addWinner(Car car, int max) {
        if(car.getDistance() == max){
            win_list.add(car.getCar_name());
        }
    }

    public void printWinner(Car[] car_list) {
        int max = getMax(car_list);
        for(int i = 0; i < car_list.length; i++) {
            addWinner(car_list[i], max);
        }
        String winner = "";
        for(String str : win_list){
            winner += (str + ", ");
        }
        winner = winner.substring(0, winner.length() - 2) + "가 최종 우승했습니다.";
        System.out.println(winner);
    }


    public static void main(String[] args){
        RacingCarApplication racing = new RacingCarApplication();
        racing.input();

        Car[] car_list = new Car[name_list.length];

        for(int i = 0; i < name_list.length; i++) {
            Car new_car = new Car(name_list[i]);
            car_list[i] = new_car;
        }
        for(int i = 0; i < try_num; i++) {
            racing.moveRacing(car_list);
            racing.printRacing(car_list);
        }
        racing.printWinner(car_list);


    }
}
