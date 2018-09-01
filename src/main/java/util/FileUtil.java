package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtil {

  public static String readFile(String fileName) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
      sb.append(line);
      sb.append(System.lineSeparator());
      line = br.readLine();
    }
    return sb.toString();
  }
}
