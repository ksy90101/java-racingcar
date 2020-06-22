package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.car.Car;
import domain.car.Name;
import domain.car.Position;
import domain.game.GameCount;
import domain.game.GameCountFactory;
import view.InputView;

public class RacingController {
	public void run() {
		String inputCarNames = InputView.inputCarNames();
		List<Car> cars = createCars(inputCarNames);
		String inputGameCount = InputView.inputGameCount();
		GameCount gameCount = GameCountFactory.of(inputGameCount);
	}

	private List<Car> createCars(final String inputCarNames) {
		List<String> carNames = Arrays.stream(inputCarNames.split(","))
			.collect(Collectors.toList());

		return carNames.stream()
			.map(Name::new)
			.map(name -> new Car(name, new Position(0)))
			.collect(Collectors.toList());
	}
}
