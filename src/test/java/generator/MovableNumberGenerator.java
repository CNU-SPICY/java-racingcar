package generator;

import racingcar.domain.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 4;
    }

}