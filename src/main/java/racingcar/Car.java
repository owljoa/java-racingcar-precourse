package racingcar;

public class Car {

    public static final int MIN_RACING_NUMBER_FOR_MOVE_FORWARD = 4;

    private int position;

    public void race() {
        int racingNumber = RacingNumberGenerator.generate();

        if (racingNumber >= MIN_RACING_NUMBER_FOR_MOVE_FORWARD) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
