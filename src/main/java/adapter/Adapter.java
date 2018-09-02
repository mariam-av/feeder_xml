package adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import pojos.Node;
import pojos.rule.sets.Condition;

public class Adapter extends XmlAdapter< String, Node> {

	@Override
	public String marshal(Node v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(v.toString());
		return null;
	}
}
