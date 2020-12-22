package com.sebastiangi312.SSKCD.domain.adapter;

import com.sebastiangi312.SSKCD.domain.fabric.CourseFabric;
import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import org.springframework.stereotype.Component;

@Component
public class GradeAdapter {
  
  private final CourseFabric fabric;
  
  public GradeAdapter(CourseFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradedCourse ObjectToGradedCourse(Object course){
    GradedCourse gradedCourse = (GradedCourse)course;
    return fabric.createGradedCourse(gradedCourse.getName(),gradedCourse.getCode(),
      gradedCourse.getUnits(),gradedCourse.isApproved(),gradedCourse.getGrade());
  }
}
