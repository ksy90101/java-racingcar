package domain.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCountFactoryTest {

	@DisplayName("2~10 사이의 게임 카운트가 제대로 생성되는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"2", "3", "4", "5", "6", "7", "8", "9", "10"})
	void createGameCountBetweenTwoAndTen(String gameCountInput) {
		GameCount gameCount = GameCountFactory.of(gameCountInput);
		assertThat(gameCount.getGameCount()).isEqualTo(Integer.parseInt(gameCountInput));
	}

	@DisplayName("2~10 사이의 게임 카운트가 제대로 생성되는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "11"})
	void createGameCountOverTenAndLessThanTwo(String gameCountInput) {
		assertThatThrownBy(() -> GameCountFactory.of(gameCountInput)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("게임 횟수는 2 ~ 10만 가능합니다. gameCount = " + gameCountInput);
	}
}
