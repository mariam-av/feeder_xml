package service;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pojos.rule.Match;
import pojos.rule.sets.AndSet;

public class ReadXMLFile {

	public static void main(String argv[]) {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bAnd = false;
				boolean blnMatch = false;
				boolean blnOr = false;
				boolean blnNot = false;
				String lastElement = "";
				String result = "";

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element :" + qName);
					System.out.println("REsult " + result);
					if (qName.equalsIgnoreCase("AndSet")) {

						result += " && ( ";
						bAnd = true;
					}
					if (qName.equalsIgnoreCase("Match")) {
						result += " match ";
						blnMatch = true;
					}
					if (qName.equalsIgnoreCase("OrSet")) {
						result += " || ( ";
						blnOr = true;
					}

					if (qName.equalsIgnoreCase("NotKey")) {
						result += " ! (";
						blnNot = true;
					}
				}

				public void endElement(String uri, String localName, String qName) throws SAXException {

					System.out.println("Start Element :" + qName);
					System.out.println("REsult " + result);
					if (qName.equalsIgnoreCase("AndSet")) {

						result += " ) ";
						bAnd = false;
					}
					if (qName.equalsIgnoreCase("Match")) {
						result += " ";
						blnMatch = false;
					}
					if (qName.equalsIgnoreCase("OrSet")) {
						result += " ) ";
						blnOr = false;
					}

					if (qName.equalsIgnoreCase("NotKey")) {
						result += " )";
						blnNot = false;
					}
				}
			};
			saxParser.parse("E:\\workspace\\RuleEngine-master\\src\\main\\resources\\test.xml", handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}