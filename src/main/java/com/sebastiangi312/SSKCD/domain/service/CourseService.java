package com.sebastiangi312.SSKCD.domain.service;

import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
  
  public double getGradePoint(List<GradedCourse> grades){
    return grades.stream().map(i -> i.getGrade()*i.getUnits()).reduce(0.0, Double::sum)/
           grades.stream().map(GradedCourse::getUnits).reduce(0, Integer::sum);
  }
}
