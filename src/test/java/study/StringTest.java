package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("Split Test")
    void SplitTest() {
        //given
        String str1 = "1,2";
        //when
        String[] result1 = str1.split(",");
        //then
        assertThat(result1).contains("1", "2");

        //given
        String str2 = "1";
        //when
        String[] result2 = str2.split(",");
        //then
        assertThat(result2).containsExactly("1");
    }
    @Test
    @DisplayName("Substring Test")
    void SubstringTest(){
        //given
        String str = "(1,2)";
        //when
        String result = str.substring(1,str.length()-1);
        //then
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("charAt Exception Test")
    void ExceptionTest(){
        //given
        String str = "abc";
        //when
        char ch = str.charAt(2);
        //then
        assertThat(ch).isEqualTo('c');

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3", "length 3");
    }
}
