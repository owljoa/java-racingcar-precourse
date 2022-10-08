package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class CarTest {

    private static MockedStatic<RacingNumberGenerator> racingNumberGenerator;

    @BeforeAll
    public static void setup() {
        racingNumberGenerator = Mockito.mockStatic(RacingNumberGenerator.class);
    }

    @AfterAll
    public static void teardown() {
        racingNumberGenerator.close();
    }

    @ParameterizedTest(name = "레이스 후 전진/정지 위치 검증 - 레이싱번호: {0}, 위치: {1}")
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void 레이스_후_전진_정지_위치_검증(int racingNumber, int expectedPosition) {
        // given
        Mockito.when(RacingNumberGenerator.generate())
                .thenReturn(racingNumber);
        Car car = new Car();

        // when
        car.race();

        // then
        Assertions.assertEquals(expectedPosition, car.getPosition());
    }
}
