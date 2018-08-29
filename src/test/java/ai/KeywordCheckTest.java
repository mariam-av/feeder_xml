package ai;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import attributes.WordMatch;
import checks.KeywordCheck;
import pojo.TextPojo;

public class KeywordCheckTest {

	@Test
	public  void wordMatchCheck() throws IOException {
		TextPojo text = new TextPojo();
		ClassLoader classLoader = KeywordCheck.class.getClassLoader();

		File file = new File(classLoader.getResource("text.txt").getFile());
		String body = FileUtils.readFileToString(file);
		text.setBody(body);
		text.setTitle("YAHOO seeks wider Philippine footprint");
		KeywordCheck.wordMatch(text, WordMatch.WHOLEWORD.name(), "Yahoo");
		KeywordCheck.wordMatch(text, WordMatch.EXACT.name(), "YAHOO");
		KeywordCheck.wordMatch(text, WordMatch.STEMMEDWORD.name(), "Aim");

	}
}
