package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	@DisplayName("올바른 위치가 생성되는지 확인하는 테스트")
	@Test
	void createCorrectPosition() {
		Position position = new Position(0);
		assertThat(position.getPosition()).isEqualTo(0);
	}

	@DisplayName("1이 증가한 위치를 반환하는지 확인하는 테스트")
	@Test
	void increasePosition() {
		Position position = PositionFactory.of(0);
		assertThat(position.increasePosition().getPosition()).isEqualTo(1);
	}
}
