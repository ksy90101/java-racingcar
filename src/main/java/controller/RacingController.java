package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.car.Car;
import domain.car.CarMoveStrategy;
import domain.car.Name;
import domain.car.Position;
import domain.game.GameCount;
import domain.game.GameCountFactory;
import view.InputView;
import view.OutputView;

public class RacingController {
	private final CarMoveStrategy carMoveStrategy = () -> (int) (Math.random() * 10);

	public void run() {
		String inputCarNames = InputView.inputCarNames();
		List<Car> cars = createCars(inputCarNames);
		String inputGameCount = InputView.inputGameCount();
		GameCount gameCount = GameCountFactory.of(inputGameCount);
		OutputView.runResultGuide();
		for (int i = 0; i < gameCount.getGameCount(); i++){
			cars.forEach(car -> car.moveCar(carMoveStrategy));
			OutputView.runResult(cars);
		}
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
