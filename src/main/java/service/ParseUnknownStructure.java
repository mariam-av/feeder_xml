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
	private static String strString = "";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		ClassLoader classLoader = DOMParse.class.getClassLoader();
		Document document = builder.parse(new File(classLoader.getResource("test.xml").getFile()));

		document.getDocumentElement().normalize();
		NodeList nodelist = document.getChildNodes();

		System.out.println("============================");
		visitChildNodes(document, nodelist, document.getAttributes());
	}

	public static boolean matchParser(NamedNodeMap attr) {
		return true;
	}

	private static boolean visitChildNodes(Document document, NodeList nList, NamedNodeMap parAttr) {
		boolean result = false;
		Text text = new Text();
		text.setTitle("Manchester United");
		text.setBody("Man Untd");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("NODE NAME " + node.getNodeName());
				switch (node.getNodeName()) {
				case "Keyword":
					System.out.println("=============");
					String attr = node.getAttributes().getNamedItem("WordMatch").getNodeValue();
					text.setMatched(false);
					// xckel parAttr@ checkum
					// System.out.println(KeywordCheck.wordMatch(text, attr,
					// node.getTextContent()).getMatched());
					result = KeywordCheck.wordMatch(text, attr, node.getTextContent()).getMatched();
					strString += (result) ? "T" : "F";
					break;
				case "Match":
					strString += "(";
					System.out.println("MATCHING " + node.getNodeName());
					visitChildNodes(document, node.getChildNodes(), node.getAttributes());

					strString += ")";
					
//					for (temp = 0; temp < node.getChildNodes().getLength(); temp++) {
//						Node nodeInner = node.getChildNodes().item(temp);
//						if (node.getNodeType() == Node.ELEMENT_NODE) {
//							switch (nodeInner.getNodeName()) {
//							case "Keyword":
//								attr = nodeInner.getAttributes().getNamedItem("WordMatch").getNodeValue();
//								text.setMatched(false);
//								// xckel parAttr@ checkum
//								// System.out.println(KeywordCheck.wordMatch(text,
//								// attr, node.getTextContent()).getMatched());
//								result = KeywordCheck.wordMatch(text, attr, nodeInner.getTextContent()).getMatched();
//								strString += (result) ? "T" : "F";
//								System.out.println(strString);
//								break;
//							}
//						}
//					}
					// if (node.hasChildNodes()) {
					// visitChildNodes(document, node.getChildNodes(),
					// node.getAttributes());
					// }
					break;
				case "OrSet":
					strString += " || ";
					break;
				case "AndSet":
					strString += " && ";
					break;
				case "NotKey":
					strString += " ! ";
					break;
				case "null":
					break;

				case "Condition":
					break;
				}
				if (node.hasChildNodes()) {
					visitChildNodes(document, node.getChildNodes(), node.getAttributes());
				}

			}
		}
		System.out.println(strString);
		return result;
	}
}