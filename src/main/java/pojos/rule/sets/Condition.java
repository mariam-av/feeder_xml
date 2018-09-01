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

@XmlRootElement(name="Condition")
@XmlAccessorType(XmlAccessType.FIELD)
public class Condition {
  @XmlElements({
      @XmlElement(name = "AndSet", type = AndSet.class),
      @XmlElement(name = "OrSet", type = OrSet.class)
  })
  //@XmlElement(name = "AndSet", type = AndSet.class)=
  private List<BooleanSet> booleanSets;

  public List<BooleanSet> getBooleanSets() {
    return booleanSets;
  }

  public void setBooleanSets(List<BooleanSet> booleanSets) {
    this.booleanSets = booleanSets;
  }

  @Override
  public String toString() {
    return "Condition{" +
        "booleanSets=" + booleanSets +
        '}';
  }
}
