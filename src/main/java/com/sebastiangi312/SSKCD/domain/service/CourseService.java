package com.sebastiangi312.SSKCD.domain.service;

import com.sebastiangi312.SSKCD.domain.model.Course;
import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService {
  
  public double getGradePoint(List<GradedCourse> courses){
    return courses.stream().map(i -> i.getGrade()*i.getUnits()).reduce(0.0, Double::sum)/
           courses.stream().map(Course::getUnits).reduce(0, Integer::sum);
  }
}
