package generator;

import racingcar.domain.NumberGenerator;

public class NonMovableNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 3;
    }
}
