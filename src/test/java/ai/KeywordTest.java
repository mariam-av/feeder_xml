package ai;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import rules.Keyword;

public class KeywordTest {

	@Test
	public void KeywordTesting() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Keyword.class);
		Unmarshaller unmarshall = context.createUnmarshaller();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_file.xml").getFile());
		Keyword rule = (Keyword) unmarshall.unmarshal(file);
		System.out.println(rule.toString());
	}
}
