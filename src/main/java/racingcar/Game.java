package racingcar;

import java.util.List;

public class Game {

    private static final int MIN_TARGET_RACE_COUNT = 1;
    private static final String COLON = ":";
    private static final String CAR_TRACE_SYMBOL = "-";
    private static final String WHITE_SPACE = " ";
    private static final String LINE_BREAK = "\n";

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

    public void startRace() {
        for (int round = 0; round < targetRaceCount; round++) {
            cars.race();
        }
    }

    public String getResultMessage() {
        List<Car> carList = cars.getCarList();
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : carList) {
            stringBuilder.append(car.getName());
            stringBuilder.append(WHITE_SPACE);
            stringBuilder.append(COLON);
            stringBuilder.append(WHITE_SPACE);
            for (int count = 0; count < car.getPosition(); count++) {
                stringBuilder.append(CAR_TRACE_SYMBOL);
            }
            stringBuilder.append(LINE_BREAK);
        }
        stringBuilder.append(LINE_BREAK);

        return stringBuilder.toString();
    }
}
