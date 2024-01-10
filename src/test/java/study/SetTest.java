package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    @DisplayName("Size Test")
    void SizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Contain Test1")
    @ValueSource(ints = {1,2,3})
    void ContainTest1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Contain Test2")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void ContainTest2(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
