package com.sebastiangi312.SSKCD.domain.adapter;

import com.sebastiangi312.SSKCD.domain.fabric.CourseFabric;
import com.sebastiangi312.SSKCD.domain.model.GradedCourseWithoutGrade;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeAdapter {
  
  private final CourseFabric fabric;
  
  public GradeAdapter(CourseFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradedCourseWithoutGrade ObjectToGradedCourse(Object course){
    GradeEntity gradedCourse = (GradeEntity)course;
    return fabric.createGradedCourse(gradedCourse.getCourse().getName(),gradedCourse.getCourse().getCode(),
                                      gradedCourse.getCourse().getUnits(),gradedCourse.isApproved(),gradedCourse.getGrade());
  }
}
