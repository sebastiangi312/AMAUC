package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.factory.CourseComandoFactory;
import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
import com.sebastiangi312.SSKCD.domain.Course;
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
  
  
  private final CourseHandler courseHandler;
  private final CourseComandoFactory courseComandoFactory;
  
  public CourseController(CourseHandler courseHandler, CourseComandoFactory courseComandoFactory) {
    this.courseHandler = courseHandler;
    this.courseComandoFactory = courseComandoFactory;
  }
  
  @Transactional
  @RequestMapping(value = "/courses", method = RequestMethod.POST)
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
  public List<Course> getAll(){
    return courseHandler.getAll();
  }
  
  @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
  public void deleteAll(){
     courseHandler.deleteAll();
  }
  
  @RequestMapping(value = "/course/{code}", method = RequestMethod.GET)
  public Course get(@PathVariable String code){ return courseHandler.get(code); }
  
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
