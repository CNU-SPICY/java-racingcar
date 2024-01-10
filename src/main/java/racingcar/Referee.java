package racingcar;

import java.util.ArrayList;

public class Referee {
    private ArrayList<Car> cars;

    private static ArrayList<Car> victoryCars;

    public Referee() {}
    public Referee(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getVictoryCars() {
        return victoryCars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }
    public void decideTheGame() {
        initVictoryCar();
        for (Car car : cars) {
            faster(car);
        }
    }   // 우승자 판별

    public void printResult() {
        StringBuilder result = new StringBuilder();
        for (Car victoryCar : victoryCars) {
            result.append(victoryCar.getCarName())
                    .append(", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        result.append("가 최종우승했습니다.");
        System.out.println(result);
    }   // 우승 결과 출력

    public void initVictoryCar() {
        ArrayList<Car> list = new ArrayList<>();
        if (!cars.isEmpty()) {
             list.add(cars.get(0));
        }
        victoryCars = list;
    }   // 우승자를 판별할 초기값

    public void faster(Car cmp) {
        Car tmp= victoryCars.get(0);
        if(tmp.equals(cmp)) return;
        if(tmp.compareTo(cmp) > 0){
            return;
        }
        if(tmp.compareTo(cmp) == 0) {
            victoryCars.add(cmp);
            return;
        }
        victoryCars.clear();
        victoryCars.add(cmp);
    }   // 우상자 판별을 위한 거리 비교
}
