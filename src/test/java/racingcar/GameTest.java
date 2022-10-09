package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 생성_성공() {
        // given
        int targetRaceCount = 1;
        Cars cars = new Cars("myCar", "yoCar");

        // when
        Game game = new Game(targetRaceCount, cars);

        // then
        Assertions.assertNotNull(game);
        Assertions.assertEquals(targetRaceCount, game.getTargetCount());
        Assertions.assertEquals(cars, game.getCars());
    }

    @Test
    void 생성_1보다_작은_횟수_예외_발생() {
        // given
        int targetRaceCount = 0;
        Cars cars = new Cars("myCar", "yoCar");

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Game(targetRaceCount, cars));
    }
}
