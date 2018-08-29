package attributes;

public enum WordMatch {

	WHOLEWORD("wholeword"), EXACT("exact"), STEMMEDWORD("stemmedword");

	private String value;

	WordMatch(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
