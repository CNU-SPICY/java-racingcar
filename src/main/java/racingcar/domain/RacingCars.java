package racingcar.domain;

import racingcar.domain.RacingCar;

import java.util.ArrayList;

public class RacingCars {
    private final ArrayList<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String carNames) {
        createRacingCars(carNames);
    }

    private void createRacingCars(String carNames) {
        for (String name : carNames.split(",")) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void racingOneGame() {
        for(RacingCar racingCar : racingCars) {
            racingCar.carPositionUpdate();
        }
    }


    public ArrayList<RacingCar> getCars() {
        return racingCars;
    }



    public int getCarSize() {
        return racingCars.size();
    }


    public StringBuilder getAllCurrentBarStatus() {
        StringBuilder Bars = new StringBuilder();
        racingCars.forEach(racingCar -> Bars.append(racingCar.getCurrentBarStatus()).append("\n"));
        return Bars;
    }
}
