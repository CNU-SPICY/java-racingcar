package generator;

import racingcar.domain.generator.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 4;
    }

}