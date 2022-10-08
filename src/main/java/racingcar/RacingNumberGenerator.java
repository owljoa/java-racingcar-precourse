package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingNumberGenerator {

    public static int MIN_RACING_NUMBER = 0;
    public static int MAX_RACING_NUMBER = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_RACING_NUMBER, MAX_RACING_NUMBER);
    }
}
