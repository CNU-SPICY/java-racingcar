package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void test() {
        // given
        String str = "1,2";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result).contains("1", "3");
    }
}
