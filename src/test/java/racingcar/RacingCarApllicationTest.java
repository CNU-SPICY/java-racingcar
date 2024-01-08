package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class RacingCarApllicationTest {
    private ArrayList<Person> people;

    @BeforeEach
    void setUp(){
        people = new ArrayList<>();
        people.add(new Person("pobi", 1));
        people.add(new Person("crong", 3));
        people.add(new Person("honux", 2));
    }

    @Test
    @DisplayName("getWinners")
    void checkGetWinners(){
        // when
        String result = RacingCarApplication.getWinners(people);

        // then
        assertThat(result).isEqualTo("crong");

    }

    @Test
    @DisplayName("updateScoreUsingRandomInt")
    void checkUpdateScoreUsingRandomInt(){
        // given
        int score = people.get(1).getScore();

        // when
        RacingCarApplication.updateScoreUsingRandomInt(people.get(1), 4);

        // then
        assertThat(people.get(1).getScore()).isEqualTo(score+1);
    }


    @Test
    @DisplayName("getNamesFromInput")
    void checkGetNamesFromInput(){
        // given
        String given = "pobi,crong,honux";

        // when
        String[] result = RacingCarApplication.getNamesFromInput(given);

        // then
        assertThat(result).contains("pobi", "crong", "honux");

    }

    @Test
    @DisplayName("getCountFromInput")
    void checkGetCountFromInput(){
        // given
        String given = "-5";

        assertThatThrownBy(()->{
            RacingCarApplication.getRoundFromInput(given);
        }).isInstanceOf(NumberFormatException.class);

        String test = "abc";
        assertThatThrownBy(()->{
            RacingCarApplication.getRoundFromInput(test);
        }).isInstanceOf(NumberFormatException.class);

    }

}
