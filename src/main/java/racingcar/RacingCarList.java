package racingcar;

import java.util.ArrayList;

public class RacingCarList {
    private ArrayList<RacingCar> cars = new ArrayList<>();

    public ArrayList<RacingCar> getCars() {
        return cars;
    }

    public RacingCarList(ArrayList<RacingCar> cars) {
        this.cars = cars;
    }

    public int getCarSize() {
        return cars.size();
    }

    public RacingCar getRacingCar(int index) {
        return cars.get(index);
    }

    // 자동차 상태 결과 출력 메서드
    public void showCarStatus() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getBar()));
        System.out.println();
    }
}
