package racingcar.domain;

import racingcar.domain.RacingCar;

import java.util.ArrayList;

public class RacingCars {
    private ArrayList<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String carNames) {
        createRacingCars(carNames);
    }

    private void createRacingCars(String carNames) {
        for (String name : carNames.split(",")) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void racingOneGame() {

    }


    public ArrayList<RacingCar> getCars() {
        return racingCars;
    }



    public int getCarSize() {
        return racingCars.size();
    }

    public RacingCar getRacingCar(int index) {
        return racingCars.get(index);
    }

    // 자동차 상태 결과 출력 메서드
    public void showCarStatus() {
        racingCars.forEach(car -> System.out.println(car.getName() + " : " + car.getBar()));
        System.out.println();
    }


}
