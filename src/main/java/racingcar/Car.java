package racingcar;

public class Car {

    public static final int MIN_RACING_NUMBER_FOR_MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        ValidationUtils.validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void race() {
        int racingNumber = RacingNumberGenerator.generate();

        if (racingNumber >= MIN_RACING_NUMBER_FOR_MOVE_FORWARD) {
            moveForward();
        }
    }

    private void moveForward() {
        position += 1;
    }
}
