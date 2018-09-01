package app;

import java.io.File;
import parser.RuleFileParser;
import pojos.result.MatchResult;
import service.RuleMatchService;
import util.FileUtil;

public class RuleEngine {

  public static void main(String[] args) {
    String ruleFilePath = args[0];
    String textFilePath = args[1];

    File ruleFile = new File(ruleFilePath);

    try {
      Rule rule = RuleFileParser.INSTANCE.parse(ruleFile);
      String text = FileUtil.readFile(textFilePath);

      RuleMatchService ruleMatchService = new RuleMatchService();
      MatchResult matchResult = ruleMatchService.checkMatch(rule, text);




    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
