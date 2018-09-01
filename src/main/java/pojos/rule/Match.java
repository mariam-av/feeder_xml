package pojos.rule;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Match")
@XmlAccessorType(XmlAccessType.FIELD)
public class Match {
  @XmlAttribute(name = "MatchIn", required = true)
  private String matchIn;
  @XmlAttribute(name = "MatchLimit", required = true)
  private String matchLimit;
  @XmlAttribute(name = "MatchUnit", required = true)
  private String matchUnit;
  @XmlAttribute(name = "Weight", required = true)
  private Double weight;
  @XmlAttribute(name = "WeightRepeat", required = true)
  private String weightRepeat;

  @XmlElements( {@XmlElement(name = "Keyword", type = Keyword.class, required = true)})
  private List<Keyword> keywords;

  public String getMatchIn() {
    return matchIn;
  }

  public void setMatchIn(String matchIn) {
    this.matchIn = matchIn;
  }

  public String getMatchLimit() {
    return matchLimit;
  }

  public void setMatchLimit(String matchLimit) {
    this.matchLimit = matchLimit;
  }

  public String getMatchUnit() {
    return matchUnit;
  }

  public void setMatchUnit(String matchUnit) {
    this.matchUnit = matchUnit;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public String getWeightRepeat() {
    return weightRepeat;
  }

  public void setWeightRepeat(String weightRepeat) {
    this.weightRepeat = weightRepeat;
  }

  public List<Keyword> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<Keyword> keywords) {
    this.keywords = keywords;
  }

  @Override
  public String toString() {
    return "Match [matchIn=" + matchIn + ", matchLimit=" + matchLimit + ", matchUnit=" +
        matchUnit + ", weight="
        + weight + ", weightRepeat=" + weightRepeat + ", keywords=" + keywords + "]";
  }
}
