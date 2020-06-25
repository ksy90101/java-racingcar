package domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars(CarMoveValueStrategy carMoveValueStrategy) {
		cars.forEach(car -> car.moveCar(carMoveValueStrategy));
	}

	public List<Car> getWinner() {
		return Collections.unmodifiableList(cars.stream()
			.filter(car -> car.getPosition() == getMaxPosition())
			.collect(Collectors.toList()));
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
