package ai;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import rules.Match;

public class MatchTest {

	@Test
	public void MatchTesting() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Match.class);
		Unmarshaller unmarshall = context.createUnmarshaller();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_file_match.xml").getFile());
		Match rule = (Match) unmarshall.unmarshal(file);
		System.out.println(rule.toString());
	}
}
