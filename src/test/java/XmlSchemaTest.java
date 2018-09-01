import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.junit.Test;
import org.xml.sax.SAXException;
import pojos.rule.Keyword;
import pojos.rule.Match;
import pojos.rule.Rule;
import validation.RuleValidation;

public class XmlSchemaTest {

  @Test
  public void matchTest() throws JAXBException, SAXException {
    JAXBContext context = JAXBContext.newInstance(Match.class);
    Unmarshaller unmarshall = context.createUnmarshaller();
    ClassLoader classLoader = getClass().getClassLoader();
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = sf.newSchema(classLoader.getResource("RuleSchema.xsd"));
    unmarshall.setSchema(schema);
    unmarshall.setEventHandler(new RuleValidation());
    File file = new File(classLoader.getResource("test_file_match.xml").getFile());
    Match rule = (Match) unmarshall.unmarshal(file);
    System.out.println(rule.toString());
    file = new File(classLoader.getResource("test_file_match_error.xml").getFile());
    rule = (Match) unmarshall.unmarshal(file);
    System.out.println(rule.toString());
  }

  @Test
  public void schemaTest() throws JAXBException, SAXException {
    JAXBContext context = JAXBContext.newInstance(Rule.class);
    Unmarshaller unmarshall = context.createUnmarshaller();
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test_file_rule_all.xml").getFile());
    Rule rule = (Rule) unmarshall.unmarshal(file);
    System.out.println(rule.toString());

  }

  @Test
  public void keywordTest() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Keyword.class);
    Unmarshaller unmarshall = context.createUnmarshaller();
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test_file.xml").getFile());
    Keyword keyword = (Keyword) unmarshall.unmarshal(file);
    System.out.println(keyword.toString());
  }

  @Test
  public void ruleTest() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Rule.class);
    Unmarshaller unmarshall = context.createUnmarshaller();
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test_file_rule.xml").getFile());
    Rule rule = (Rule) unmarshall.unmarshal(file);
    System.out.println(rule.toString());
  }

}
