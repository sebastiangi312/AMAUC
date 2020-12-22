package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
import com.sebastiangi312.SSKCD.application.handler.PersistenceCourseHandler;
import com.sebastiangi312.SSKCD.application.handler.PersistenceGradeHandler;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courseManager")
public class CourseController {
  
  
  private final PersistenceCourseHandler persistenceCourseHandler;
  private final PersistenceGradeHandler persistenceGradeHandler;
  private final CourseHandler courseHandler;
  
  public CourseController(PersistenceCourseHandler domainHandler,
                          PersistenceGradeHandler persistenceGradeHandler, CourseHandler courseHandler) {
    this.persistenceCourseHandler = domainHandler;
    this.persistenceGradeHandler = persistenceGradeHandler;
    this.courseHandler = courseHandler;
  }
  
  @Transactional
  @RequestMapping(value = "/courses", method = RequestMethod.POST)
  public void uploadCourses(@RequestBody final String coursesInTxt) {
    for (String[] course : parseToList(coursesInTxt)) {
      String[] codeAndName = separateIdAndName(course[0]);
      persistenceCourseHandler.saveCourses(codeAndName[0], codeAndName[1], course[1]);
      persistenceGradeHandler.saveGrade(codeAndName[0], course[5], course[4], course[3]);
    }
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
  
  private List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int line = 0; line < coursesSeparatedByLines.length; line += 2) {
      coursesMerged.add(coursesSeparatedByLines[line].concat("\t").
                        concat(coursesSeparatedByLines[line + 1]));
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  
  @RequestMapping(value = "/courses", method = RequestMethod.GET)
  public Map<String, List<Object>> getCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", persistenceCourseHandler.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/gradedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getGradedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", persistenceGradeHandler.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
  public void deleteAllCourses() {
    persistenceGradeHandler.deleteAll();
    persistenceCourseHandler.deleteAll();
  }
  
  @RequestMapping(value = "/course/{code}", method = RequestMethod.GET)
  public Map<String, Object> get(@PathVariable String code) {
    Map<String, Object> response = new HashMap<>();
    response.put("course", persistenceCourseHandler.getCourse(code));
    return response;
  }
  
  @Transactional
  @RequestMapping(value = "/course/{code}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String code) {
    persistenceGradeHandler.delete(code);
    persistenceCourseHandler.delete(code);
  }
  
  @RequestMapping(value = "/generalInformation", method = RequestMethod.GET)
  public Map<String, Double> getGradeAverage() {
    Map<String, Double> response = new HashMap<>();
    response.put("PAPA", courseHandler.getPAPA());
    response.put("PA", courseHandler.getPA());
    return response;
  }
  
}
