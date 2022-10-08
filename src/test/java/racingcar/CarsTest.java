package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

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

    @DisplayName("생성_시_자동차_이름_중복_검증")
    @Test
    void 생성_시_자동차_이름_중복되면_예외_발생() {
        // given
        String[] carNames = {"dup", "dup"};

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
    }

    @DisplayName("가장 멀리 간 자동차들이 우승한다")
    @Test
    void winners() {
        // given
        Car winnerCar = new Car("win");
        Car coWinnerCar = new Car("cowin");
        Car loserCar = new Car("lose");
        Cars cars = new Cars(winnerCar, coWinnerCar, loserCar);

        // when
        raceWithInputRaceNumber(cars, 4, 4, 3);

        // then
        Winners winners = cars.getWinners();
        Assertions.assertTrue(
                winners.getCarNames().contains(winnerCar.getName())
        );
        Assertions.assertTrue(
                winners.getCarNames().contains(coWinnerCar.getName())
        );
        Assertions.assertFalse(
                winners.getCarNames().contains(loserCar.getName())
        );
    }

    private void raceWithInputRaceNumber(Cars cars, int firstRaceNumber, int... raceNumbersAfterFirst) {
        try (final MockedStatic<RacingNumberGenerator> mock = Mockito.mockStatic(RacingNumberGenerator.class)) {
            mock.when(RacingNumberGenerator::generate).thenReturn(
                    firstRaceNumber,
                    Arrays.stream(raceNumbersAfterFirst)
                            .boxed()
                            .toArray()
            );

            cars.race();
        }
    }
}