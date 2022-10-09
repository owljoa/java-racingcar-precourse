package racingcar;

public class Game {

    private static final int MIN_TARGET_RACE_COUNT = 1;

    private final int targetRaceCount;

    public Game(int targetRaceCount) {
        validateTargetRaceCount(targetRaceCount);
        this.targetRaceCount = targetRaceCount;
    }

    private void validateTargetRaceCount(int targetRaceCount) {
        if (targetRaceCount < MIN_TARGET_RACE_COUNT) {
            throw new IllegalArgumentException("레이스 횟수는 최소 1회입니다.");
        }
    }
}
