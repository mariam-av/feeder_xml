package pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import adapter.Adapter;

@XmlRootElement
public class ParentNode {

@XmlJavaTypeAdapter(Adapter.class)
	private List<Node> nodes;

}
