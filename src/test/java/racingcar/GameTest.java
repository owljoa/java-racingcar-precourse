package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    
    @Test
    void 생성_1보다_작은_횟수_예외_발생() {
        // given
        int targetRaceCount = 0;

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Game(targetRaceCount));
    }
}
