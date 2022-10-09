package racingcar;

public class Game {

    private static final int MIN_TARGET_RACE_COUNT = 1;

    private final int targetRaceCount;
    private final Cars cars;

    public Game(int targetRaceCount, Cars cars) {
        validateTargetRaceCount(targetRaceCount);
        this.targetRaceCount = targetRaceCount;
        this.cars = cars;
    }

    private void validateTargetRaceCount(int targetRaceCount) {
        if (targetRaceCount < MIN_TARGET_RACE_COUNT) {
            throw new IllegalArgumentException("레이스 횟수는 최소 1회입니다.");
        }
    }

    public int getTargetCount() {
        return targetRaceCount;
    }

    public Cars getCars() {
        return cars;
    }
}
