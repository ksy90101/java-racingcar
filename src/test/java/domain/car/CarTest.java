package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("올바르게 차가 생성되는지 확인하는 테스트입니다.")
	@Test
	void createCorrectCar() {
		Name name = new Name("jason");
		Position position = new Position(0);
		Car car = new Car(name, position);
		assertThat(car.getName()).isEqualTo("jason");
	}

	@DisplayName("4 이상이면 전진하는 테스트")
	@Test
	void moveCarByOverFive() {
		CarMoveValueStrategy carMoveValueStrategy = () -> 4;
		Car car = new Car(new Name("pobi"), PositionFactory.of(0));
		car.moveCar(carMoveValueStrategy);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("4 미만이면 정지하는 테스트")
	@Test
	void moveCarByLessThenFive() {
		CarMoveValueStrategy carMoveValueStrategy = () -> 3;
		Car car = new Car(new Name("pobi"), PositionFactory.of(0));
		car.moveCar(carMoveValueStrategy);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
