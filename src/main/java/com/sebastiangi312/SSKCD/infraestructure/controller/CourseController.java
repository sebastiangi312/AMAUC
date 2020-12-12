package com.sebastiangi312.SSKCD.infraestructure.controller;

import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

  public double getPAPA(String text){
    List<String[]> courses = parseToList(text);
    return 0;
  }
  
  /*
  
  */
  public List<String[]> parseToList(String coursesInText){
    String[] coursesSeparatedByLines = coursesInText.split("\n");
    List<String> coursesMerged= new LinkedList<>();
    for(int i = 1; i < coursesSeparatedByLines.length; i+=2){
      String courseMerged = coursesSeparatedByLines[i-1].concat("\t").
                            concat(coursesSeparatedByLines[i]);
      coursesMerged.add(courseMerged);
    }
    return coursesMerged.stream().map(i -> i.split("\t")).collect(Collectors.toList());
  }
  
  
}
