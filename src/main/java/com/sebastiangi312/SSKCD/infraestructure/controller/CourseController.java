package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.factory.CourseComandoFactory;
import com.sebastiangi312.SSKCD.application.handler.CourseHandler;

import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.*;

@RestController
@RequestMapping("api/v1/courseManager")
public class CourseController {
  
  
  private final CourseHandler courseHandler;
  private final CourseComandoFactory courseComandoFactory;
  
  public CourseController(CourseHandler courseHandler, CourseComandoFactory courseComandoFactory) {
    this.courseHandler = courseHandler;
    this.courseComandoFactory = courseComandoFactory;
  }
  
  @Transactional
  @RequestMapping(value = "/courses/", method = RequestMethod.POST)
  public void uploadCourses(@RequestBody final String coursesInTxt) {
    for(String[] course : parseToList(coursesInTxt)){
      courseHandler.saveCourse(courseComandoFactory.createCourseComando(course));
    }
  }
  
  private List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int line = 0; line < coursesSeparatedByLines.length; line += 2) {
      coursesMerged.add(coursesSeparatedByLines[line]);
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  
  @RequestMapping(value = "/courses", method = RequestMethod.GET)
  public Map<String, List<Object>> getAll(){
    Map<String, List<Object>> response = new HashMap<>();
    List<Object> courses = Arrays.asList(courseHandler.getAll().toArray());
    response.put("Courses",courses);
    return response;
  }
  
  @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
  public void deleteAll(){
     courseHandler.deleteAll();
  }
  
  @RequestMapping(value = "/course/{code}", method = RequestMethod.GET)
  public Map<String, Object> get(@PathVariable String code){
    Map<String, Object> response = new HashMap<>();
    response.put("Course",courseHandler.get(code));
    return response;
  }
  
  @Transactional
  @RequestMapping(value = "/course/{code}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String code){ courseHandler.deleteCourseByCode(code); }
  
  @RequestMapping(value = "/generalInformation", method = RequestMethod.GET)
  public Map<String,Double> getGradeAverage(){
    Map<String, Double> response = new HashMap<>();
    response.put("PAPA", courseHandler.getGradeAverage(courseHandler.getGradableCourses()));
    response.put("PA" ,courseHandler.getGradeAverage(courseHandler.getApprovedCourses()));
    return response;
  }
}
