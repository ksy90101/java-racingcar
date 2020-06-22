package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.car.Car;
import domain.car.CarMoveStrategy;
import domain.car.Cars;
import domain.car.Name;
import domain.car.PositionFactory;
import domain.game.GameCount;
import domain.game.GameCountFactory;
import view.InputView;
import view.OutputView;

public class RacingController {

	private static final String SPLIT_DELIMITER = ",";
	private static final CarMoveStrategy carMoveStrategy = () -> (int)(Math.random() * 10);

	public void run() {
		String inputCarNames = InputView.inputCarNames();
		Cars cars = new Cars(createCars(inputCarNames));
		String inputGameCount = InputView.inputGameCount();
		GameCount gameCount = GameCountFactory.of(inputGameCount);
		OutputView.runResultGuide();
		for (int i = 0; i < gameCount.getGameCount(); i++) {
			cars.moveCars(carMoveStrategy);
			OutputView.printRunResult(cars.getCars());
		}
		OutputView.printWinner(cars.getWinner());
	}

	private List<Car> createCars(final String inputCarNames) {
		List<String> carNames = Arrays.stream(inputCarNames.split(SPLIT_DELIMITER))
			.collect(Collectors.toList());

		return carNames.stream()
			.map(Name::new)
			.map(name -> new Car(name, PositionFactory.of(0)))
			.collect(Collectors.toList());
	}
}
