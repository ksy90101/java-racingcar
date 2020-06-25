package controller;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import domain.car.Car;
import domain.car.CarMoveValueStrategy;
import domain.car.Cars;
import domain.car.Name;
import domain.car.PositionFactory;
import domain.game.GameCount;
import domain.game.GameCountFactory;
import view.InputView;
import view.OutputView;

public class RacingController {

	private static final String SPLIT_DELIMITER = ",";
	private static final int MAX_CAR_MOVE_VALUE = 10;
	private static final CarMoveValueStrategy CAR_MOVE_VALUE_STRATEGY = () -> (int)(Math.random() * MAX_CAR_MOVE_VALUE);
	private static final Logger logger = Logger.getLogger("logger");

	public void run() {
		try {
			String inputCarNames = InputView.inputCarNames();
			Cars cars = createCars(inputCarNames);
			String inputGameCount = InputView.inputGameCount();
			GameCount gameCount = GameCountFactory.of(inputGameCount);

			moveCarsByGameCount(cars, gameCount);

			OutputView.printWinner(cars.getWinner());
		} catch (IllegalArgumentException e) {
			logger.warning(e.getMessage());
		}
	}

	private void moveCarsByGameCount(Cars cars, GameCount gameCount) {
		OutputView.runResultGuide();
		for (int i = 0; i < gameCount.getGameCount(); i++) {
			cars.moveCars(CAR_MOVE_VALUE_STRATEGY);
			OutputView.printRunResult(cars.getCars());
		}
	}

	private Cars createCars(final String inputCarNames) {
		List<String> carNames = Arrays.stream(inputCarNames.split(SPLIT_DELIMITER))
			.collect(Collectors.toList());

		return carNames.stream()
			.map(Name::new)
			.map(name -> new Car(name, PositionFactory.of(0)))
			.collect(collectingAndThen(toList(), Cars::new));
	}
}
