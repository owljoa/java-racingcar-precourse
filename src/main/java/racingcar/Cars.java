package racingcar;

import java.util.*;

public class Cars {
    private List<Car> cars;

    public Cars(Car... inputCars) {
        this.cars = new ArrayList<>(Arrays.asList(inputCars));
    }

    public void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    public Winners getWinners() {
        Set<String> winnerCarNames = new HashSet<>();
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
