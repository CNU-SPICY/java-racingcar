package racingcar;

import java.util.ArrayList;

public class Referee {
    ArrayList<Car> cars;

    public Referee(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> decideTheGame(ArrayList<Car> cars) {
        ArrayList<Car> victoryCar = initVictoryCar(cars);
        for (Car car : cars) {
            faster(victoryCar, car);
        }

        return victoryCar;
    }   // 우승자 판별

    public void printResult(ArrayList<Car> victoryCars) {
        StringBuilder result = new StringBuilder();
        for (Car victoryCar : victoryCars) {
            result.append(victoryCar.getCarName())
                    .append(", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        result.append("가 최종우승했습니다.");
        System.out.println(result);
    }   // 우승 결과 출력

    public ArrayList<Car> initVictoryCar(ArrayList<Car> cars) {
        ArrayList<Car> list = new ArrayList<>();
        if (!cars.isEmpty()) {
             list.add(cars.get(0));
        }
        return list;
    } // 우승자를 판별할 초기값

    public static void faster(ArrayList<Car> a, Car b) {
         Car tmp = a.get(0);
        if(tmp.compareTo(b) > 0){
            return;
        }
        a.clear();
        a.add(b);
    } // 우상자 판별을 위한 거리 비교
}
