package pojos.rule;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import pojos.rule.sets.Condition;

@XmlRootElement(name = "Rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rule {
  @XmlElements({@XmlElement(name = "Condition", type = Condition.class)})
  private List<Condition> conditions;
  @XmlElements( {@XmlElement(name = "Match", type = Match.class)})
  private List<Match> matches;
  @XmlElements( {@XmlElement(name = "Keyword", type = Keyword.class)})
  private List<Keyword> keywords;
  @XmlElements( {@XmlElement(name = "tag", type = Tag.class, required = true)})
  private Tag tag;

}