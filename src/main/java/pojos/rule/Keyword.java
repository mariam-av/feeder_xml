package pojos.rule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import pojos.Node;

@XmlRootElement(name = "Keyword")
@XmlAccessorType(XmlAccessType.FIELD)
public class Keyword extends Node {
  @XmlValue
  private String value;
  @XmlAttribute(name= "WordMatch",required = true)
  private String wordMatch;

  public String getWordMatch() {
    return wordMatch;
  }

  public void setWordMatch(String wordMatch) {
    this.wordMatch = wordMatch;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "wordMatch = " + wordMatch + ", value = " + value;
  }

}
