package com.sebastiangi312.SSKCD.infraestructure.controller.persistanceController;

import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.CoursePersistenceHandler;
import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.GradePersistenceHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courseManager/grades")
public class GradeController {
  
  private final CoursePersistenceHandler coursePersistenceHandler;
  private final GradePersistenceHandler gradePersistenceHandler;
  
  public GradeController(CoursePersistenceHandler coursePersistenceHandler,
                         GradePersistenceHandler gradePersistenceHandler) {
    this.coursePersistenceHandler = coursePersistenceHandler;
    this.gradePersistenceHandler = gradePersistenceHandler;
  }
  
  @Transactional
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void uploadGrades(@RequestBody final String coursesInTxt) {
    for (String[] course : parseToList(coursesInTxt)) {
      String[] codeAndName = separateIdAndName(course[0]);
      coursePersistenceHandler.saveCourses(codeAndName[0], codeAndName[1], course[1]);
      gradePersistenceHandler.saveGrade(codeAndName[0], course[3], course[4], course[5]);
    }
  }
  
  
  private List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int line = 0; line < coursesSeparatedByLines.length; line += 2) {
      coursesMerged.add(coursesSeparatedByLines[line].concat("\t").
        concat(coursesSeparatedByLines[line + 1]));
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  private String[] separateIdAndName(String idAndName) {
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
  
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public void deleteAllCourses() {
    gradePersistenceHandler.deleteAll();
  }
  
  
  @RequestMapping(value = "/gradedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getGradedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceHandler.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/approvedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getApprovedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceHandler.getApprovedCourses());
    return response;
  }
  
}
