package rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Keyword {
    @XmlValue
    public String value;
	@XmlAttribute
	private String wordMatch;

	public String getWordMatch() {
		return wordMatch;
	}

	public void setWordMatch(String wordMatch) {
		this.wordMatch = wordMatch;
	}

	@Override
	public String toString() {
		return "wordMatch = " + wordMatch + ", value = " + value;
	}

}
