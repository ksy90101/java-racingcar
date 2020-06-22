package domain.game;

public class GameCount {
	private final int gameCount;

	public GameCount(String gameCount) {
		int gameCountNumber = Integer.parseInt(gameCount);
		validateTwoFromTen(gameCountNumber);
		this.gameCount = gameCountNumber;
	}

	public void validateTwoFromTen(int gameCount){
		if(gameCount < 2 || gameCount > 10){
			throw new IllegalArgumentException("게임 횟수는 2 ~ 10만 가능합니다. gameCount = " + gameCount);
		}
	}
}
