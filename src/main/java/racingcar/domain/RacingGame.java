package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGame {
    private final String[] carNames;
    private final Car[] carList;
    private ArrayList<String> winList = new ArrayList<>();

    public RacingGame(String[] carNames) {
        this.carNames = carNames;
        carList = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i++) {
            Car new_car = new Car(carNames[i]);
            carList[i] = new_car;
        }
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public Car[] getCarList() {
        return carList;
    }

    public void findWinners() {
        int max = findMaxDistance(carList);
        for (Car car : carList) {
            addWinner(car, max);
        }
    }

    public int findMaxDistance(Car[] carList) {
        int[] disList = new int[carNames.length];
        for(int i = 0; i < carList.length; i++) {
            disList[i] = carList[i].getDistance();
        }
        Arrays.sort(disList);
        return disList[disList.length -1];
    }

    public void addWinner(Car car, int max) {
        if(car.getDistance() == max){
            winList.add(car.getCarName());
        }
    }

    public ArrayList<String> getWinnerList() {
        return winList;
    }
}
