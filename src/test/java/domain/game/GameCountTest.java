package domain.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCountTest {

	@DisplayName("올바른 게임 횟수가 생성되는지 확인하는 테스트")
	@Test
	void createCorrectGameCount() {
		assertThat(new GameCount(10)).isNotNull();
	}

	@DisplayName("게임 횟수 10을 초과했을 경우 예외처리하는 테스트")
	@Test
	void createGameCountOverTen() {
		assertThatThrownBy(() -> new GameCount(11)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("게임 횟수는 2 ~ 10만 가능합니다. gameCount = 11");
	}

	@DisplayName("게임 횟수 2을 미만인 경우 예외처리하는 테스트")
	@Test
	void createGameCountLessThanTwo() {
		assertThatThrownBy(() -> new GameCount(1)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("게임 횟수는 2 ~ 10만 가능합니다. gameCount = 1");
	}
}