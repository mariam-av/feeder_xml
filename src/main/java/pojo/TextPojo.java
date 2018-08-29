package pojo;

public class TextPojo {

	private String title;
	private String body;
	private Boolean matchInBody;
	private Boolean matchInTitle;
	private Boolean matched;
	private Integer matchesInBody;
	private Integer matchesInTitle;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Boolean getMatchInBody() {
		return matchInBody;
	}

	public void setMatchInBody(Boolean matchInBody) {
		this.matchInBody = matchInBody;
	}

	public Boolean getMatchInTitle() {
		return matchInTitle;
	}

	public void setMatchInTitle(Boolean matchInTitle) {
		this.matchInTitle = matchInTitle;
	}

	public Boolean getMatched() {
		return matched;
	}

	public void setMatched(Boolean matched) {
		this.matched = matched;
	}

	public Integer getMatchesInBody() {
		return matchesInBody;
	}

	public void setMatchesInBody(Integer matchesInBody) {
		this.matchesInBody = matchesInBody;
	}

	public Integer getMatchesInTitle() {
		return matchesInTitle;
	}

	public void setMatchesInTitle(Integer matchesInTitle) {
		this.matchesInTitle = matchesInTitle;
	}

}
