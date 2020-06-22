package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void createCorrectPosition() {
		Position position = new Position(0);
		assertThat(position.getPosition()).isEqualTo(0);
	}
}
