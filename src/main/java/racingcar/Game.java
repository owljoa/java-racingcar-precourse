package racingcar;

import java.util.List;
import java.util.Set;

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
            makeResultMessageForSingleCar(stringBuilder, car);
        }

        return stringBuilder.toString();
    }

    private void makeResultMessageForSingleCar(StringBuilder stringBuilder, Car car) {
        String eachCarInitialMessage = car.getName() + WHITE_SPACE + COLON + WHITE_SPACE;
        stringBuilder.append(eachCarInitialMessage);
        appendCarTraceSymbols(stringBuilder, car);
        stringBuilder.append(LINE_BREAK);
    }

    private void appendCarTraceSymbols(StringBuilder stringBuilder, Car car) {
        for (int count = 0; count < car.getPosition(); count++) {
            stringBuilder.append(CAR_TRACE_SYMBOL);
        }
    }

    public String getWinnerMessage() {
        Set<String> carNames = cars.getWinners().getCarNames();
        return "최종 우승자" + WHITE_SPACE + COLON + WHITE_SPACE + String.join(", ", carNames);
    }
}
