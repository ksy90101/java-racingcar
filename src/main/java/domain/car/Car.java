package domain.car;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;

	private final Name name;
	private Position position;

	public Car(final Name name, final Position position) {
		this.name = name;
		this.position = position;
	}

	public void moveCar(final CarMoveValueStrategy carMoveValueStrategy) {
		if (carMoveValueStrategy.create() >= MIN_MOVE_VALUE) {
			position = position.increasePosition();
		}
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}
}
