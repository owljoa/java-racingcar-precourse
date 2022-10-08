package racingcar;

import org.junit.jupiter.api.*;
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

    @DisplayName("자동차_정상_생성")
    @Test
    void 자동차_정상_생성() {
        // given
        String inputName = "myCar";

        // when
        Car car = new Car(inputName);

        // then
        Assertions.assertEquals(inputName, car.getName());
        Assertions.assertEquals(0, car.getPosition());
    }

    @DisplayName("이름_5자_초과_예외_발생_검증")
    @Test
    void 이름_5자_초과_예외_발생_검증() {
        // given
        String inputName = "lovelyCar";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(inputName));
    }

    @ParameterizedTest(name = "레이스 후 전진/정지 위치 검증 - 레이싱번호: {0}, 위치: {1}")
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void 레이스_후_전진_정지_위치_검증(int racingNumber, int expectedPosition) {
        // given
        Mockito.when(RacingNumberGenerator.generate())
                .thenReturn(racingNumber);
        Car car = new Car("myCar");

        // when
        car.race();

        // then
        Assertions.assertEquals(expectedPosition, car.getPosition());
    }
}
