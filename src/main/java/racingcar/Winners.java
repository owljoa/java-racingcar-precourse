package racingcar;

import java.util.Set;

public class Winners {
    private final Set<String> carNames;

    public Winners(Set<String> carNames) {
        this.carNames = carNames;
    }

    public Set<String> getCarNames() {
        return carNames;
    }
}
