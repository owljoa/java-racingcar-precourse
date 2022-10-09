package racingcar;

import java.util.LinkedHashSet;

public class Winners {
    private final LinkedHashSet<String> carNames;

    public Winners(LinkedHashSet<String> carNames) {
        this.carNames = carNames;
    }

    public LinkedHashSet<String> getCarNames() {
        return carNames;
    }
}
