package checks;

import pojos.enums.WordMatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import pojos.Text;

public class KeywordCheck {

  public static Text wordMatch(Text text, String wordMatchAttr, String value) {
    int countInBody = 0;
    int countInTitle = 0;
    if (wordMatchAttr.equals(WordMatch.EXACT.name())) {
      Matcher matcher = Pattern.compile("(^|\\s)" + value + "(\\s|$)").matcher(text.getBody());
      while (matcher.find()) {
        countInBody++;
      }
      matcher = Pattern.compile("(^|\\s)" + value + "(\\s|$)").matcher(text.getTitle());
      while (matcher.find()) {
        countInTitle++;
      }
    } else if (wordMatchAttr.equals(WordMatch.WHOLEWORD.toString())) {
      Matcher matcher = Pattern.compile("(^|\\s)" + value + "(\\s|$)", Pattern.CASE_INSENSITIVE)
          .matcher(text.getBody());
      while (matcher.find()) {
        countInBody++;
      }
      matcher = Pattern.compile("(^|\\s)" + value + "(\\s|$)", Pattern.CASE_INSENSITIVE).matcher
          (text.getTitle());
      while (matcher.find()) {
        countInTitle++;
      }
    } else if (wordMatchAttr.equals(WordMatch.STEMMEDWORD.name())) {
      countInBody = StringUtils.countMatches(text.getBody().toLowerCase(), value.toLowerCase());
      countInTitle = StringUtils.countMatches(text.getTitle().toLowerCase(), value.toLowerCase());
    }
    if (countInBody > 0) {
      text.setMatchInBody(true);
      text.setMatchesInBody(countInBody);
      text.setMatched(true);
    }
    if (countInTitle > 0) {
      text.setMatchInTitle(true);
      text.setMatchesInTitle(countInTitle);
      text.setMatched(true);
    }
    return text;

  }
}
