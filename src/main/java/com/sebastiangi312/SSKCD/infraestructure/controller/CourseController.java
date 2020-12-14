package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
  
  
  private final CourseHandler courseHandler;
  
  public CourseController(CourseHandler courseHandler) {
    this.courseHandler = courseHandler;
  }
  
  @PostMapping
  public ResponseEntity<String> uploadCourses(@RequestBody final String text) {
    List<String[]> courses = parseToList(text);
    courseHandler.saveCourses(courses);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
  public List<String[]> parseToList(String coursesInText) {
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged = new LinkedList<>();
    for (int i = 1; i < coursesSeparatedByLines.length; i += 2) {
      String courseMerged = coursesSeparatedByLines[i - 1].concat("\t").
        concat(coursesSeparatedByLines[i]);
      coursesMerged.add(courseMerged);
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  @GetMapping
  public List<Course> getAll(){
    return courseHandler.getAll();
  }
  
  @GetMapping
  @RequestMapping("{code}")
  public Course get(@PathVariable String code){ return courseHandler.get(code); }
}