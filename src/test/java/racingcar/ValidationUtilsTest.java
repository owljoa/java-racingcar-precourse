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

    @Test
    void 레이스_횟수는_1보다_큰값이어야_처리_가능() {
        // given
        String inputRaceCount = "0";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateRaceCount(inputRaceCount));
    }

    @Test
    void 자동차_이름_5자_초과_예외_발생_검증() {
        // given
        String inputName = "lovelyCar";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateCarName(inputName));
    }

    @Test
    void 자동차_이름_중복되면_예외_발생() {
        // given
        String[] carNames = {"dup", "dup"};

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validateCarNames(carNames));
    }
}
