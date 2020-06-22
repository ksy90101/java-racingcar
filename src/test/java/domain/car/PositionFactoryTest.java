package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionFactoryTest {

	@DisplayName("0~10 사이의 게임 위치가 제대로 생성되는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	void createPositionBetweenTwoAndTen(int expected) {
		Position position = PositionFactory.of(expected);
		assertThat(position.getPosition()).isEqualTo(expected);
	}

	@DisplayName("음수이거나 10을 초과하면 예외처리 합니다.")
	@ParameterizedTest
	@ValueSource(ints = {11, -1})
	void createPositionEqualsNegativeOrOverTen(int position) {
		assertThatThrownBy(() -> PositionFactory.of(position)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("나올 수 없는 위치 입니다. position = " + position);
	}
}
