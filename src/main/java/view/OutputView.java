package view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.car.Car;

public class OutputView {
	private static final String POSITION_SYMBOL = "-";
	private static final String JOINING_DELIMITER = "";

	public static void runResultGuide() {
		System.out.println("실행결과");
	}

	public static void runResult(List<Car> cars){
		for (Car car : cars) {
			System.out.printf("%s : %s", car.getName(), convertPositionSymbol(car));
			System.out.println();
		}
		System.out.println();
	}

	private static String convertPositionSymbol(Car car){
		return IntStream.range(0, car.getPosition())
			.mapToObj(position -> POSITION_SYMBOL)
			.collect(Collectors.joining(JOINING_DELIMITER));
	}
}
