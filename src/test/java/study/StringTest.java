package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void test() {
        // given
        String str = "1,2";

        // when
        String[] split = str.split(",");

        // then
        Assertions.assertThat(split).containsExactly("1", "2");
    }
}
