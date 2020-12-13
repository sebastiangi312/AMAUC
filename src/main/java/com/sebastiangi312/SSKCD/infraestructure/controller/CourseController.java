package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
import org.springframework.stereotype.Controller;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {
  
  
  private final CourseHandler courseHandler;
  
  public CourseController(CourseHandler courseHandler) {
    this.courseHandler = courseHandler;
  }
  
  
  public void uploadCourses(String text) {
    List<String[]> courses = parseToList(text);
    courseHandler.saveCourses(courses);
  }
  
  public double getPAPA(){
    double PAPA = courseHandler.getPAPA();
    DecimalFormat df = new DecimalFormat("###.###");
    return Double.parseDouble(df.format(PAPA));
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
  
  
}
