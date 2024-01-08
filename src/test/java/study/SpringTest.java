package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpringTest {
    @Test
    void test() {
        //given
        String str = "1,2";
        //when
        String[] result = str.split(",");
        //then
        Assertions.assertThat(result)
                .contains("1","2");
        Assertions.assertThat(result)
                .containsExactly("1","2");
    }
}
