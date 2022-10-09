package racingcar;

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
}
