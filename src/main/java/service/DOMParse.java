package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SpringLayout.Constraints;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import pojos.rule.Keyword;
import pojos.rule.Match;

public class DOMParse {
	private static List<pojos.Node> nodes = new ArrayList<pojos.Node>();

	static public void main(String[] arg) {

		boolean validate = true;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// dbf.setValidating(validate);
		dbf.setNamespaceAware(true);
		dbf.setIgnoringElementContentWhitespace(true);
		Document doc = null;
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			builder.setErrorHandler(new MyErrorHandler());

			ClassLoader classLoader = DOMParse.class.getClassLoader();

			InputSource is = new InputSource(classLoader.getResourceAsStream("test.xml"));
			doc = builder.parse(is);
		} catch (SAXException e) {
			System.exit(1);
		} catch (ParserConfigurationException e) {
			System.err.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		parse(doc);
	}

	private static void parse(Document doc) {
		parsing((Node) doc, "", doc);
	}

	private static void parsing(Node node, String indent, Node parentNode) {
		if (node.getLocalName() != null)
			switch (node.getLocalName()) {
			case "Keyword":
				System.out.println(indent + "Keyword");
				Keyword nodeK = new Keyword();
				nodeK.setValue(node.getTextContent());
				nodeK.setWordMatch(node.getAttributes().getNamedItem("WordMatch").getNodeValue());
				nodes.add(nodeK);
				break;
			case "Match":
				Match match = new Match();
				nodes.add(match);
				if (node.hasChildNodes()) {
					NodeList list = node.getChildNodes();
					for (int i = 0; i < list.getLength(); i++) {
						parsing(list.item(i), indent + " ", node.getParentNode());
					}
				}
				System.out.println(indent + "Match");
				break;
			case "OrSet":
				System.out.println(indent + "OrSet");
				break;
			case "AndSet":
				System.out.println(indent + "AndSet");
				break;
			case "null":
				System.out.println(indent + "Keyword value");
				break;

			default:
				System.out.println(indent + "Unknown node");
				break;
			}

		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			parsing(list.item(i), indent + "   ", node.getParentNode());
		}
	}
}

class MyErrorHandler implements ErrorHandler {
	public void warning(SAXParseException e) throws SAXException {
		show("Warning", e);
		throw (e);
	}

	public void error(SAXParseException e) throws SAXException {
		show("Error", e);
		throw (e);
	}

	public void fatalError(SAXParseException e) throws SAXException {
		show("Fatal Error", e);
		throw (e);
	}

	private void show(String type, SAXParseException e) {
		System.out.println(type + ": " + e.getMessage());
		System.out.println("Line " + e.getLineNumber() + " Column " + e.getColumnNumber());
		System.out.println("System ID: " + e.getSystemId());
	}
}
