package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

	@DisplayName("올바른 이름이 생성된다.")
	@Test
	void createCorrectName() {
		Name jun = new Name("jun");
		assertThat(jun.getName()).isEqualTo("jun");
	}

	@DisplayName("이름이 5자를 초과했을 경우 예외를 던진다.")
	@Test
	void crateNameOverFive() {
		assertThatThrownBy(() -> new Name("JasonG")).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 5글자까지만 가능합니다. name = JasonG");
	}

	@DisplayName("빈칸이 들어왔을 경우 예외처리하는 테스트 입니다.")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "     ",})
	void createNameByBlank(String inputCarName) {
		assertThatThrownBy(() -> new Name(inputCarName)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름에 공백만 들어갈 수 없습니다.");
	}
}
