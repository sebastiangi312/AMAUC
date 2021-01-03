package com.sebastiangi312.SSKCD.information.domain.service;

import com.sebastiangi312.SSKCD.information.domain.model.GradedCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
  
  public Double getGradePoint(List<GradedCourse> grades){
    if(grades.isEmpty())
      return 0.0;
    return grades.stream().map(i -> i.getGrade()*i.getUnits()).reduce(0.0, Double::sum)/
           grades.stream().map(GradedCourse::getUnits).reduce(0, Integer::sum);
  }
}
