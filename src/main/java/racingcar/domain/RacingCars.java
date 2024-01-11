package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        for (RacingCar racingCar : racingCars) {
            racingCar.carPositionUpdate();
        }
    }

    public StringBuilder getAllCurrentBarStatus() {
        StringBuilder Bars = new StringBuilder();
        racingCars.forEach(racingCar -> Bars.append(racingCar.getCurrentBarStatus()).append("\n"));
        return Bars;
    }

    // 승자 계산 메서드
    public List<String> pickWinner(RacingCars racingCars) {
        final RacingCar maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private List<String> findSamePositionCars(RacingCar maxPositionCar) {
        return racingCars
                .stream()
                .filter(maxPositionCar::isSampePositionCar)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private RacingCar findMaxPositionCar() {
        return racingCars
                .stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("RacingCars가 비어있습니다."));
    }
}
