package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("'1,2'를 쉼표로 분리할 때 '1'과 '2'로 정확히 분리되는지 확인")
    public void splitStringCommaSeparated() {
        // given
        String numbers = "1,2";

        // when
        String[] result = numbers.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 쉼표로 분리할 때 결과 배열이 '1'만 포함하는지 확인")
    public void splitStringSingleNumber() {
        // given
        String numbers = "1";

        // when
        String[] result = numbers.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 괄호를 제거하고 '1,2'를 반환하는지 확인")
    public void removeParentheses() {
        // given
        String numbers = "(1,2)";

        // when
        String result = numbers.replaceAll("[()]", "");

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는지 확인")
    public void charAt() {
        // given
        String str = "abc";

        // when
        char result = str.charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("잘못된 위치 값으로 문자를 가져올 때 예외가 발생하는지 확인")
    public void charAtException() {
        // given
        String str = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
