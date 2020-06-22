package domain.car;

public class Car {
	private final Name name;
	private Position position;

	public Car(final Name name, final Position position) {
		this.name = name;
		this.position = position;
	}

	public void moveCar(CarMoveStrategy carMoveStrategy){
		if(carMoveStrategy.move() > 3){
			position = position.increasePosition();
		}
	}

	public int getPosition() {
		return position.getPosition();
	}
}
