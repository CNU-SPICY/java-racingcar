package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RandomNumberGenerator;

public class RacingCars {

    private final ArrayList<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        createRacingCars(carNames);
    }

    private void createRacingCars(List<String> carNames) {
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void racingOneGame() {
        for (RacingCar racingCar : racingCars) {
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            racingCar.move(numberGenerator);
        }
    }

    public List<String> pickWinner(RacingCars racingCars) {
        RacingCar maxPositionCar = findWinner();
        return findSamePositionCars(maxPositionCar);
    }

    private RacingCar findWinner() {
        return racingCars
                .stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("RacingCars가 비어있습니다."));
    }

    private List<String> findSamePositionCars(RacingCar maxPositionCar) {
        return racingCars
                .stream()
                .filter(maxPositionCar::isSamePositionCar)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
