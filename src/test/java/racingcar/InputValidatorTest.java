package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputValidatorTest {
    // test before create InputValidator
    InputValidator inputValidator = new InputValidator();

    @Test
    void validateCarNamesDistinct() {
        inputValidator.validateCarNames("pobi,crong,honux");
    }

    @Test
    void validateCarNamesDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames("pobi,crong,honux,pobi");
        });
    }


    @Test
    void validateCarNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarName("pobicon");
        });
    }

    @Test
    void validateCarNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarName("");
        });
    }

    @Test
    void validateCarNameBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarName(" ");
        });
    }

    @Test
    void validateNumberOfTrialsNumeric() {
        inputValidator.validateNumberOfTrials("5");
    }

    @Test
    void validateNumberOfTrialsNotNumeric() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNumberOfTrials("a");
        });
    }

    @Test
    void validateNumberOfTrialsPositive() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNumberOfTrials("0");
        });
    }

    @Test
    void validateNumberOfTrialsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNumberOfTrials("-1");
        });
    }
}
