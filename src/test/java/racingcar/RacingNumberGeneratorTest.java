package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RacingNumberGeneratorTest {

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void 레이싱_숫자_0_9_사이값_검증() {
        // when
        int generatedNumber = RacingNumberGenerator.generate();

        // then
        boolean isValid = generatedNumber >= RacingNumberGenerator.MIN_RACING_NUMBER
                && generatedNumber <= RacingNumberGenerator.MAX_RACING_NUMBER;
        Assertions.assertTrue(isValid);
    }
}
