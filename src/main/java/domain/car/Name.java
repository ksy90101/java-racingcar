package domain.car;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Name(final String name) {
		validateOverFive(name);
		this.name = name;
	}

	private void validateOverFive(final String name){
		if(name.length() > MAX_NAME_LENGTH){
			throw new IllegalArgumentException("이름은 5글자까지만 가능합니다. name = " + name);
		}
	}

	public String getName() {
		return name;
	}
}
