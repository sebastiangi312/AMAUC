package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
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
  
  
  private final CoursePersistenceController coursePersistenceController;
  private final GradePersistenceController gradePersistenceController;
  private final CourseHandler courseHandler;
  
  public CourseController(CoursePersistenceController coursePersistenceController,
                          GradePersistenceController gradePersistenceController,
                          CourseHandler courseHandler) {
    this.coursePersistenceController = coursePersistenceController;
    this.gradePersistenceController = gradePersistenceController;
    this.courseHandler = courseHandler;
  }
  
  
  @Transactional
  @RequestMapping(value = "/courses", method = RequestMethod.POST)
  public void uploadCourses(@RequestBody final String coursesInTxt) {
    for (String[] course : parseToList(coursesInTxt)) {
      String[] codeAndName = separateIdAndName(course[0]);
      coursePersistenceController.saveCourses(codeAndName[0], codeAndName[1], course[1]);
      gradePersistenceController.saveGrade(codeAndName[0], course[5], course[4], course[3]);
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
  
  @RequestMapping(value = "/courses", method = RequestMethod.GET)
  public Map<String, List<Object>> getCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", coursePersistenceController.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/gradedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getGradedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceController.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
  public void deleteAllCourses() {
    gradePersistenceController.deleteAll();
    coursePersistenceController.deleteAll();
  }
  
  @RequestMapping(value = "/course/{code}", method = RequestMethod.GET)
  public Map<String, Object> get(@PathVariable String code) {
    Map<String, Object> response = new HashMap<>();
    response.put("course", coursePersistenceController.getCourse(code));
    return response;
  }
  
  @Transactional
  @RequestMapping(value = "/course/{code}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String code) {
    gradePersistenceController.delete(code);
    coursePersistenceController.delete(code);
  }
  
  @RequestMapping(value = "/generalInformation", method = RequestMethod.GET)
  public Map<String, Double> getGradeAverage() {
    Map<String, Double> response = new HashMap<>();
    response.put("PAPA", courseHandler.getPAPA());
    response.put("PA", courseHandler.getPA());
    return response;
  }
  
}
