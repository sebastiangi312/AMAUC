package com.sebastiangi312.SSKCD.persistence.infrastructure.inputs.gradeTXT;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TXTHandler {
  
  public static List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int line = 0; line < coursesSeparatedByLines.length; line += 2) {
      coursesMerged.add(coursesSeparatedByLines[line].concat("\t").
        concat(coursesSeparatedByLines[line + 1]));
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  public static String[] separateIdAndName(String idAndName) {
    String name = idAndName.split("\\s\\(\\d+\\)")[0];
    StringBuilder id = new StringBuilder();
    boolean aux = false;
    for (int i = idAndName.length() - 1; i >= 0; i--) {
      if (idAndName.charAt(i) == '(')
        break;
      if (aux)
        id.insert(0, idAndName.charAt(i));
      if (idAndName.charAt(i) == ')')
        aux = true;
    }
    return new String[]{id.toString(), name};
  }
  
}
