package racingcar;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(String... carNames) {
        validateDuplicatedCarNames(carNames);
        this.cars = makeCarList(carNames);
    }

    private void validateDuplicatedCarNames(String[] carNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(carNames));
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private List<Car> makeCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public Cars(Car... inputCars) {
        this.cars = new ArrayList<>(Arrays.asList(inputCars));
    }

    public void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    public List<Car> getCarList() {
        return cars;
    }

    public Winners getWinners() {
        LinkedHashSet<String> winnerCarNames = new LinkedHashSet<>();
        int farthestPosition = getFarthestCarPosition();

        for (Car car : cars) {
            addToWinnerIfCarOnFarthestPosition(winnerCarNames, farthestPosition, car);
        }

        return new Winners(winnerCarNames);
    }

    private int getFarthestCarPosition() {
        int farthestPosition = -1;
        for (Car car : cars) {
            farthestPosition = compareAndGetMoreFarPosition(farthestPosition, car);
        }
        return farthestPosition;
    }

    private int compareAndGetMoreFarPosition(int currentFarthestPosition, Car car) {
        if (car.getPosition() > currentFarthestPosition) {
            currentFarthestPosition = car.getPosition();
        }
        return currentFarthestPosition;
    }

    private void addToWinnerIfCarOnFarthestPosition(Set<String> winnerCarNames, int farthestPosition, Car car) {
        if (car.getPosition() == farthestPosition) {
            winnerCarNames.add(car.getName());
        }
    }
}
