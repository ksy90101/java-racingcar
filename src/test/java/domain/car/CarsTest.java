package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private Cars cars;
	private Car pobi;
	private Car jun;
	private Car jason;
	private Car brown;

	@BeforeEach
	void setUp() {
		pobi = new Car(new Name("pobi"), PositionFactory.of(3));
		jun = new Car(new Name("jun"), PositionFactory.of(5));
		jason = new Car(new Name("jason"), PositionFactory.of(5));
		brown = new Car(new Name("brown"), PositionFactory.of(0));

		cars = new Cars(Arrays.asList(pobi, jun, jason, brown));
	}

	@DisplayName("우승자 선별하는 테스트")
	@Test
	void winner() {
		assertThat(cars.getWinner()).containsExactly(jun, jason);
	}

	@DisplayName("차들이 움직이는지 확인하는 테스트")
	@Test
	void moveCars() {
		CarMoveValueStrategy carMoveValueStrategy = () -> 4;
		cars.moveCars(carMoveValueStrategy);
		assertThat(cars.getCars().get(0).getPosition()).isEqualTo(4);
	}
}
