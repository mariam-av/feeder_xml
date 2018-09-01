package pojos.rule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Tag")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {
  @XmlValue
  public String value;
  @XmlAttribute(required = true)
  private String id;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Tag{" +
        "value='" + value + '\'' +
        ", id='" + id + '\'' +
        '}';
  }
}
