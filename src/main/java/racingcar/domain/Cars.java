package racingcar.domain;

import racingcar.domain.Generator.CarMoveValueGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(CarMoveValueGenerator carMoveValueGenerator) {
        for (Car car : cars) {
            car.movePosition(carMoveValueGenerator);
        }
    }

    public List<Car> selectWinners() {
        List<Car> winners;
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .get();
        winners = cars.stream()
                .filter(car -> car.isMaxPosition(maxDistanceCar))
                .collect(Collectors.toList());
        return winners;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}