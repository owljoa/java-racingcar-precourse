package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameUserInterface {

    public static final String COMMA = ",";
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void startGame() {
        Game game;
        Cars cars = null;
        int targetRaceCount = 0;

        while (cars == null) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = readCarNames();
            cars = makeCars(carNames);
        }
        game = new Game(cars);

        while (targetRaceCount <= 0) {
            System.out.println("시도할 회수는 몇회인가요?");
            targetRaceCount = readRaceCount();
        }

        for (int round = 0; round < targetRaceCount; round++) {
            game.startRace();
            System.out.println(game.getResultMessage());
        }
        System.out.println(game.getWinnerMessage());
    }

    private String[] readCarNames() {
        String inputCarNames = Console.readLine();
        return inputCarNames.split(COMMA);
    }

    private Cars makeCars(String[] carNames) {
        try {
            return new Cars(carNames);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_MESSAGE_PREFIX + iae.getMessage());
            return null;
        }
    }

    private int readRaceCount() {
        try {
            String inputRaceCount = Console.readLine();
            ValidationUtils.validateRaceCount(inputRaceCount);
            return Integer.parseInt(inputRaceCount);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_MESSAGE_PREFIX + iae.getMessage());
            return 0;
        }
    }
}
