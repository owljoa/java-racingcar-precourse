package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private static final int MIN_TARGET_RACE_COUNT = 1;

    public static void validateRaceCount(String inputRaceCount) {
        validateIfInputIsInteger(inputRaceCount);
        validateIfLessThanMinimumRaceCount(Integer.parseInt(inputRaceCount));
    }

    private static void validateIfInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력이 가능합니다.");
        }
    }

    private static void validateIfLessThanMinimumRaceCount(int raceCount) {
        if (raceCount < MIN_TARGET_RACE_COUNT) {
            throw new IllegalArgumentException("레이스 횟수는 최소 1회입니다.");
        }
    }

    public static void validateCarName(String inputCarName) {
        if (inputCarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateCarNames(String[] carNames) {
        validateDuplicatedCarNames(carNames);
    }

    private static void validateDuplicatedCarNames(String[] carNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(carNames));
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
