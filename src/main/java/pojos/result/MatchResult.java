package pojos.result;

public class MatchResult {

  private boolean keywordMatch;
  private boolean matchRuleMatch;



  public boolean isKeywordMatch() {
    return keywordMatch;
  }

  public void setKeywordMatch(boolean keywordMatch) {
    this.keywordMatch = keywordMatch;
  }

  public boolean isMatchRuleMatch() {
    return matchRuleMatch;
  }

  public void setMatchRuleMatch(boolean matchRuleMatch) {
    this.matchRuleMatch = matchRuleMatch;
  }
}
