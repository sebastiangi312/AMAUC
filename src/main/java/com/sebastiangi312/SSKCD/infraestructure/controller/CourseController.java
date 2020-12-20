package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
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
  
  
  private final PersistanceCourseHandler persistanceCourseHandler;
  
  public CourseController(PersistanceCourseHandler domainHandler) {
    this.persistanceCourseHandler = domainHandler;
  }
  
  @Transactional
  @RequestMapping(value = "/courses/", method = RequestMethod.POST)
  public void uploadCourses(@RequestBody final String coursesInTxt) {
    for (String[] course : parseToList(coursesInTxt)) {
      persistanceCourseHandler.saveCourses(course[0], course[1]);
    }
  }
  
  private List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int line = 0; line < coursesSeparatedByLines.length; line += 2) {
      coursesMerged.add(coursesSeparatedByLines[line].concat("\t")
        .concat(coursesSeparatedByLines[line + 1]));
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  
  @RequestMapping(value = "/courses", method = RequestMethod.GET)
  public Map<String, List<Object>> getAll() {
    return null;
  }
  
  @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
  public void deleteAll() {
  
  }
  
  @RequestMapping(value = "/course/{code}", method = RequestMethod.GET)
  public Map<String, Object> get(@PathVariable String code) {
    return new HashMap<>();
  }
  
  @Transactional
  @RequestMapping(value = "/course/{code}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String code) {
  
  }
  
  @RequestMapping(value = "/generalInformation", method = RequestMethod.GET)
  public Map<String, Double> getGradeAverage() {
    return new HashMap<>();
  }
}
