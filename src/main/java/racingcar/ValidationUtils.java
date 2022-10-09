package racingcar;

public class ValidationUtils {


    public static void validateRaceCount(String inputRaceCount) {
        validateIfInputIsInteger(inputRaceCount);
    }

    private static void validateIfInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력이 가능합니다.");
        }
    }
}
