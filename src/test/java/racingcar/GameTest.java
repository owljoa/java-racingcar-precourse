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

    @Test
    void 회차별_자동차별_위치_메시지_생성() throws Throwable {
        // given
        int targetRaceCount = 2;
        Cars cars = new Cars("win", "loser", "cowin");
        Game game = new Game(targetRaceCount, cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3, 4, 4, 4, 4
        );
        String resultMessage = game.getResultMessage();

        // then
        String expectedMessage = "win : --\n" +
                "loser : -\n" +
                "cowin : --\n\n";

        Assertions.assertEquals(expectedMessage, resultMessage);
    }

    @Test
    void 최종_우승자_1명_메시지_생성() throws Throwable {
        // given
        int targetRaceCount = 2;
        Cars cars = new Cars("win", "loser");
        Game game = new Game(targetRaceCount, cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3, 4, 4
        );
        String winnerMessage = game.getWinnerMessage();

        // then
        String expectedMessage = "최종 우승자 : win";
        Assertions.assertEquals(expectedMessage, winnerMessage);
    }

    @Test
    void 최종_우승자_2명_메시지_생성() throws Throwable {
        // given
        int targetRaceCount = 2;
        Cars cars = new Cars("win", "loser", "cowin");
        Game game = new Game(targetRaceCount, cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3, 4, 4, 4, 4
        );
        String winnerMessage = game.getWinnerMessage();

        // then
        String expectedMessage = "최종 우승자 : win, cowin";
        Assertions.assertEquals(expectedMessage, winnerMessage);
    }
}
