package study;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class stringTest {

    @Test
    void test1(){
        // given
        String given = "1,2";

        // when
        String[] result = given.split(",");

        // then
        assertThat(result).contains("1", "2");


        // given
        given = "1";

        // when
        result = given.split(",");

        // then
        assertThat(result).containsExactly("1");

    }

    @Test
    void test2(){
        // given
        String given = "(1,2)";

        // when
        String result = given.replace("(", "").replace(")", "");

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void test3(){
        // given
        String given = "abc";

        // when
        Throwable thrown = catchThrowable(()->{
            given.charAt(3);
        });

        // then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }

}