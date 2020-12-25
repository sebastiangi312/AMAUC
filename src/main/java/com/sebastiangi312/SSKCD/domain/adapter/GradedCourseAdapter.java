package com.sebastiangi312.SSKCD.domain.adapter;

import com.sebastiangi312.SSKCD.application.pdu.Course;
import com.sebastiangi312.SSKCD.application.pdu.Grade;
import com.sebastiangi312.SSKCD.domain.fabric.GradedCourseFabric;
import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradedCourseAdapter {
  
  private final GradedCourseFabric fabric;
  
  public GradedCourseAdapter(GradedCourseFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradedCourse ObjectToGradedCourse(Course course, Grade grade){
    return fabric.createGradedCourse(course.getCode(), course.getName(), course.getUnits(),
                                      grade.isApproved(), grade.getGrade(), grade.getDate());
  }
}
