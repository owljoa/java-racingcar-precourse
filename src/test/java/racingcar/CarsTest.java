package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CarsTest {

    @DisplayName("생성_성공")
    @Test
    void 생성_성공() {
        // given
        String[] carNames = {"myCar", "yours"};

        // when
        Cars cars = new Cars(carNames);

        // then
        Assertions.assertNotNull(cars);
    }

    @DisplayName("가장_멀리_간_자동차들이_우승한다")
    @Test
    void 가장_멀리_간_자동차들이_우승한다() throws Throwable {
        // given
        Car winnerCar = new Car("win");
        Car coWinnerCar = new Car("cowin");
        Car loserCar = new Car("lose");
        Cars cars = new Cars(winnerCar, coWinnerCar, loserCar);

        // when
        RacingNumberGeneratorMock.executeSomethingWithRaceNumbers(cars::race, 4, 4, 3);

        // then
        Set<String> winnerCarNames = cars.getWinners().getCarNames();
        Assertions.assertTrue(winnerCarNames.contains(winnerCar.getName()));
        Assertions.assertTrue(winnerCarNames.contains(coWinnerCar.getName()));
        Assertions.assertFalse(winnerCarNames.contains(loserCar.getName()));
    }
}
