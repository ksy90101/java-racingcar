package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("올바르게 차가 생성되는지 확인하는 테스트입니다.")
	@Test
	void createCorrectCar() {
		Name name = new Name("jason");
		assertThat(new Car(name, 0)).isNotNull();
	}
}
