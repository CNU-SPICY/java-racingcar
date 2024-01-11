package generator;

import racingcar.domain.generator.NumberGenerator;

public class NonMovableNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 3;
    }
}
