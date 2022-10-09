package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    void 레이스_횟수는_숫자만_처리_가능() {
        // given
        String inputRaceCount = "abc";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateRaceCount(inputRaceCount));
    }
}
