package domain.car;

public class Name {

	private static final String BLANK = "";
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Name(final String name) {
		String nameAfterTrim = trimName(name);
		validateOverFive(nameAfterTrim);
		validateBlank(nameAfterTrim);
		this.name = nameAfterTrim;
	}

	private void validateOverFive(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 5글자까지만 가능합니다. name = " + name);
		}
	}

	private void validateBlank(final String name) {
		if (name.equals(BLANK)) {
			throw new IllegalArgumentException("이름에 공백만 들어갈 수 없습니다.");
		}
	}

	private String trimName(final String name) {
		return name.trim();
	}

	public String getName() {
		return name;
	}
}
