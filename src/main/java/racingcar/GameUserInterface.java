package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameUserInterface {

    public static final String COMMA = ",";
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void startGame() {
        Cars cars = null;

        while (cars == null) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = readCarNames();
            cars = makeCars(carNames);
        }
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
}
