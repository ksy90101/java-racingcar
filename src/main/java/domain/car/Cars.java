package domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars(CarMoveStrategy carMoveStrategy) {
		cars.forEach(car -> car.moveCar(carMoveStrategy));
	}

	public List<Car> getWinner() {
		return cars.stream()
			.filter(car -> car.getPosition() == getMaxPosition())
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));
	}

	public List<Car> getCars() {
		return cars;
	}
}
