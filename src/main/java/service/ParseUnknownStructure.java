package service;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.Receiver;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import checks.KeywordCheck;
import pojos.Text;
import pojos.rule.Keyword;
import pojos.rule.Match;

public class ParseUnknownStructure {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		ClassLoader classLoader = DOMParse.class.getClassLoader();
		Document document = builder.parse(new File(classLoader.getResource("test.xml").getFile()));

		document.getDocumentElement().normalize();

		NodeList nodelist = document.getChildNodes();

		System.out.println("============================");
		visitChildNodes(nodelist, document.getAttributes());
	}

	public static boolean matchParser(NamedNodeMap attr) {
		return true;
	}

	// This function is called recursively
	private static boolean visitChildNodes(NodeList nList, NamedNodeMap parAttr) {
		boolean result = false;
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			// System.out.println("NODE NAME " + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("NODE NAME " + node.getNodeName());
				switch (node.getNodeName()) {
				case "Keyword":
					if (node.hasAttributes()) {
						String attr = node.getAttributes().getNamedItem("WordMatch").getNodeValue();
						System.out.println(node.getTextContent());
						System.out.println(attr);
						Text text = new Text();
						text.setTitle("Manchester United");
						text.setBody("Man Untd");
						//xckel parAttr@ checkum
						
						System.out.println(KeywordCheck.wordMatch(text, attr, node.getTextContent()).getMatched());
						result &= KeywordCheck.wordMatch(text, attr, node.getTextContent()).getMatched();
					}
					break;
				case "Match":
					if (node.hasChildNodes()) {
						visitChildNodes(node.getChildNodes(), node.getAttributes());
					}
					break;
				case "OrSet":
					break;
				case "AndSet":
					break;
				case "null":
					break;

				case "Condition":
					break;
				}
				if (node.hasChildNodes()) {
					visitChildNodes(node.getChildNodes(), node.getAttributes());
				}

			}
		}
		return result;
	}
}