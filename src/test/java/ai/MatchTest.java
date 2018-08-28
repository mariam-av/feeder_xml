package ai;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import rules.Match;
import validation.RuleValidation;

public class MatchTest {

	@Test
	public void MatchTesting() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(Match.class);
		Unmarshaller unmarshall = context.createUnmarshaller();
		ClassLoader classLoader = getClass().getClassLoader();
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(classLoader.getResource("validation/RuleSchema.xsd"));
		unmarshall.setSchema(schema);
		unmarshall.setEventHandler(new RuleValidation());
		File file = new File(classLoader.getResource("test_file_match.xml").getFile());
		Match rule = (Match) unmarshall.unmarshal(file);
		System.out.println(rule.toString());
		file = new File(classLoader.getResource("test_file_match_error.xml").getFile());
		rule = (Match) unmarshall.unmarshal(file);
		System.out.println(rule.toString());
	}
}
