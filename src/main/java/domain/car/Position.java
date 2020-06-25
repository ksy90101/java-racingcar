package domain.car;

public class Position {

	private static final int increaseValue = 1;

	private final int position;

	Position(final int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public Position increasePosition() {
		return PositionFactory.of(position + increaseValue);
	}
}
