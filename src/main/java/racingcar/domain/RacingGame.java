package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGame {
    private final Car[] cars;
    private final RandomGenerator random;
    private final ArrayList<String> winners;

    public RacingGame(String[] carNames) {
        cars = new Car[carNames.length];
        random = new RandomGenerator();
        winners = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++) {
            Car new_car = new Car(carNames[i]);
            cars[i] = new_car;
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(random.randomGenerate());
        }
    }

    public Car[] getCars() {
        return cars;
    }

    public ArrayList<String> findWinners() {
        int max = findMaxDistance(cars);
        for (Car car : cars) {
            addToWinnersListIfMaxDistance(car, max);
        }
        return winners;
    }

    public int findMaxDistance(Car[] cars) {
        int[] distances = new int[cars.length];
        for(int i = 0; i < cars.length; i++) {
            distances[i] = cars[i].getDistance();
        }
        Arrays.sort(distances);
        return distances[distances.length -1];
    }

    public void addToWinnersListIfMaxDistance(Car car, int max) {
        if(car.getDistance() == max){
            winners.add(car.getCarName());
        }
    }
}
