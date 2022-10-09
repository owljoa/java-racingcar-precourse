package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 생성_성공() {
        // given
        Cars cars = new Cars("myCar", "yoCar");

        // when
        Game game = new Game(cars);

        // then
        Assertions.assertNotNull(game);
        Assertions.assertEquals(cars, game.getCars());
    }

    @Test
    void 회차별_자동차별_위치_메시지_생성() throws Throwable {
        // given
        Cars cars = new Cars("win", "loser", "cowin");
        Game game = new Game(cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3, 4
        );
        String resultMessage = game.getResultMessage();

        // then
        String expectedMessage = "win : -\n" +
                "loser : \n" +
                "cowin : -\n";

        Assertions.assertEquals(expectedMessage, resultMessage);
    }

    @Test
    void 최종_우승자_1명_메시지_생성() throws Throwable {
        // given
        Cars cars = new Cars("win", "loser");
        Game game = new Game(cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3
        );
        String winnerMessage = game.getWinnerMessage();

        // then
        String expectedMessage = "최종 우승자 : win";
        Assertions.assertEquals(expectedMessage, winnerMessage);
    }

    @Test
    void 최종_우승자_2명_메시지_생성() throws Throwable {
        // given
        Cars cars = new Cars("win", "loser", "cowin");
        Game game = new Game(cars);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(
                game::startRace,
                4,
                3, 4
        );
        String winnerMessage = game.getWinnerMessage();

        // then
        String expectedMessage = "최종 우승자 : win, cowin";
        Assertions.assertEquals(expectedMessage, winnerMessage);
    }
}
