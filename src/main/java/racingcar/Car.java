package racingcar;

public class Car {

    public static final int MIN_RACING_NUMBER_FOR_MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void race() {
        int racingNumber = RacingNumberGenerator.generate();

        if (racingNumber >= MIN_RACING_NUMBER_FOR_MOVE_FORWARD) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
