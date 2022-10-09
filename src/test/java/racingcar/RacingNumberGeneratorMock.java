package racingcar;

import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

public class RacingNumberGeneratorMock {

    public static void executeSomethingWithRaceNumbers(Executable executable, int firstRaceNumber, int... raceNumbersAfterFirst) throws Throwable {
        try (final MockedStatic<RacingNumberGenerator> mock = Mockito.mockStatic(RacingNumberGenerator.class)) {
            mock.when(RacingNumberGenerator::generate).thenReturn(
                    firstRaceNumber,
                    Arrays.stream(raceNumbersAfterFirst)
                            .boxed()
                            .toArray()
            );

            executable.execute();
        }
    }
}
