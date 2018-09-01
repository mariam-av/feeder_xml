package pojos.rule.sets;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import pojos.rule.Keyword;
import pojos.rule.Match;

//@XmlRootElement(name = "AndSet")
public class BooleanSet {
//
  @XmlElements( {@XmlElement(name = "Match", type = Match.class)})
  private List<Match> matches;

  public void setMatches(List<Match> matches) {
    this.matches = matches;
  }

  @Override
  public String toString() {
    return "BooleanSet{" +
        "matches=" + matches +
        '}';
  }
}
