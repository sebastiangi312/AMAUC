package com.sebastiangi312.SSKCD.domain.service;

import com.sebastiangi312.SSKCD.domain.model.CourseWithoutGrade;
import com.sebastiangi312.SSKCD.domain.model.GradedCourseWithoutGrade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService {
  
  public double getGradePoint(List<GradedCourseWithoutGrade> courses){
    return courses.stream().map(i -> i.getGrade()*i.getUnits()).reduce(0.0, Double::sum)/
           courses.stream().map(CourseWithoutGrade::getUnits).reduce(0, Integer::sum);
  }
}
