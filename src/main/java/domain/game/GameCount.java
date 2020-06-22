package domain.game;

public class GameCount {
	private final int gameCount;

	protected GameCount(final int gameCount) {
		validateTwoFromTen(gameCount);
		this.gameCount = gameCount;
	}

	private void validateTwoFromTen(final int gameCount){
		if(gameCount < 2 || gameCount > 10){
			throw new IllegalArgumentException("게임 횟수는 2 ~ 10만 가능합니다. gameCount = " + gameCount);
		}
	}

	public int getGameCount() {
		return gameCount;
	}
}
