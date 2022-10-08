package racingcar;

import org.junit.jupiter.api.*;
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


    @DisplayName("전진_위치이동_검증")
    @Test
    void 전진_위치이동_검증() {
        // given
        Mockito.when(RacingNumberGenerator.generate())
                .thenReturn(4);

        Car car = new Car();

        // when
        car.race();

        // then
        Assertions.assertEquals(1, car.getPosition());
    }


}
