package domain.game;

public class GameCount {

	private static final int MIN_GAME_COUNT = 2;
	private static final int MAX_GAME_COUNT = 10;

	private final int gameCount;

	protected GameCount(final int gameCount) {
		validateTwoFromTen(gameCount);
		this.gameCount = gameCount;
	}

	private void validateTwoFromTen(final int gameCount) {
		if (gameCount < MIN_GAME_COUNT || gameCount > MAX_GAME_COUNT) {
			throw new IllegalArgumentException("게임 횟수는 2 ~ 10만 가능합니다. gameCount = " + gameCount);
		}
	}

	public int getGameCount() {
		return gameCount;
	}
}
